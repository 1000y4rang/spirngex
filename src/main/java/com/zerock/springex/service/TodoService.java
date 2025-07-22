package com.zerock.springex.service;

import com.sun.tools.javac.comp.Todo;
import com.zerock.springex.dto.PageRequestDTO;
import com.zerock.springex.dto.PageResponseDTO;
import com.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    // 저쟝
    void register(TodoDTO todoDTO);
    // 전체 조회
    List<TodoDTO> selectAll();
    // 상세조회
    TodoDTO selectOne(Long tno);
    // 삭제
    void remove(Long tno);
    // 수정
    void modify(TodoDTO todoDTO);
    // 페이징 조회
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
