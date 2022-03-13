package com.yklis.keygenweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yklis.util.CommFunction;

@RestController
@RequestMapping("/")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping("static/api/enCrypt")
    public String enCryptStr(HttpServletRequest request,
            HttpServletResponse response,
            //如required设置为true,则地址栏中访问http://localhost:8080/YkLis/login时,因校验不通过,页面报错
            @RequestParam(value = "seed",required = false) String seed,
            @RequestParam(value = "src_string",required = false) String src_string) {
    	
    	return CommFunction.enCryptStr(src_string, seed);    	
    }
    
    @RequestMapping("static/api/deCrypt")
    public String deCryptStr(HttpServletRequest request,
            HttpServletResponse response,
            //如required设置为true,则地址栏中访问http://localhost:8080/YkLis/login时,因校验不通过,页面报错
            @RequestParam(value = "seed",required = false) String seed,
    		@RequestParam(value = "en_string",required = false) String en_string) {
    	
    	return CommFunction.deCryptStr(en_string, seed);
    }
}