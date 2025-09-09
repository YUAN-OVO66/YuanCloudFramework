package com.yuan.cloudcore.file;



import com.yuan.cloudcommon.utils.Result;
import com.yuan.cloudcore.file.entity.FileDetail;
import com.yuan.cloudcore.file.mapper.FileDetailMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/core/file")
public class FileController {

    private final FileStorageService fileStorageService;

    @Autowired
    private FileDetailMapper fileDetailMapper;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping(value = "/download")
    public void download(@NotNull @NotEmpty String url, HttpServletResponse response) throws IOException {
        // 获取文件信息
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl(url);

        // 下载到 ByteArrayOutputStream 中
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        fileStorageService.download(fileInfo).outputStream(outStream);

        // 设置响应内容类型
        response.setContentType("application/octet-stream");
        // 设置响应头让浏览器知道这是一个附件并且应该如何命名
        response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileInfo.getFilename(), String.valueOf(StandardCharsets.UTF_8)) + "\"");
        // 设置响应的内容长度
        response.setContentLength(outStream.size());

        // 将 ByteArrayOutputStream 的内容写入到 HttpServletResponse 的 OutputStream 中
        try (OutputStream outputStream = response.getOutputStream()) {
            outStream.writeTo(outputStream);
            outputStream.flush();
        }
    }

    @PostMapping("/upload")
    @ResponseBody
    public Result<Map<String,Object>> upload(@NotNull @RequestParam("file") MultipartFile file) {
        Map<String,Object> result=new HashMap<>();
        try {
            FileInfo fileInfo = fileStorageService.of(file)
                    .upload();
            result.put("url",fileInfo.getUrl());
            result.put("status",true);
            return Result.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            result.put("status",false);
            return Result.fail(e.getMessage());
        }
    }

    //删除文件
    @DeleteMapping("/delete")
    @ResponseBody
    public Result<Map<String,Object>> delete(@NotNull @RequestParam("url") String url) {
        Map<String,Object> result=new HashMap<>();
        try {
            fileStorageService.delete(url);
            result.put("status",true);
            return Result.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            result.put("status",false);
            return Result.fail(e.getMessage());
        }
    }


    @GetMapping("/list")
    @ResponseBody
    public Result list() {
        List<FileDetail> fileDetails = fileDetailMapper.selectList(null);
        return Result.ok(fileDetails);
    }
}
