package br.com.fiap.avctechapi.application;

import br.com.fiap.avctechapi.application.dto.AssistDto;

import java.util.List;

public interface AssistanceApplication {
    List<AssistDto> getAssists();
}