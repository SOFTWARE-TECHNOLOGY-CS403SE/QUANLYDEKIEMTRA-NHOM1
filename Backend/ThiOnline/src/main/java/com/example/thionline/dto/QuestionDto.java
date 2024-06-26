package com.example.thionline.dto;


import com.example.thionline.model.ExamDetail;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class QuestionDto {


    private String id;
    private String content;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String note;
    private List<ExamDetail> examDetails = new ArrayList<>();
}
