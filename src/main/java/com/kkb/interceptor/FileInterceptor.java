package com.kkb.interceptor;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * 验证文件上传后缀处理的拦截器
 */
public class FileInterceptor implements HandlerInterceptor {

    //TODO: bug前端报错，暂时不处理
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {

        //指定文件的路径
        String path = request.getServletContext().getRealPath("/uploadFile")+"/bdcf9a803ff24f2d8b696aa63742c562.jpg";
        //创建相应的响应头信息对象
        HttpHeaders headers = new HttpHeaders();
        //标记以流的方式做出响应
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //以附件的形式相应给用户
        headers.setContentDispositionFormData("attachment", URLEncoder.encode("bdcf9a803ff24f2d8b696aa63742c562.jpg", "UTF-8"));
        File file = new File(path);
        ResponseEntity<byte[]> resp = new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        return resp;
    }


    /**
     * 在文件上传之前 , 判断文件后缀是否合法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        //判定是否是文件上传请求
        if(request instanceof MultipartHttpServletRequest){
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            //遍历文件
            Iterator<String> iterator = fileMap.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                MultipartFile file = multipartRequest.getFile(key);
                String originalFilename = file.getOriginalFilename();
                //获取文件后缀
                String hz = originalFilename.substring(originalFilename.lastIndexOf("."));
                //判定文件后缀是否符合要求
                if(!hz.toLowerCase().equals(".png") && !hz.toLowerCase().equals(".jpg")){
                    request.getRequestDispatcher("/jsp/FileTypeError.jsp").forward(request, response);
                    flag = false;
                }
            }
        }
        return flag;
    }
}
