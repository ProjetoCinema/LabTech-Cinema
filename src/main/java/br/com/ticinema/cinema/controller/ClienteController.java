package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.DTO.ClienteDTO;
import br.com.ticinema.cinema.core.CrudController;
import br.com.ticinema.cinema.domain.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, ClienteDTO, Long> {
}
