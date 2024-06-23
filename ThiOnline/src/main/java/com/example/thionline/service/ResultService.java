package com.example.thionline.service;

import com.example.thionline.dto.ResultDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResultService {


    List<ResultDto> getList();

    List<ResultDto> deleteAll();

    List<ResultDto> saveAllDataFromExcel(MultipartFile file);
}
