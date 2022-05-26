package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件操作控制器
 */
@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public String upload(@RequestParam("myFile") MultipartFile myFile, HttpServletRequest request) {
        // 获取文件原始名称 txcat.jgp
        String originalFilename = myFile.getOriginalFilename();
        //  实际开发中,一般都要将文件重新命名进行存储
        //  存储到服务器的文件名称=随机字符串+根据实际名称获取到的源文件后缀
        //  根据实际名称获取到源文件的后缀 (字符串截取)  文件名称由服务器创建使用UUID工具类可以自动生成 文件名称
        String fileName = UUID.randomUUID().toString().replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(fileName);
        //  文件的存储路径
        String realPath = request.getServletContext().getRealPath("/uploadFile") + "/";

        try {
            myFile.transferTo(new File(realPath + fileName));  //文件上传到指定的位置
            System.out.println("上传成功:"+realPath + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "ok";
    }

    @RequestMapping("hello")
    public String hello() {
        return "fileHandler";
    }
}