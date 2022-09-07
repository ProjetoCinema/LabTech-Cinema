package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.ClienteDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.converter.ClienteConverter;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController extends CrudController<Cliente, ClienteDTO, Long> {

    private final ClienteConverter converter;

    public ClienteRepository getRepository(){return (ClienteRepository) repository;}


    @GetMapping
    public ResponseEntity<List<CliSelecDTO>> listaDto() {
        var clientes = getRepository().findAll();

        return ResponseEntity.ok(converter.mostrarCliente(clientes));
    }

//    @PostMapping
//    public ResponseEntity<ClienteDTO> criarDto(@RequestBody  ClienteDTO dto){
//
//        var cliente = converter.dtoParaEntidade(dto);
//        var salvo = service.criarCliente(cliente, dto);
//
//        return ResponseEntity.ok(converter.entidadeParaDTO(salvo));
//    }


}