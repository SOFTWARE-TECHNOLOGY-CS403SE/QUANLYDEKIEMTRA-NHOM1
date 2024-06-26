package com.example.thionline.service.logic;

import com.example.thionline.dto.ExamDto;
import com.example.thionline.mapper.CategoryQuestionMapper;
import com.example.thionline.mapper.ExamMapper;
import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.model.Exam;
import com.example.thionline.repository.ExamRepository;
import com.example.thionline.service.ExamService;
import com.example.thionline.service.logic.excel.ExamUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamLogic implements ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamLogic(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public List<ExamDto> getList() {

        List<Exam> exams = examRepository.findAll();

        return  exams.stream()
                .map(ExamMapper::dtoMapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamDto> deleteAll() {
        System.err.println("Delete all successfully");
        examRepository.deleteAll();
        return getList();
    }

    @Override
    public List<ExamDto> saveAllDataFromExcel(MultipartFile file) {

        try {
            if(ExamUpload.isValidExcelFile(file)){
                List<Exam> exams = ExamUpload.getFromExcel(file.getInputStream());
                examRepository.saveAll(exams);
                System.out.println("Insert data successfully");
                return getList();
            }
        } catch (IOException err) {
            System.out.println("Error save !" + err);
            throw new IllegalArgumentException(err);
        }
        return null;
    }
}
