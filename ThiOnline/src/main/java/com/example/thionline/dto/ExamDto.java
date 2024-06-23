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
public class ExamDto {

    private String id;
    private String name;
    private String description;
    private List<ExamDetail> examDetails = new ArrayList<>();


}
