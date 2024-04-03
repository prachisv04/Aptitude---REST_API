package com.studycamp.Aptitude.model;

import com.studycamp.Aptitude.entity.Answer;
import com.studycamp.Aptitude.entity.Category;
import com.studycamp.Aptitude.entity.Difficulty;
import com.studycamp.Aptitude.entity.Options;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionRequest {

    String question;
    Options options;
    Answer answer;
    String Category;
    Difficulty difficulty;

}
