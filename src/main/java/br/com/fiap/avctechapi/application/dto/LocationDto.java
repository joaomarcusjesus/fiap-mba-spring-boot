package br.com.fiap.avctechapi.application.dto;

import java.util.Date;
import lombok.Data;

@Data
public class LocationDto {
    private Double latitude;
    private Double longitude;
    private Date dateTime;
}