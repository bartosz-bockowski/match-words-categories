package com.example.categories.controller;

import com.example.categories.dto.CategoryDTO;
import com.example.categories.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matchCategory")
public class Controller {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<List<CategoryDTO>> matchCategories(@RequestBody String text) {
        return new ResponseEntity<>(categoryService.matchCategories(text.toLowerCase()), HttpStatus.OK);
    }

}
