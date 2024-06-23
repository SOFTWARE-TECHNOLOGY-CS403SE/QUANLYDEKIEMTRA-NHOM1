package com.example.thionline.service.logic;

import com.example.thionline.dto.QuestionDto;
import com.example.thionline.mapper.QuestionMapper;
import com.example.thionline.model.Question;
import com.example.thionline.repository.QuestionRepository;
import com.example.thionline.service.QuestionService;
import com.example.thionline.service.logic.excel.QuestionUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuestionLogic implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionLogic(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionDto> getList() {

        List<Question> questions = questionRepository.findAll();

        return  questions.stream()
                .map(QuestionMapper::dtoMapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDto> deleteAll() {

        questionRepository.deleteAll();
        return getList();
    }

    @Override
    public List<QuestionDto> saveAllDataFromExcel(MultipartFile file) {

        try {
            if(QuestionUpload.isValidExcelFile(file)){
                List<Question> questions = QuestionUpload.getFromExcel(file.getInputStream());
                questionRepository.saveAll(questions);
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
