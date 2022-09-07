package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.DTO.sessao.IngressoSessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoSelDTO;
import br.com.ticinema.cinema.converter.SessaoConverter;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Sessao;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import br.com.ticinema.cinema.service.ClienteService;
import br.com.ticinema.cinema.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessao")
@AllArgsConstructor
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {

    private final SessaoConverter converter;

    public SessaoRepository getRepository() {
        return (SessaoRepository) repository;
    }

    public SessaoService service;


    @GetMapping
    public ResponseEntity<List<SessaoSelDTO>> listaDto() {
        var sessoes = getRepository().findAll();

        return ResponseEntity.ok(converter.mostrarSessao(sessoes));

    }
}
