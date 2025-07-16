package com.zerock.springex.mapper;

import com.zerock.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    // 시간조회
    String getTime();
    // 저장
    void insert(TodoVO todoVo);
    // 목록 조회
    List<TodoVO> selectAll();
}
