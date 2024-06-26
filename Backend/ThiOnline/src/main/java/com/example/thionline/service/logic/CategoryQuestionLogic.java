package com.example.thionline.service.logic;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.mapper.CategoryQuestionMapper;
import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.repository.CategoryQuestionRepository;
import com.example.thionline.service.CategoryQuestionService;
import com.example.thionline.service.logic.excel.CategoryQuestionUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryQuestionLogic extends TestLogic implements CategoryQuestionService {


    private final CategoryQuestionRepository categoryQuestionRepository;


    @Autowired
    public CategoryQuestionLogic(CategoryQuestionRepository categoryQuestionRepository) {
        this.categoryQuestionRepository = categoryQuestionRepository;
    }

    @Override
    public List<CategoryQuestionDto> getList() {

        List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.findAll();

        return categoryQuestions.stream()
                .map(CategoryQuestionMapper::dtoMapTo)
                .collect(Collectors.toList());
    }


    @Override
    public List<CategoryQuestionDto> deleteAll() {
        System.err.println("Delete all successfully");
        categoryQuestionRepository.deleteAll();
        return getList();
    }

    @Override
    public List<CategoryQuestionDto> saveAllDataFromExcel(MultipartFile file) {

        try {
            if(CategoryQuestionUpload.isValidExcelFile(file)){
                List<CategoryQuestion> categoryQuestions = CategoryQuestionUpload.getFromExcel(file.getInputStream());
                categoryQuestionRepository.saveAll(categoryQuestions);
                System.out.println("Insert data successfully");
                return getList();
            }
        } catch (IOException error) {
            System.out.println("Error save !" + error);
            throw new IllegalArgumentException(error);
        }
        return null;
    }


    @Override
    protected void logic() {

    }

    @Override
    public void logic2() {

    }
}
