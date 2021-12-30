package com.lys.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileController {
    /**
     * 显示文件列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/showfile")
    public String loadFile(Model model) {
        String url = "F:\\GitHub\\Test1";
        File file = new File(url);
        //    获取路径下的所有文件对象名字
        String[] list = file.list();
        model.addAttribute("list", list);
        return "file/file";
    }

    /**
     * 下载文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping("/downLoad")
    public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
        String url = "F:\\GitHub\\Test1";
        File file = new File(url + "\\" + fileName);
        //   设置响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        //    设置响应方式
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //    设置响应的文件
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        //   将文件以二进制流写回
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }

    /**
     * 跳转到上传页
     *
     * @return
     */
    @RequestMapping("toUpLoad")
    public String toUpLoad() {
        System.out.println("跳转上传页");
        return "/file/upload";
    }

    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    /*@RequestMapping("/upload")
    public String upload( @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
    //    获取文件名
        String filename = file.getOriginalFilename();
    //    如果文件名为空,跳转首页
        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }
        System.out.println("上传的文件名是:" + filename);
    //    默认保存路径
        String url = "src/main/java/com/lys/upload";
        File filePath = new File(url);
    //   文件输入流
        InputStream is = file.getInputStream();
    //    文件输输入流
        FileOutputStream os = new FileOutputStream(new File(filePath, filename));
        //    读取
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }*/

    @RequestMapping("/upload")
    public String upload(Model model,@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        // 强制转换
        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
//		req.getParamter
        if(file!=null&&!file.isEmpty()) {
            // 保存服务器文件的名字
            String serverFileName = "";
            String fileDir = "fileupload";
            String serverFilePath = request.getServletContext().getRealPath("/");

            // 上传的文件
            File uploadpath = new File(serverFilePath + "/fileupload");
            System.out.println("路径："+uploadpath.getPath());

            if (!uploadpath.exists()) {
                uploadpath.mkdirs();
            }

//  	    获取文件名字   新建文件.jpg   20210108152054123.jpg
            String  fileName = file.getOriginalFilename();
            //  获取文件后缀名  带点
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            // 获取时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            // 获取前缀
            String prefix = sdf.format(date);
            //  以UUID
//			UUID uuid = UUID.randomUUID();
//			String prefix = uuid.toString().replaceAll("-", "");
            // 新的文件名
            serverFileName = prefix+suffix;
            serverFilePath = request.getServletContext().getRealPath("/")+fileDir + "/" + serverFileName;
            //           输出
            System.out.println(serverFilePath);

            try {
                OutputStream out = new FileOutputStream(serverFilePath);
                byte[] bt = file.getBytes();
                out.write(bt);
                out.flush();
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//	        model.addAttribute("msg", "上传成功");
            req.setAttribute("msg", "上传成功");
        }
        return "file/upload";
    }
}
