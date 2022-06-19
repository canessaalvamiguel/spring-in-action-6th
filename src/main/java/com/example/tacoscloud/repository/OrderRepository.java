package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {

}
