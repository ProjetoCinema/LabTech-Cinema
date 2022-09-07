package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.filme.FilmeDTO;
import br.com.ticinema.cinema.DTO.sala.SalaDTO;
import br.com.ticinema.cinema.converter.FilmeConveter;
import br.com.ticinema.cinema.core.CrudController;

import br.com.ticinema.cinema.domain.Filme;
import br.com.ticinema.cinema.repository.FilmeRepository;
import br.com.ticinema.cinema.repository.SalaRepository;
import liquibase.pro.packaged.F;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filme")
@AllArgsConstructor
public class FilmeController extends CrudController<Filme, FilmeDTO, Long> {

    private final FilmeConveter conveter;

    public FilmeRepository getRepository(){return (FilmeRepository) repository;}


    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listaDto() {
        var filmes = getRepository().findAll();

        return ResponseEntity.ok(conveter.mostrarFilmes(filmes));
    }


}
