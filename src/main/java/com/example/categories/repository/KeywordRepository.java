package com.example.categories.repository;

import com.example.categories.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Optional<Keyword> findOneByKeyword(String keyword);

}
