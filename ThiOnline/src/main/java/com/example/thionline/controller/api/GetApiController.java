package com.example.thionline.controller.api;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.service.CategoryQuestionService;
import com.example.thionline.service.ExamService;
import com.example.thionline.service.QuestionService;
import com.example.thionline.service.ResultService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class GetApiController {

    private final CategoryQuestionService categoryQuestionService;
    private final ExamService examService;
    private final QuestionService questionService;
    private final ResultService resultService;

    @Autowired
    public GetApiController(CategoryQuestionService categoryQuestionService, ExamService examService, QuestionService questionService, ResultService resultService) {
        this.categoryQuestionService = categoryQuestionService;
        this.examService = examService;
        this.questionService = questionService;
        this.resultService = resultService;
    }


    @GetMapping("/test")
    private ResponseEntity<?> index(){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("message", "hello world!");
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }catch (Exception error){
            jsonObject.put("error", error);
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
    }


    @GetMapping("/get_category_question")
    private ResponseEntity<?> get_category_question(){
        JSONObject jsonObject = new JSONObject();
        try{
            List<CategoryQuestionDto> categoryQuestionDtos = categoryQuestionService.getList();
            return new ResponseEntity<>(categoryQuestionDtos, HttpStatus.OK);
        }catch (Exception error){
            jsonObject.put("error", error);
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
    }


    //viết giống như get_category_question thay category_question service là question service
    //service đã được viết sẵn chỉ việc lấy hàm ra dùng
    @GetMapping("/get_question")
    private ResponseEntity<?> get_question(){
        JSONObject jsonObject = new JSONObject();
        try{
            //todo...


            return new ResponseEntity<>("todo...", HttpStatus.OK);
        }catch (Exception error){
            jsonObject.put("error", error);
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
    }

    @GetMapping("/get_exam")
    private ResponseEntity<?> get_exam(){
        JSONObject jsonObject = new JSONObject();
        try{
            //todo...


            return new ResponseEntity<>("todo...", HttpStatus.OK);
        }catch (Exception error){
            jsonObject.put("error", error);
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
    }

    @GetMapping("/get_result")
    private ResponseEntity<?> get_result(){
        JSONObject jsonObject = new JSONObject();
        try{
            //todo...


            return new ResponseEntity<>("todo...", HttpStatus.OK);
        }catch (Exception error){
            jsonObject.put("error", error);
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
    }


}
