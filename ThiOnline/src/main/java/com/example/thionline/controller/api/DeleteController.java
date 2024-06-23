package com.example.thionline.controller.api;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.dto.ExamDto;
import com.example.thionline.dto.QuestionDto;
import com.example.thionline.dto.ResultDto;
import com.example.thionline.service.CategoryQuestionService;
import com.example.thionline.service.ExamService;
import com.example.thionline.service.QuestionService;
import com.example.thionline.service.ResultService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeleteController {

    private final CategoryQuestionService categoryQuestionService;
    private final ExamService examService;
    private final QuestionService questionService;
    private final ResultService resultService;

    @Autowired
    public DeleteController(CategoryQuestionService categoryQuestionService, ExamService examService, QuestionService questionService, ResultService resultService) {
        this.categoryQuestionService = categoryQuestionService;
        this.examService = examService;
        this.questionService = questionService;
        this.resultService = resultService;
    }


    @DeleteMapping("/delete_category_question")
    private ResponseEntity<?> delete_category_question(){

        JSONObject jsonObject = new JSONObject();
        try{
            List<CategoryQuestionDto> categoryQuestionDtos = categoryQuestionService.deleteAll();
            return new ResponseEntity<>(categoryQuestionDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_question")
    private ResponseEntity<?> delete_question(){

        JSONObject jsonObject = new JSONObject();
        try{
            List<QuestionDto>  questionDtos = questionService.deleteAll();
            return new ResponseEntity<>(questionDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_exam")
    private ResponseEntity<?> delete_exam(){

        JSONObject jsonObject = new JSONObject();
        try{
            List<ExamDto>  examDtos = examService.deleteAll();
            return new ResponseEntity<>(examDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_result")
    private ResponseEntity<?> delete_result(){

        JSONObject jsonObject = new JSONObject();
        try{
            List<ResultDto>  resultDtos = resultService.deleteAll();
            return new ResponseEntity<>(resultDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
