package com.fruttare.app.services;

import com.fruttare.app.dto.CategoryDTO;
import com.fruttare.app.entities.Category;
import com.fruttare.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO > findAll() {
        List<Category> list= repository.findAll();

        return  list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

    }

}
