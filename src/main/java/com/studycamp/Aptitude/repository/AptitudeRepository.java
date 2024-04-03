package com.studycamp.Aptitude.repository;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Difficulty;
import com.studycamp.Aptitude.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AptitudeRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategoryIn(List<Category> categories);

    List<Question> findByDifficultyAndCategoryIn(Difficulty difficulty, List<Category> categories);

}
