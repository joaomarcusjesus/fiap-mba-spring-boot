package br.com.fiap.avctechapi.application.impl;

import br.com.fiap.avctechapi.application.OrderApplication;
import br.com.fiap.avctechapi.application.dto.AssistDto;
import br.com.fiap.avctechapi.application.dto.LocationDto;
import br.com.fiap.avctechapi.application.dto.OrderDto;
import br.com.fiap.avctechapi.application.dto.OrderResponseDto;
import br.com.fiap.avctechapi.model.Assistance;
import br.com.fiap.avctechapi.model.Location;
import br.com.fiap.avctechapi.model.Order;
import br.com.fiap.avctechapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public void createOrder(OrderDto orderDto) throws Exception {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEnd()));
        this.orderService.saveOrder(order, orderDto.getAssists());
    }

    @Override
    public List<OrderResponseDto> listOrderByOperatorId(Long operatorId){
        return orderService.listOrderByOperator(operatorId).stream().map(
                (order) -> new OrderResponseDto(order.getId(), order.getOperatorId(), order.getAssists().stream().map(this::mapAssistToDto).collect(Collectors.toList()), mapOrderLocationToDto(order.getStartOrderLocation()), mapOrderLocationToDto(order.getEndOrderLocation()))
        ).collect(Collectors.toList());
    }
    private AssistDto mapAssistToDto(Assistance assist){
        return new AssistDto(assist.getId(), assist.getName(), assist.getDescription());
    }
    private Location getOrderLocationFromOrderLocationDto(LocationDto locationDTo){
        Location locationAddress = new Location();
        locationAddress.setLatitude(locationDTo.getLatitude());
        locationAddress.setLongitude(locationDTo.getLongitude());
        locationAddress.setDate(locationDTo.getDateTime());
        return locationAddress;
    }

    private LocationDto mapOrderLocationToDto(Location orderLocation){
        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(orderLocation.getLatitude());
        locationDto.setLongitude(orderLocation.getLongitude());
        locationDto.setDateTime(orderLocation.getDate());
        return locationDto;
    }
}