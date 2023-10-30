package com.fruttare.app.services;

import com.fruttare.app.dto.ProductDTO;
import com.fruttare.app.entities.Product;
import com.fruttare.app.repositories.ProductRepository;
import com.fruttare.app.services.exceptions.DatabaseException;
import com.fruttare.app.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
        Page<Product> list = repository.findAll(pageRequest);
        return list.map(x -> new ProductDTO(x));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        //entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id not found: " + id));

      //  entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    public void delete(Long id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> {
                    throw new DatabaseException("Entity Not Found By Id " + id);
                });
    }
}