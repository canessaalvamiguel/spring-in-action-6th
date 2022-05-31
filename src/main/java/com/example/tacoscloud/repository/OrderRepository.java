package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
