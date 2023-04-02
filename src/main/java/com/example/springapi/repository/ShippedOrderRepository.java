package com.example.springapi.repository;

import com.example.springapi.entity.OrdersDTO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippedOrderRepository extends JpaRepository<OrdersDTO,Long> {
}
