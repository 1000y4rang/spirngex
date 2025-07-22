package com.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    // 페이징별 시작 번호
    private int start;
    // 페이징별 끝 번호
    private int end;

    // 이전 페이지 존재 여부
    private boolean prev;
    // 다음 페이지 존재 여부
    private boolean next;

    // 이거쓰면 리스트 형식으로 받을 수 있나봄
    // PageResponseDTO<TodoDTO> => List<TodoDTO> ?
    private List<E> dtoList;

    // 생성자
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;
        // 페이지별 마지막 수
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        // 페이지별 첫번째 수
        this.start = this.end - 9;
        int last = (int)(Math.ceil((total / (double)size)));
        this.end = end > last  ? last : end;
        // 페이지별 첫번째 수가 1이 아니면 이전페이지가 필요해
        this.prev = this.start > 1;
        // 페이지별 마지막 수에서 게시글 10을 곱해서 데이터 전체수 보다 작아야 다음 페이지가 있음
        this.next = total > this.end * this.size;

    }
}
