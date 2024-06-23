package com.example.thionline.service;

import com.example.thionline.dto.ExamDto;
import com.example.thionline.dto.QuestionDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExamService {


    List<ExamDto> getList();
    List<ExamDto> deleteAll();
    List<ExamDto> saveAllDataFromExcel(MultipartFile file);
}
