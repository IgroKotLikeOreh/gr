package com.example.sweater.controller;

import com.example.sweater.domain.Message;

//import com.example.sweater.game.Flag;
import com.example.sweater.game.Flag;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class Game {


    ArrayList<Flag> flags = new ArrayList<>();
    @GetMapping("/gameu")
    public String game(Model model) {
        flags.add(new Flag("Старк"));
        flags.add(new Flag("Грейджой"));
        flags.add(new Flag("Ланистер"));
        flags.add(new Flag("Таргариен"));
        flags.add(new Flag("Баратеон"));
        flags.add(new Flag("Тирелл"));
        flags.add(new Flag("Талли"));

        model.addAttribute("flags", flags);

        return "gameo";
    }
}
