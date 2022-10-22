package br.com.fiap.avctechapi.services;

import br.com.fiap.avctechapi.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order, List<Long> arrayAssists) throws Exception;
    List<Order> listOrderByOperator(Long operatorId);

}