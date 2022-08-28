package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.DTO.sessao.IngressoSessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoSelDTO;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Sessao;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import br.com.ticinema.cinema.service.ClienteService;
import br.com.ticinema.cinema.service.SessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessao")
public class SessaoController extends CrudController<Sessao, SessaoDTO, Long> {


    public SessaoRepository getRepository() {
        return (SessaoRepository) repository;
    }

    public SessaoService service;


    @GetMapping
    public ResponseEntity<List<SessaoSelDTO>> listaDto() {
        var sessoes = getRepository().findAll();

        var sessaoSelectDTO = sessoes.stream()
                .map(s -> new SessaoSelDTO(s.getIdsessao(),
                        s.getHorario(),

                        s.getFilme().getIdfilme(), s.getFilme().getNomefilme(),
                        s.getFilme().getGenero(), s.getFilme().getClassificacao(),

                        s.getSala().getIdsala(), s.getSala().getNome(),
                        s.getSala().getCapacidadesala(),

                        s.getIngressos().stream().map(i -> new IngressoSessaoDTO(i.getIdingresso(), i.getValor(),
                                        i.getQuantidade(), i.getCliente().getIdcliente(), i.getCliente().getNome()
                                ))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
        return ResponseEntity.ok(sessaoSelectDTO);

    }
}
