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
public class ResultDto {

    private String id;
    private String correct_answer;
    private String note;
    private List<ExamDetail> examDetails = new ArrayList<>();



}
