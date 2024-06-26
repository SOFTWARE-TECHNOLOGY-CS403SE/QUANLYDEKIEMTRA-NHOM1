package com.example.thionline.mapper;


import com.example.thionline.dto.ExamDetailDto;
import com.example.thionline.model.ExamDetail;

public class ExamDetailMapper {


    public static ExamDetailDto dtoMapTo(ExamDetail examDetail) {

        ExamDetailDto examDetailDto = ExamDetailDto.builder()
                .id(examDetail.getId())
                .categoryQuestion(examDetail.getCategoryQuestion())
                .exam(examDetail.getExam())
                .question(examDetail.getQuestion())
                .result(examDetail.getResult())
                .examTopics(examDetail.getExamTopics())
                .build();

        if (examDetailDto != null) {
            return examDetailDto;
        }else{
            System.out.println("" + null);
            return null;
        }
    }
}
