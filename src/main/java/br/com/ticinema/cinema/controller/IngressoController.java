package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.ingresso.IngressoDTO;
import br.com.ticinema.cinema.DTO.ingresso.IngressoIngressoDTO;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.IngressoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingresso")
public class IngressoController extends CrudController<Ingresso, IngressoDTO, Long> {

    public IngressoRepository getRepository(){return (IngressoRepository) repository;}

    @GetMapping
    public ResponseEntity<List<IngressoIngressoDTO>> listaDto() {
        var ingressos = getRepository().findAll();

        var ingressoDTO =ingressos.stream()
                .map(i -> new IngressoIngressoDTO(i.getIdingresso(),
                        i.getValor(),
                        i.getQuantidade(), i.getSessao().getIdsessao(), i.getSessao().getHorario(),
                        i.getCliente().getIdcliente(), i.getCliente().getNome()
                )).collect(Collectors.toList());
        return ResponseEntity.ok(ingressoDTO);
    }

}
