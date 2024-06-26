package com.example.thionline.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "select_details")
@Getter
@Setter
public class SelectDetail {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private int number_correct_answer;
    private double point;

    @ManyToOne
    @JoinColumn(name = "user_select_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("select_detail-user_selects")
    private UserSelect userSelect;

    @ManyToOne
    @JoinColumn(name = "exam_topic_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("select_detail-exam_topics")
    private ExamTopic examTopic;



}
