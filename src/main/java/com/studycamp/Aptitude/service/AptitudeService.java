package com.studycamp.Aptitude.service;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Difficulty;
import com.studycamp.Aptitude.entity.Question;
import com.studycamp.Aptitude.entity.Tag;
import com.studycamp.Aptitude.mapper.QuestionMapper;
import com.studycamp.Aptitude.model.QuestionRequest;
import com.studycamp.Aptitude.repository.AptitudeRepository;
import com.studycamp.Aptitude.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptitudeService {

    @Autowired
    AptitudeRepository aptitudeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Question> getAllQuestionsByTag(Tag tag) {
      List<Category> categories= categoryRepository.getByTag(tag);
      return aptitudeRepository.findByCategoryIn(categories);
    }

    public String saveQuestion(QuestionRequest questionRequest , Tag tag) {
        Category cat = categoryRepository.findAllByTagAndName(tag,questionRequest.getCategory());
        if(cat==null){
            return "Category with given Name not found";
        }
        Question que = new QuestionMapper().mapTo(questionRequest,cat);
        aptitudeRepository.save(que);
        return "Question Added, Thank You!";
    }

    public List<Question> getAllQuestionsByTagAndCategory(Tag tag, String name) {
        List<Category> categories= categoryRepository.getByTagAndName(tag,name);
        return aptitudeRepository.findByCategoryIn(categories);
    }

    public List<Question> getAllQuestionsByTagAndDifficulty(Tag tag , Difficulty difficulty){
        List<Category> categories= categoryRepository.getByTag(tag);
        return aptitudeRepository.findByDifficultyAndCategoryIn(difficulty,categories);
    }

    public List<Question> getAllQuestionsByTagAndCategoryAndDifficulty(Tag tag, String category, Difficulty difficulty) {
        List<Category> categories= categoryRepository.getByTagAndName(tag,category);
        return aptitudeRepository.findByDifficultyAndCategoryIn(difficulty,categories);
    }
}
