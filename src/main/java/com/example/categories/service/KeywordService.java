package com.example.categories.service;

import com.example.categories.domain.Keyword;
import com.example.categories.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    public Keyword findByKeyword(String keyword) {
        return keywordRepository.findOneByKeyword(keyword);
    }
    
}
