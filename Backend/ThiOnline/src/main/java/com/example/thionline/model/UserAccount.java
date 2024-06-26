package com.example.thionline.model;


import com.example.thionline.constant.EnumConstant;
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
@Table(name = "users")
@Getter
@Setter
public class UserAccount {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EnumConstant type;

    @Enumerated(EnumType.STRING)
    @Column(name = "active")
    private EnumConstant active;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.REMOVE)
    @JsonManagedReference("user-exam_topics")
    private List<ExamTopic> examTopics = new ArrayList<>();

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.REMOVE)
    @JsonManagedReference("user-user_selects")
    private List<UserSelect> userSelects = new ArrayList<>();







}
