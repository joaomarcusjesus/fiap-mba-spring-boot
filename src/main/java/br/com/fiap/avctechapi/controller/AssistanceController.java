package br.com.fiap.avctechapi.controller;

import br.com.fiap.avctechapi.application.AssistanceApplication;
import br.com.fiap.avctechapi.application.dto.AssistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private final AssistanceApplication assistanceApplication;

    @Autowired
    public AssistanceController(AssistanceApplication assistanceApplication){
        this.assistanceApplication = assistanceApplication;
    }

    @GetMapping()
    public ResponseEntity<List<AssistDto>> getAssists(){
        List<AssistDto> list = assistanceApplication.getAssists();
        return ResponseEntity.ok(list);
    }

}