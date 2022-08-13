package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.core.crud.CrudController;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, Long> {


}
