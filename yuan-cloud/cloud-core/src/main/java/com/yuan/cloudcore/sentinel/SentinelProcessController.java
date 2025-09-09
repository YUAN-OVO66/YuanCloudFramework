package com.yuan.cloudcore.sentinel;

import com.yuan.cloudcommon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core")
public class SentinelProcessController {

    @Autowired
    private SentinelProcessManager manager;

    @PostMapping("/sentinel/start")
    public Result<?> start() throws Exception {
        return Result.ok(manager.start());
    }

    @PostMapping("/sentinel/stop")
    public Result<?> stop() {
        return Result.ok(manager.stop());
    }

    @GetMapping("/sentinel/status")
    public Result<?> status() {
        return Result.ok(manager.isRunning()? "Sentinel 正在运行" : "Sentinel 未运行");
    }
}
