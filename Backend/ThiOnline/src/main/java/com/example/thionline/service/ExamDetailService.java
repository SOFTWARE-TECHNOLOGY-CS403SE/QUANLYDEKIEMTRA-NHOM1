package com.example.thionline.service;

import com.example.thionline.dto.ExamDetailDto;

import java.util.List;

public interface ExamDetailService {


    List<ExamDetailDto> getList();

    ExamDetailDto save(String category_question_id,
                       String exam_id,
                       String question_id,
                       String result_id);

}
