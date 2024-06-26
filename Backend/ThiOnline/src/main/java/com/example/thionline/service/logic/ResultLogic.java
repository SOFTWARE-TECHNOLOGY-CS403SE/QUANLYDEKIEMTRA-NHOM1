package com.example.thionline.service.logic;

import com.example.thionline.dto.ResultDto;
import com.example.thionline.mapper.ResultMapper;
import com.example.thionline.model.Result;
import com.example.thionline.repository.ResultRepository;
import com.example.thionline.service.ResultService;
import com.example.thionline.service.logic.excel.ResultUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ResultLogic implements ResultService {

    private final ResultRepository resultRepository;


    @Autowired
    public ResultLogic(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }


    @Override
    public List<ResultDto> getList() {

        List<Result> results = resultRepository.findAll();

        return  results.stream()
                .map(ResultMapper::dtoMapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDto> deleteAll() {
        System.err.println("Delete all successfully");
        resultRepository.deleteAll();
        return getList();
    }
    @Override
    public List<ResultDto> saveAllDataFromExcel(MultipartFile file) {
        try {
            if(ResultUpload.isValidExcelFile(file)){
                List<Result> results = ResultUpload.getFromExcel(file.getInputStream());
                resultRepository.saveAll(results);
                System.out.println("Insert data successfully");
                return getList();
            }
        } catch (IOException error) {

            System.out.println("Error save !" + error);
            throw new IllegalArgumentException(error);
        }
        return null;
    }



}
