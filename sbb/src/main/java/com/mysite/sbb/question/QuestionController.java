package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller

public class QuestionController {

    private final QuestionService questionsService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionsService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    @GetMapping(value = "/detail/{id}")

    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionsService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    
}
