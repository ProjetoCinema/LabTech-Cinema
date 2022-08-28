package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.ClienteDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, ClienteDTO, Long> {

    public ClienteRepository getRepository(){return (ClienteRepository) repository;}
    public ClienteService service;




    @GetMapping
    public ResponseEntity<List<CliSelecDTO>> listaDto() {
        var clientes = getRepository().findAll();

        var clienteSelectDTO =clientes.stream()
                .map(c -> new CliSelecDTO(c.getIdcliente(),
                        c.getEmail(),
                        c.getNome(),
                        c.getIngressos().stream().map(i -> new IngressoCliDTO(i.getIdingresso(), i.getValor(),
                                        i.getQuantidade(), i.getSessao().getIdsessao(), i.getSessao().getHorario(),

                                    i.getSessao().getSala().getNome(), i.getSessao().getSala().getCapacidadesala(),

                                    i.getSessao().getFilme().getNomefilme(), i.getSessao().getFilme().getGenero(),
                                        i.getSessao().getFilme().getClassificacao()


                                        ))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
        return ResponseEntity.ok(clienteSelectDTO);
    }

}