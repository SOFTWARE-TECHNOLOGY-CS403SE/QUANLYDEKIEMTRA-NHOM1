package com.example.thionline.controller.api;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.dto.ExamDto;
import com.example.thionline.dto.QuestionDto;
import com.example.thionline.dto.ResultDto;
import com.example.thionline.service.*;
import jakarta.servlet.http.HttpServletRequest;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PostApiController {

    private final CategoryQuestionService categoryQuestionService;
    private final ExamService examService;
    private final QuestionService questionService;
    private final ResultService resultService;
    private final ExamDetailService examDetailService;

    @Autowired
    public PostApiController(CategoryQuestionService categoryQuestionService, ExamService examService, QuestionService questionService, ResultService resultService, ExamDetailService examDetailService) {
        this.categoryQuestionService = categoryQuestionService;
        this.examService = examService;
        this.questionService = questionService;
        this.resultService = resultService;
        this.examDetailService = examDetailService;
    }


    @PostMapping("/create_category_question")
    private ResponseEntity<?> create_category_question(@RequestParam("file") MultipartFile file){

        JSONObject jsonObject = new JSONObject();
        System.err.println("run...");
        if(file.isEmpty()){
            System.err.println("Have not file!!!");
            jsonObject.put("errorMessage", "Have not file!!!");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
        try{
            List<CategoryQuestionDto>  categoryQuestionDtos = categoryQuestionService.saveAllDataFromExcel(file);
            return new ResponseEntity<>(categoryQuestionDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_question")
    private ResponseEntity<?> create_question(@RequestParam("file") MultipartFile file){

        JSONObject jsonObject = new JSONObject();
        System.err.println("run...");
        if(file.isEmpty()){
            System.err.println("Have not file!!!");
            jsonObject.put("errorMessage", "Have not file!!!");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
        try{
            List<QuestionDto>  questionDtos = questionService.saveAllDataFromExcel(file);
            return new ResponseEntity<>(questionDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_exam")
    private ResponseEntity<?> create_exam(@RequestParam("file") MultipartFile file){

        JSONObject jsonObject = new JSONObject();
        System.err.println("run...");
        if(file.isEmpty()){
            System.err.println("Have not file!!!");
            jsonObject.put("errorMessage", "Have not file!!!");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
        try{
            List<ExamDto>  examDtos = examService.saveAllDataFromExcel(file);
            return new ResponseEntity<>(examDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_result")
    private ResponseEntity<?> create_result(@RequestParam("file") MultipartFile file){

        JSONObject jsonObject = new JSONObject();
        System.err.println("run...");
        if(file.isEmpty()){
            System.err.println("Have not file!!!");
            jsonObject.put("errorMessage", "Have not file!!!");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
        try{
            List<ResultDto>  resultDtos = resultService.saveAllDataFromExcel(file);
            return new ResponseEntity<>(resultDtos, HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create_exam_detail")
    private ResponseEntity<?> create_exam_detail(HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();
        System.err.println("run...");
        String category_question_id = request.getParameter("category_question_id");
        String exam_id = request.getParameter("exam_id");
        String question_id = request.getParameter("question_id");
        String result_id = request.getParameter("result_id");
        if(category_question_id == null || exam_id == null ||
            question_id == null || result_id == null){
            System.err.println("Have not!!!");
            jsonObject.put("errorMessage", "Have not file!!!");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
        try{
            examDetailService.save(category_question_id, exam_id, question_id, result_id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch (Exception exception){
            jsonObject.put("errorMessage", exception);
            return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
