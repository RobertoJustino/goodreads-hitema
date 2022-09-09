package com.hitema.goodotaku.controllers.api;

import com.hitema.goodotaku.entities.Manga;
import com.hitema.goodotaku.repositories.MangaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MangaApiController {

    private Logger logger = LoggerFactory.getLogger(MangaApiController.class);

    private MangaRepository mangaRepository;

    public MangaApiController(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }


    // liste tous les mangas en JSON
    @GetMapping("/mangas")
    public ResponseEntity<Object> getAllMangas(){
        try {
            Iterable<Manga> mangas = mangaRepository.findAll();
            return new ResponseEntity<Object>(mangas, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mangas/{id}")
    public ResponseEntity<Object> getMangaById(@PathVariable("id") Integer id) {
        try {
            Manga manga = mangaRepository.findById(id).get();
            if(manga != null) {
                return new ResponseEntity<Object>(manga, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


}