package com.example.thionline.service;

import com.example.thionline.dto.QuestionDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getList();

    List<QuestionDto> deleteAll();

    List<QuestionDto> saveAllDataFromExcel(MultipartFile file);
}
