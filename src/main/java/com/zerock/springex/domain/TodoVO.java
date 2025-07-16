package com.zerock.springex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
// @Setter setter대신에 builder를 사용한 듯
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}
