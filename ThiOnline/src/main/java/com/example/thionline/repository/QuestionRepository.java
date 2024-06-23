package com.example.thionline.repository;

import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface QuestionRepository extends JpaRepository<Question, String> {


}
