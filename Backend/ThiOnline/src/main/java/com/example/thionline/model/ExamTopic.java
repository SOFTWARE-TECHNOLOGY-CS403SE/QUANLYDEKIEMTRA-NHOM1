package com.example.thionline.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exam_topics")
@Getter
@Setter
public class ExamTopic {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private int number_question;
    private Date start_time;
    private Date end_time;
    private int number_time;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_topic-users")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "exam_detail_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("exam_topic-exam_details")
    private ExamDetail examDetail;

    @OneToMany(mappedBy = "examTopic", cascade = CascadeType.REMOVE)
    @JsonManagedReference("exam_topic-select_details")
    private List<SelectDetail> selectDetails = new ArrayList<>();


}