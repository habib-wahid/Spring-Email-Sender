package com.example.springapi.writer;

import com.example.springapi.entity.OrdersDTO;
import com.example.springapi.repository.ShippedOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class OrderWriter implements ItemWriter<OrdersDTO> {
  @Autowired
  ShippedOrderRepository shippedOrderRepository;

  @Override
  public void write(List<? extends OrdersDTO> list) throws Exception {
    log.debug("item writer: {}", list.get(0));
    shippedOrderRepository.saveAllAndFlush(list);
  }
}