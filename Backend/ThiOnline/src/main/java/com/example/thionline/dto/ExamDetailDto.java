package com.example.thionline.dto;


import com.example.thionline.model.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ExamDetailDto {

    private String id;
    private CategoryQuestion categoryQuestion;
    private Exam exam;
    private Question question;
    private Result result;
    private List<ExamTopic> examTopics = new ArrayList<>();
}
