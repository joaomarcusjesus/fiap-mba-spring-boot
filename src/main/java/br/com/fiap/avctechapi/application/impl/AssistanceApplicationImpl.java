package br.com.fiap.avctechapi.application.impl;

import br.com.fiap.avctechapi.application.AssistanceApplication;
import br.com.fiap.avctechapi.application.dto.AssistDto;
import br.com.fiap.avctechapi.model.Assistance;
import br.com.fiap.avctechapi.services.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.List;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {

    private AssistanceService service;

    public  AssistanceApplicationImpl (@Autowired AssistanceService service){
        this.service = service;
    }
    @Override
    public List<AssistDto> getAssists() {
        return this.service.getAssistanceList().stream().map(this::mapAssistToDto).collect(Collectors.toList());
    }

    private AssistDto mapAssistToDto(Assistance assist){
        return new AssistDto(assist.getId(), assist.getName(), assist.getDescription());
    }
}