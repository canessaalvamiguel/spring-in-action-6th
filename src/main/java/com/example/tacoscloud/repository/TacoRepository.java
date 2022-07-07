package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.Taco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface TacoRepository extends CrudRepository<Taco, Long> {
    Iterable<Taco> findAll(Pageable pageable);
}
