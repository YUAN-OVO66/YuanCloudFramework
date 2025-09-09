package com.yuan.cloudcore.sentinel;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Component
@Configuration
public class SentinelProcessManager {

    private Process process;

    @Value("${sentinel.port}")
    private Integer port;

    @Value("${sentinel.url}")
    private String url;

    /**
     * 启动 Sentinel Dashboard
     */
    public synchronized String start() throws Exception {
        if (process != null && process.isAlive()) {
            return "Sentinel 已经在运行";
        }

        process = Runtime.getRuntime().exec(
                "java -Dserver.port="+port+" -Dcsp.sentinel.dashboard.server="+url+":"+port+" -Dproject.name=sentinel-dashboard -jar yuan-cloud/jar/sentinel-dashboard.jar");

        // 标准输出
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[Sentinel INFO] " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // 错误输出
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println("[Sentinel ERROR] " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return "Sentinel 启动中...";
    }

    /**
     * 停止 Sentinel Dashboard
     */
    public synchronized String stop() {
        if (process == null || !process.isAlive()) {
            return "Sentinel 未在运行";
        }

        try {
            process.destroy();
            if (!process.waitFor(5, TimeUnit.SECONDS)) {
                process.destroyForcibly();
            }
            return "Sentinel 已关闭";
        } catch (Exception e) {
            e.printStackTrace();
            return "关闭 Sentinel 失败: " + e.getMessage();
        }
    }

    /**
     * 查询运行状态
     */
    public synchronized boolean isRunning() {
        return process != null && process.isAlive();
    }

    /**
     * 服务结束时自动销毁进程
     */
    @PreDestroy
    public void onShutdown() {
        if (process != null && process.isAlive()) {
            System.out.println("Spring Boot 关闭中，正在销毁 Sentinel 进程...");
            stop();
        }
    }
}

