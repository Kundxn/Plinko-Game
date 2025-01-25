package com.plinko.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.plinko.game.service.PlankoGameService;

@Controller
public class GameController {

    @Autowired
    private PlankoGameService plankoGameService;

    @GetMapping("/")
    public String showGamePage(Model model) {
        model.addAttribute("gameResult", null);
        return "index";
    }

    @PostMapping("/play")
    public String playGame(@RequestParam int dropPosition, Model model) {
        String result = plankoGameService.playPlinkoGame(dropPosition);
        model.addAttribute("gameResult", result);
        return "index";
    }
}
