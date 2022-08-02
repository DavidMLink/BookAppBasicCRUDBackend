package com.yourbookapp.bookapp.controllers;

import java.util.List;

import javax.validation.Valid;

import com.yourbookapp.bookapp.models.Genre;
import com.yourbookapp.bookapp.services.GenreService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenreController {
    private final GenreService genreService;
    
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // Start Here

}