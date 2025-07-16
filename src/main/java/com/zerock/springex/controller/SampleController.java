package com.zerock.springex.controller;

import com.zerock.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

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

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "1000y4rang") String name
                    , @RequestParam(name = "age", defaultValue = "20") int age){

        log.info("name:"+name+",age:"+age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("dueDate:"+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        model.addAttribute("message","ex4");
    }

    @GetMapping("/ex4_1")
    public void ex4_1(TodoDTO todoDTO, Model model){
    }

    @GetMapping("/ex4_2")
    public void ex4_2(@ModelAttribute("ex4_2") TodoDTO todoDTO, Model model){
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){
        // 리다이렉할 때 쿼리 스트링으로 출력된다. localhost:8080/ex6?name=ABC
        redirectAttributes.addAttribute("name","ABC");
        // 리다이렉할 때 한번만 일회용으로 JSP화면에 출력된다.
        // redirectAttributes.addFlashAttribute("result","success");

        // @GetMapping("/ex6") 로 간다.
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1:"+p1+",p2:"+p2);
    }
}
