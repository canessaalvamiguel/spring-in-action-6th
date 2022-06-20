package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
