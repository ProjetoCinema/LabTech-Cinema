package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.core.crud.CrudController;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.service.ClienteService;
import liquibase.pro.packaged.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, Long> {

    public ClienteRepository getRepository(){return (ClienteRepository) repository;}

    @GetMapping("/native")
    public List<Cliente> CliNative(){return getRepository().findAllNative();}

    @GetMapping("/ordem-email")
    public List<Cliente> emailOrdem(){return this.getRepository().consultarPeloEmail("email");}

}
