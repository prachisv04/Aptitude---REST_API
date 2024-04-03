package com.studycamp.Aptitude.controller;

import com.studycamp.Aptitude.entity.Difficulty;
import com.studycamp.Aptitude.entity.Question;
import com.studycamp.Aptitude.entity.Tag;
import com.studycamp.Aptitude.model.QuestionRequest;
import com.studycamp.Aptitude.service.AptitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apt")
public class AptitudeController {

    @Autowired
    private AptitudeService aptitudeService;

    @PostMapping("/{tag}/save")
    public String saveQuestion(@RequestBody QuestionRequest questionRequest , @PathVariable Tag tag){
        return aptitudeService.saveQuestion(questionRequest,tag);
    }

    @PostMapping("/{tag}/saveM")
    public String saveQuestionMuliple(@RequestBody List<QuestionRequest> questionRequest, @PathVariable Tag tag){
        questionRequest.forEach(request -> aptitudeService.saveQuestion(request,tag));
        return "Questions added";
    }


//    get by tag
    @GetMapping("/{tag}")
    public List<Question> getAllQuestions(@PathVariable Tag tag){
        return aptitudeService.getAllQuestionsByTag(tag);
    }

//    get by category and tag

    @GetMapping("/{tag}/category={category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable Tag tag,@PathVariable String category){
        return aptitudeService.getAllQuestionsByTagAndCategory(tag,category);
    }

//  get by difficulty

    @GetMapping("/{tag}/difficulty={difficulty}")
    public List<Question> getAllQuestionsByDifficulty(@PathVariable Tag tag,@PathVariable Difficulty difficulty){
        return aptitudeService.getAllQuestionsByTagAndDifficulty(tag,difficulty);
    }

//    category and difficulty
    @GetMapping("/{tag}/category={category}/difficulty={difficulty}")
    public List<Question> getAllTechQuestionsByDifficultyAndCategory(@PathVariable Tag tag,@PathVariable String category,@PathVariable Difficulty difficulty){
        return aptitudeService.getAllQuestionsByTagAndCategoryAndDifficulty(tag,category,difficulty);
    }

}
