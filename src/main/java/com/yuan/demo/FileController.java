package com.yuan.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {


    @PostMapping("/upLoadFile")
    public String updateLoadFile(@RequestParam(value = "file") MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return "上传失败 请重新尝试！！！！";
        }
        //1. 创建存放的路径
        File path=new File(".");
        File upload=new File(path.getAbsolutePath(),"/upload/");//创建存放文件的 文件夹
        if (!upload.exists()){
            upload.mkdirs();//创建路径文件夹
        }
        //2.设置文件名
        String fileName=multipartFile.getOriginalFilename();//上传的文件名
        String suffixName=fileName.substring(fileName.lastIndexOf("."));//获得后缀
        fileName= UUID.randomUUID()+suffixName;//存储的文件名

        //3.配置存放的文件
        File data=new File(upload.getPath()+"/"+fileName);
        //4.保存文件
        try {
            multipartFile.transferTo(data);
            return "上传成功";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "上传失败 请重新尝试！！！！";
    }
    @PostMapping("/upLoadFiles")
    public String updateLoadFiles(@RequestParam(value = "files") MultipartFile[] multipartFile){
        StringBuilder strTemp= new StringBuilder();
        for (MultipartFile file:multipartFile){
            File path=new File(".");
            File upload=new File(path.getAbsolutePath(),"/upload/");//创建存放文件的 文件夹
            if (!upload.exists()){
                upload.mkdirs();//创建路径文件夹
            }
            //2.设置文件名
            String fileName=file.getOriginalFilename();//上传的文件名
            String suffixName=fileName.substring(fileName.lastIndexOf("."));//获得后缀
            fileName= UUID.randomUUID()+suffixName;//存储的文件名

            //3.配置存放的文件
            File data=new File(upload.getPath()+"/"+fileName);
            //4.保存文件
            try {
                file.transferTo(data);
            }catch (IOException e){
                e.printStackTrace();
            }
            strTemp.append(file.getOriginalFilename()).append("上传成功\n");
        }
        return strTemp.toString();
    }

    @GetMapping("/downLoadFile")
    public String downLoadFile(String fileName, HttpServletResponse response){

        try {
            //1.读取文件流
            File path=new File(".");
            File upload=new File(path.getAbsolutePath(),"/upload/");
            File file=new File(upload.getPath()+"/"+fileName);
            FileInputStream fileInputStream=new FileInputStream(file);
            //2.创建response 输出对象流
            response.setContentType("application/force-download");
            response.addHeader("Content-disposition", "attachment;fileName="+fileName);
            ServletOutputStream os=response.getOutputStream();
            //3.文件流写入response对象流
            byte[]buf=new byte[1024];
            int len=0;
            while((len=fileInputStream.read(buf))!=-1){
                os.write(buf,0,len);
            }
            fileInputStream.close();
            return "下载成功";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "下载失败";
    }

}
