package com.example.thionline.service;

import com.example.thionline.dto.CategoryQuestionDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryQuestionService {

    List<CategoryQuestionDto> getList();

    List<CategoryQuestionDto> deleteAll();

    List<CategoryQuestionDto> saveAllDataFromExcel(MultipartFile file);
}
