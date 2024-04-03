package com.studycamp.Aptitude.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "tbl_answers"
)
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "answer_id")
    Long id;

    @Column(
            name = "correct_option",
            nullable = false
    )
    String option;

    @Column(
            name = "correct_answer",
            nullable = false
    )
    String answer;

    @Column(
            name = "explanation"
    )
    String explanation;
}
