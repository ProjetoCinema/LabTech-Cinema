package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.core.crud.CrudController;
import br.com.ticinema.cinema.domain.Filme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/filme")
public class FilmeController extends CrudController<Filme, Long > {
}
