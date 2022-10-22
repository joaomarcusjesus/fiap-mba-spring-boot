package br.com.fiap.avctechapi.application;

import br.com.fiap.avctechapi.application.dto.OrderDto;
import br.com.fiap.avctechapi.application.dto.OrderResponseDto;

import java.util.List;

public interface OrderApplication {
    void createOrder(OrderDto orderDto) throws Exception;
    List<OrderResponseDto> listOrderByOperatorId(Long operatorId);
}