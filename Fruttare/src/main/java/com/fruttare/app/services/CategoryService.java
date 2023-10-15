package com.fruttare.app.services;

import com.fruttare.app.entities.Category;
import com.fruttare.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
    return repository.findAll();
    }

}
