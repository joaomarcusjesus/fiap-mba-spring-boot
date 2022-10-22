package br.com.fiap.avctechapi.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long operatorId;
    private List<Long> assists;
    private LocationDto start;
    private LocationDto end;
}