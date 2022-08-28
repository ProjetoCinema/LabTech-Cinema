package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.DTO.sala.SalaDTO;
import br.com.ticinema.cinema.core.CrudController;

import br.com.ticinema.cinema.domain.Sala;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.repository.SalaRepository;
import br.com.ticinema.cinema.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sala")
public class SalaController extends CrudController<Sala, SalaDTO, Long> {

    public SalaRepository getRepository(){return (SalaRepository) repository;}


    @GetMapping
    public ResponseEntity<List<SalaDTO>> listaDto() {
        var salas = getRepository().findAll();

        var salaDTO =salas.stream()
                .map(sala -> new SalaDTO(sala.getIdsala(),

                        sala.getNome(),
                        sala.getCapacidadesala()
                )).collect(Collectors.toList());
        return ResponseEntity.ok(salaDTO);
    }

}
