package com.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default  // PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build(); 에서 기본 값
    @Min(value = 1)
    @Positive
    private int page = 1;   // 초기 선언을 해줘야 함

    @Builder.Default // PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build(); 에서 기본 값
    @Min(value = 1)
    @Max(value = 100)
    @Positive
    private int size = 10;  // 초기 선언을 해줘야 함

    private String link;

    public int getSkip(){
        return (page - 1) * size;
    }

    public String getLink() {
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }

    // 검색용
    private String[] types;     // 타입 t:제목, w:작성자
    private String keyword;     // 검색어
    private boolean finished;   // 완료여부
    private LocalDate from;     // 기간
    private LocalDate to;

    // 체크박스 저장용
    public boolean checkType(String type){
        if(types == null || types.length == 0){
            return false;
        }
        // return t 또는 w
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
