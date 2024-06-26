package com.example.thionline.service.logic;

import com.example.thionline.dto.ExamDetailDto;
import com.example.thionline.mapper.CategoryQuestionMapper;
import com.example.thionline.mapper.ExamDetailMapper;
import com.example.thionline.model.*;
import com.example.thionline.repository.*;
import com.example.thionline.service.ExamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamDetailLogic implements ExamDetailService {

    private final ExamDetailRepository examDetailRepository;
    private final ExamRepository examRepository;
    private final ResultRepository resultRepository;
    private final CategoryQuestionRepository categoryQuestionRepository;
    private final QuestionRepository questionRepository;


    @Autowired
    public ExamDetailLogic(ExamDetailRepository examDetailRepository, ExamRepository examRepository, ResultRepository resultRepository, CategoryQuestionRepository categoryQuestionRepository, QuestionRepository questionRepository) {
        this.examDetailRepository = examDetailRepository;
        this.examRepository = examRepository;
        this.resultRepository = resultRepository;
        this.categoryQuestionRepository = categoryQuestionRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public List<ExamDetailDto> getList() {
        List<ExamDetail> examDetails = examDetailRepository.findAll();

        return  examDetails.stream()
                .map(ExamDetailMapper::dtoMapTo)
                .collect(Collectors.toList());
    }

    @Override
    public ExamDetailDto save(String category_question_id, String exam_id,
                                String question_id, String result_id) {

        CategoryQuestion categoryQuestion = categoryQuestionRepository.getReferenceById(category_question_id);
        Question question = questionRepository.getReferenceById(question_id);
        Exam exam = examRepository.getReferenceById(exam_id);
        Result result = resultRepository.getReferenceById(result_id);

        ExamDetail examDetail = new ExamDetail();
        examDetail.setExam(exam);
        examDetail.setQuestion(question);
        examDetail.setCategoryQuestion(categoryQuestion);
        examDetail.setResult(result);
        ExamDetail examDetail_new = examDetailRepository.save(examDetail);

        ExamDetailDto examDetailDto = new ExamDetailDto();
        examDetailDto.setId(examDetail_new.getId());
        examDetailDto.setCategoryQuestion(examDetail_new.getCategoryQuestion());
        examDetailDto.setExam(examDetail_new.getExam());
        examDetailDto.setQuestion(examDetail_new.getQuestion());
        examDetailDto.setResult(examDetail_new.getResult());

        return examDetailDto;
    }


}
