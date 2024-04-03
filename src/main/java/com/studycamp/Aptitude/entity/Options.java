package com.studycamp.Aptitude.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tbl_options"
)
public class Options {

    @Id @GeneratedValue
    @Column(
            name = "option_id"
    )
    Long id;

    @Column(
            name = "option_A",
            nullable = false
    )
    String optionA;
    @Column(
            name = "option_B",
            nullable = false
    )
    String optionB;
    @Column(
            name = "option_C"
    )
    String optionC;
    @Column(
            name = "option_D"
    )
    String optionD;
    @Column(
            name = "option_E"
    )
    String optionE;
    @Column(
            name = "option_F"
    )
    String optionF;
}
