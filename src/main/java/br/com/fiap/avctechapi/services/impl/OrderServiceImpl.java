package br.com.fiap.avctechapi.services.impl;

import br.com.fiap.avctechapi.handle.exceptions.MaxAssistsException;
import br.com.fiap.avctechapi.handle.exceptions.MinimumAssistRequiredException;
import br.com.fiap.avctechapi.model.Assistance;
import br.com.fiap.avctechapi.model.Order;
import br.com.fiap.avctechapi.repository.AssistanceRepository;
import br.com.fiap.avctechapi.repository.OrderRepository;
import br.com.fiap.avctechapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private AssistanceRepository assistanceRepository;


    public OrderServiceImpl(
            @Autowired OrderRepository orderRepository,
            @Autowired AssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) throws Exception {
        ArrayList<Assistance> peoples = new ArrayList<>();
        arrayAssists.forEach( i -> {
            Optional<Assistance> assistance = assistanceRepository.findById(i);
            peoples.add(assistance.get());
        });

        order.setAssists(peoples);

        if(!order.hasMinAssists()) {
            throw new MinimumAssistRequiredException("Invalid Assists", "Necessário no minimo 1 assistências");
        }else if (order.exceedsMaxAssists()){
            throw new MaxAssistsException("Invalid Assists", "Número máximo de assistências é 15");
        }
        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrderByOperator(Long operatorId) {
        return orderRepository.getOrdersByOperatorId(operatorId);
    }
}