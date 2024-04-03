package com.studycamp.Aptitude.repository;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
//    List<Category> findAllByTag(Tag tag);
//
//    List<String> findNameByTag(Tag tag);

    List<String> findCategoryNameByTag(Tag tag);

    List<Category> findAllByTag(Tag tag);

    List<Category> getByTag(Tag tag);

    Category findAllByTagAndName(Tag tag, String category);

    List<Category> getByTagAndName(Tag tag, String name);


}
