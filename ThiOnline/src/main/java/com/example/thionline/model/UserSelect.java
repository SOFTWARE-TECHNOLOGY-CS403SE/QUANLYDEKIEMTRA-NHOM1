package com.example.thionline.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_selects")
@Getter
@Setter
public class UserSelect {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String answer;
    private int true_or_false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    //annotion này giúp gỡ lỗi lặp vô hạn khi ánh xạ
    @JsonBackReference("user_select-users")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "userSelect", cascade = CascadeType.REMOVE)
    @JsonManagedReference("user_select-select_details")
    private List<SelectDetail> selectDetails = new ArrayList<>();

}
