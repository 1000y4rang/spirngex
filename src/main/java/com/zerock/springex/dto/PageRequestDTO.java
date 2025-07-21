package com.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

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

    public int getSkip(){
        return (page - 1) * size;
    }
}
