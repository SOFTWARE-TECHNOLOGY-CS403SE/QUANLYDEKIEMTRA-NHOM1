package com.example.thionline.mapper;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.dto.ResultDto;
import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.model.Result;

public class ResultMapper {

    public static ResultDto dtoMapTo(Result result) {

        ResultDto resultDto = ResultDto.builder()
                .id(result.getId())
                .correct_answer(result.getCorrect_answer())
                .note(result.getNote())
                .examDetails(result.getExamDetails())
                .build();

        if (resultDto != null) {
            return resultDto;
        }else{
            System.out.println("" + null);
            return null;
        }
    }
}
