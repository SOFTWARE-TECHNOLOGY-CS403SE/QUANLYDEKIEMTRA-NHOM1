package com.example.thionline.dto;


import com.example.thionline.model.ExamDetail;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CategoryQuestionDto {



    private String id;
    private String category_name;
    private List<ExamDetail> examDetails = new ArrayList<>();


}
