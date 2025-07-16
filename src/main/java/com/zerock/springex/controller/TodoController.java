package com.zerock.springex.controller;

import com.zerock.springex.dto.TodoDTO;
import com.zerock.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(){
        log.info("/todo/list...");
    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(@Valid TodoDTO  todoDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        // dto에서 유효성 검사를 통과하지 못할 경우...
        if(bindingResult.hasErrors()){
            log.info("validation error");
            log.info(bindingResult.getAllErrors());
            // 안되는 듯
            // redirectAttributes.addFlashAttribute("dto_errors",bindingResult.getAllErrors());
        }

        // 저장
        todoService.register(todoDTO);
        
        return "redirect:/todo/list";
    }
}
