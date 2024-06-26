package com.example.thionline.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category_questions")
@Getter
@Setter
public class CategoryQuestion {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String category_name;

    @OneToMany(mappedBy = "categoryQuestion", cascade = CascadeType.REMOVE)
    @JsonManagedReference("category_question-exam_details")
    private List<ExamDetail> examDetails = new ArrayList<>();





}
