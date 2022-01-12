package fr.ensup.demospringboot.controller;

import fr.ensup.demospringboot.domaine.Music;
import fr.ensup.demospringboot.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AppController {
    @Autowired
    private MusicService musicService;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        Iterable<Music> listProducts = musicService.listAll();
        model.addAttribute("listMusique", listProducts);
        return "index";
    }
}
