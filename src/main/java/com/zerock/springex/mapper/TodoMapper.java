package com.zerock.springex.mapper;

import com.zerock.springex.domain.TodoVO;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVo);
}
