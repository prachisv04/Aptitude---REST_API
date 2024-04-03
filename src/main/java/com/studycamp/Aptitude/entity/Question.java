package com.studycamp.Aptitude.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "tbl_questions"
)
public class Question {
    @Id @GeneratedValue
    @Column(
            name = "question_id"
    )
    Long id;

    @Column(
            name = "question",
            nullable = false
    )
    String question;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false
    )
    @JoinColumn(
            name = "option_id",
            referencedColumnName = "option_id",
            nullable = false
    )
    Options options;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false
    )
    @JoinColumn(
            name = "answer_id",
            referencedColumnName = "answer_id",
            nullable = false
    )
    Answer answer;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "category_id"
    )
    Category category;

    @Column(
            name = "difficulty"
    )
            @Enumerated(EnumType.STRING)
    Difficulty difficulty;
}
