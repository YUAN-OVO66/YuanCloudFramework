package com.yuan.cloudcore.controller;

import com.yuan.cloudcore.process.SentinelProcessManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core")
public class SentinelProcessController {

    @Autowired
    private SentinelProcessManager manager;

    @PostMapping("/sentinel/start")
    public String start() throws Exception {
        return manager.start();
    }

    @PostMapping("/sentinel/stop")
    public String stop() {
        return manager.stop();
    }

    @GetMapping("/sentinel/status")
    public String status() {
        return manager.isRunning() ? "Sentinel 正在运行" : "Sentinel 未运行";
    }
}
