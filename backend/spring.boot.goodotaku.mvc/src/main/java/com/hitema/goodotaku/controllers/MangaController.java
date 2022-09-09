package com.hitema.goodotaku.controllers;

import com.hitema.goodotaku.entities.Genres;
import com.hitema.goodotaku.entities.Manga;
import com.hitema.goodotaku.services.MangaService;
import com.hitema.goodotaku.services.ReviewsMangaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class MangaController {
    private static final Logger log = LoggerFactory.getLogger(MangaController.class);
    @Autowired
    private MangaService service;

    @Autowired
    private ReviewsMangaService serviceReview;

    @RequestMapping("/mangas/list")
    public ModelAndView getAllMangas(ModelMap model, @Param("keyword") String keyword){
        model.addAttribute("mangas", service.readAll(keyword));
        model.addAttribute("keyword", keyword);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mangas");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/mangas/list/details/{id}"})
    public ModelAndView detailsManga(@PathVariable("id") Integer id, Model model) {
        Manga manga = service.read(id);
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("manga", manga);
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manga");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/mangas/list/details/edit/{id}"})
    public ModelAndView editManga(@PathVariable("id") Integer id, Model model) {
        Manga manga = service.read(id);
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("manga", manga);
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manga_form");
        return modelAndView;
    }

    @RequestMapping({"/save","/manga/save"})
    public ModelAndView saveManga(Manga manga) {
        service.update(manga);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manga");
        return modelAndView;
    }

    @RequestMapping("/manga/create")
    public ModelAndView createManga(ModelMap model){
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("manga", new Manga());
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manga_form");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/mangas/list/delete/{id}"})
    public ModelAndView deleteManga(@PathVariable("id") Integer id, Model model) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/mangas/list/details/delete/{id}"})
    public ModelAndView deleteReviewManga(@PathVariable("id") Integer id, Model model) {
        serviceReview.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
