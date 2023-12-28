package com.example.categories.repository;

import com.example.categories.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword findOneByKeyword(String keyword);

}
