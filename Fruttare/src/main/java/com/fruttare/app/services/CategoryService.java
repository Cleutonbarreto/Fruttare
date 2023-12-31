package com.fruttare.app.services;

import com.fruttare.app.dto.CategoryDTO;
import com.fruttare.app.entities.Category;
import com.fruttare.app.services.exceptions.DatabaseException;
import com.fruttare.app.services.exceptions.ResourceNotFoundException;
import com.fruttare.app.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
        Page<Category> list = repository.findAll(pageRequest);
        return list.map(x -> new CategoryDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id not found: " + id));

        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    public void delete(Long id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> {
                    throw new DatabaseException("Entity Not Found By Id " + id);
                });
    }
}