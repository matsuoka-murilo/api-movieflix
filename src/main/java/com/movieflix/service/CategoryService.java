package com.movieflix.service;

import com.movieflix.entity.Category;
import com.movieflix.repostitory.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }
}
