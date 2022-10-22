package br.com.fiap.avctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponseDto {
    public Long id;
    private Long operatorId;
    private List<AssistDto> assists;
    private LocationDto start;
    private LocationDto end;
}