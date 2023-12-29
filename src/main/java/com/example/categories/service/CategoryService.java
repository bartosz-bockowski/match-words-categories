package com.example.categories.service;

import com.example.categories.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final KeywordService keywordService;

    private final ModelMapper modelMapper;

    public List<CategoryDTO> matchCategories(String text) {

        List<String> words = List.of(text.split("[.,': =/]"));

        Map<CategoryDTO, Long> categoryOccurrences = words.stream()
                .map(String::toLowerCase)
                .map(keywordService::findByKeyword)
                .filter(Objects::nonNull)
                .flatMap(keyword -> keyword.getCategories().stream())
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<CategoryDTO> result = new ArrayList<>(categoryOccurrences.keySet());

        result.forEach(category -> category.setWordsMatched(categoryOccurrences.get(category).intValue()));

        result.sort(Comparator.comparing(CategoryDTO::getWordsMatched).reversed());

        return result;
    }

}
