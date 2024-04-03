package com.studycamp.Aptitude.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "tbl_category"
)
@ToString
public class Category {
    @Id
    @GeneratedValue
    @Column(
             name = "id"
    )
    Long id;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    String name;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "tag"
    )
    Tag tag;

    public Category(String category, Tag tag) {
        this.name = category;
        this.tag = tag;
    }

}
