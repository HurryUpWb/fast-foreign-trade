package com.fast.trade.controller;


import com.fast.trade.util.alioss.AliOssUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/img")
public class ImageController {


    @GetMapping("/save")
    public String upload(){

        File file = new File("C:\\Users\\wb\\Desktop\\tysti.png");
        return AliOssUtil.uploadFile("FileTest",file);
    }



}
