package com.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

    // 기본 자료형 파라미터
    @GetMapping("/ex1")
    public void ex1(String name, int age){

        log.info("name:"+name+",age:"+age);

    }
}
