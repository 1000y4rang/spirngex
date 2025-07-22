package com.zerock.springex.mapper;

import com.zerock.springex.domain.TodoVO;
import com.zerock.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    // 시간조회
    String getTime();
    // 저장
    void insert(TodoVO todoVo);
    // 목록 조회
    List<TodoVO> selectAll();
    // 상세조회
    TodoVO selectOne(Long tno);
    // 삭제
    void delete(Long tno);
    // 수정
    void update(TodoVO todoVO);
    // 전체 데이터 수
    int getCount(PageRequestDTO pageRequestDTO);
    // 페이징 조회
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
}
