package com.studycamp.Aptitude.mapper;

import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Question;
import com.studycamp.Aptitude.entity.Tag;
import com.studycamp.Aptitude.model.QuestionRequest;

public class QuestionMapper implements Mapper<Question,QuestionRequest>{

    public Question mapTo(QuestionRequest questionRequest, Category category){

        Question question = Question.builder()
                .question(questionRequest.getQuestion())
                .options(questionRequest.getOptions())
                .answer(questionRequest.getAnswer())
                .difficulty(questionRequest.getDifficulty())
                .category(category)
                .build();
        return question;
    }

    public QuestionRequest mapFrom(Question question){
        QuestionRequest questionRequest = QuestionRequest.builder()
                .question(question.getQuestion())
                .options(question.getOptions())
                .answer(question.getAnswer())
                .Category(question.getCategory().getName())
                .difficulty(question.getDifficulty())
                .build();
        return questionRequest;
    }

}
