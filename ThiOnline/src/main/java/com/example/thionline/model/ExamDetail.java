package com.example.thionline.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exam_details")
@Getter
@Setter
public class ExamDetail {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "category_question_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_detail-category_questions")
    private CategoryQuestion categoryQuestion;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_detail-questions")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_detail-results")
    private Result result;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_detail-exams")
    private Exam exam;


    @OneToMany(mappedBy = "examDetail", cascade = CascadeType.REMOVE)
    @JsonManagedReference("exam_detail-exam_topics")
    private List<ExamTopic> examTopics = new ArrayList<>();


}






