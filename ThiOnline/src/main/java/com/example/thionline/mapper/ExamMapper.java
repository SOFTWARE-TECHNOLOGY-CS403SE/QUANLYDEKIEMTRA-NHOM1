package com.example.thionline.mapper;

import com.example.thionline.dto.ExamDto;
import com.example.thionline.dto.QuestionDto;
import com.example.thionline.model.Exam;
import com.example.thionline.model.Question;

public class ExamMapper {




    public static ExamDto dtoMapTo(Exam exam) {

        ExamDto examDto = ExamDto.builder()
                .id(exam.getId())
                .name(exam.getName())
                .description(exam.getDescription())
                .examDetails(exam.getExamDetails())
                .build();

        if (examDto != null) {
            return examDto;
        }else{
            System.out.println("" + null);
            return null;
        }
    }
}
