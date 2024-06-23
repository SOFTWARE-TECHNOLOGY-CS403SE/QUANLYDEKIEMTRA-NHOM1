package com.example.thionline.mapper;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.dto.QuestionDto;
import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.model.Question;

public class QuestionMapper {


    public static QuestionDto dtoMapTo(Question question) {

        QuestionDto questionDto = QuestionDto.builder()
                .id(question.getId())
                .content(question.getContent())
                .note(question.getNote())
                .answer1(question.getAnswer1())
                .answer2(question.getAnswer2())
                .answer3(question.getAnswer3())
                .answer4(question.getAnswer4())
                .examDetails(question.getExamDetails())
                .build();

        if (questionDto != null) {
            return questionDto;
        }else{
            System.out.println("" + null);
            return null;
        }
    }
}
