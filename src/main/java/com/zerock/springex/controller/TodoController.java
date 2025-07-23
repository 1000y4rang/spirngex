package com.zerock.springex.controller;

import com.zerock.springex.dto.PageRequestDTO;
import com.zerock.springex.dto.TodoDTO;
import com.zerock.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /*@RequestMapping("/list")
    public void list(Model model) {
        model.addAttribute("dtoList",todoService.selectAll());
    }*/
    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // @Valid를 통해 파라미터 값이 잘못 들어오면 default 값인 page 1, size 10이 적용됨 
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        model.addAttribute("responseDTO"
                , todoService.getList(pageRequestDTO)); // 페이징 파라미터를 넣으면 페이징 리스트, 페이징에 필요한 값들 리턴

    }


    //@RequestMapping(value = "/register",
    // method = RequestMethod.GET)
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

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model){
        // 상세조회
        TodoDTO dto = todoService.selectOne(tno);
        model.addAttribute("dto",dto);
    }

    @PostMapping("/remove")
    public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
        // 삭제
        todoService.remove(tno);

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO  todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        // 작동안함
        /*if(bindingResult.hasErrors()){
            log.info("validation error");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno",todoDTO.getTno());
            return "redirect:/todo/list";
        }*/

        // 수정
        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

}
