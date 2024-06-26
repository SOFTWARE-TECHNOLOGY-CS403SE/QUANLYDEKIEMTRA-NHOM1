package com.example.thionline.mapper;

import com.example.thionline.dto.CategoryQuestionDto;
import com.example.thionline.model.CategoryQuestion;

public class CategoryQuestionMapper {

    public static CategoryQuestionDto dtoMapTo(CategoryQuestion categoryQuestion) {

        CategoryQuestionDto categoryQuestionDto = CategoryQuestionDto.builder()
                .id(categoryQuestion.getId())
                .category_name(categoryQuestion.getCategory_name())
                .build();

        if (categoryQuestionDto != null) {
            return categoryQuestionDto;
        }else{
            System.out.println("" + null);
            return null;
        }
    }
}
