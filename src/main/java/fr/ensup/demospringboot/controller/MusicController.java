package fr.ensup.demospringboot.controller;

import fr.ensup.demospringboot.domaine.Music;
import fr.ensup.demospringboot.service.MusicService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class MusicController {

    @Autowired
    private MusicService musicService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        log.info("ViewHomePage");

        Iterable<Music> listProducts = musicService.listAll();
        model.addAttribute("listMusique", listProducts);
        return "index";
    }

    @GetMapping("/createMusic")
    public String viewCreateMusicPage(Model model) {
        log.info("viewCreateMusicPage");

        model.addAttribute("music", new Music());
        return "createMusic";
    }

    @PostMapping("/save")
    public String saveMusic(@ModelAttribute Music music) {
        log.info("saveMusic pour la music "+music);

        if (!"".equals(music.getAuthor()) && !"".equals(music.getTitle()))
            musicService.save(music);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {

        ModelAndView mav = new ModelAndView("edit_music");
        Music music = musicService.get(id);
        mav.addObject("music", music);

        log.info("showEditProductPage pour la music: "+music);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        log.info("deleteProduct pour la music d'id :"+id);

        musicService.delete(id);
        return "redirect:/";
    }
}
