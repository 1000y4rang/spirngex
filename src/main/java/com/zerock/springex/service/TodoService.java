package com.zerock.springex.service;

import com.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    // 저쟝
    void register(TodoDTO todoDTO);
    // 전체 조회
    List<TodoDTO> selectAll();
}
