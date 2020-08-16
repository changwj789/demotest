package com.fh.controller;

import com.fh.common.DataTableResult;
import com.fh.common.ServerResponse;
import com.fh.entity.po.MovieParam;
import com.fh.entity.vo.Movie;
import com.fh.service.MovieService;
import com.fh.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("queryMovie")
    public DataTableResult queryMovie(MovieParam movieParam){
        return movieService.queryMovie(movieParam);
    }
    @RequestMapping("addMovie")
    public ServerResponse addMovie(Movie movie){
        return movieService.addMovie(movie);
    }




    @RequestMapping("uploadfile")
    public Map<String,Object> uploadfile(@RequestParam("image") MultipartFile file) throws IOException {
        Map result=new HashMap<String,Object>();
        File toFile=null;
        InputStream ins = null;
        ins = file.getInputStream();
        toFile = new File(file.getOriginalFilename());
        inputStreamToFile(ins, toFile);
        ins.close();
        String s = OssUtil.uploadFile(toFile);
        delteTempFile(toFile);
        result.put("success",true);
        result.put("filePath",s);
        return result;
    }


    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }

    }
}
