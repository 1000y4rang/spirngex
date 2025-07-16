package com.zerock.springex.service;

import com.zerock.springex.domain.TodoVO;
import com.zerock.springex.dto.TodoDTO;
import com.zerock.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> selectAll() {

        List<TodoDTO> list = todoMapper.selectAll().stream()
                .map(todoVO -> modelMapper.map(todoVO, TodoDTO.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public TodoDTO selectOne(Long tno) {

        TodoVO vo = todoMapper.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;
    }
}
