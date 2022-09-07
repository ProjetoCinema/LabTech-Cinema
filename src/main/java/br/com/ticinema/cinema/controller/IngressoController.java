package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.ingresso.IngressoDTO;
import br.com.ticinema.cinema.DTO.ingresso.IngressoIngressoDTO;
import br.com.ticinema.cinema.converter.IngressoConveter;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingresso")
@AllArgsConstructor
public class IngressoController extends CrudController<Ingresso, IngressoDTO, Long> {

    private final IngressoConveter converter;
    private final IngressoRepository repository;

    public IngressoRepository getRepository(){return (IngressoRepository) repository;}

    @GetMapping
    public ResponseEntity<List<IngressoIngressoDTO>> listaDto() {
        var ingressos = getRepository().findAll();

        return ResponseEntity.ok(converter.mostrarIngresso(ingressos));
    }

}
