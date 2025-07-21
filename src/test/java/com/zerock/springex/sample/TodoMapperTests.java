package com.zerock.springex.sample;

import com.zerock.springex.domain.TodoVO;
import com.zerock.springex.dto.PageRequestDTO;
import com.zerock.springex.dto.TodoDTO;
import com.zerock.springex.mapper.TodoMapper;
import com.zerock.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)  // spring-test를 이용하기 위한 설정. (JUnit5버전)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Autowired(required = false)
    private TodoService todoService;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVo = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2025, 7, 16))
                .writer("user00")
                .build();

        todoMapper.insert(todoVo);
    }

    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("스프링 테스트2")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();
        todoService.register(todoDTO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> list = todoMapper.selectAll();
        list.forEach(todoVO -> log.info(todoVO));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(2L);
        log.info(todoVO);
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                                    //.page(3)
                                    //.size(10)
                                    .build();
        List<TodoVO> list = todoMapper.selectList(pageRequestDTO);
        list.forEach(todoVO -> log.info(todoVO));
    }
}
