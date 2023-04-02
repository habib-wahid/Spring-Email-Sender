package com.example.springapi.processor;
import com.example.springapi.entity.OrdersDTO;
import com.example.springapi.processor.email.EmailSenderService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderItemProcessor implements ItemProcessor<OrdersDTO, OrdersDTO> {

  @Autowired
  EmailSenderService emailSenderService;

  @Override
  public OrdersDTO process(OrdersDTO item) throws Exception {
    System.out.println("Sending email to "+ item.getEmail());
    emailSenderService.sendSimpleEmail(item.getEmail(), "hello","welcome");
    return item;
  }
}
