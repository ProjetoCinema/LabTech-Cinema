package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.core.crud.CrudController;
import br.com.ticinema.cinema.domain.Sala;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sala")
public class SalaController extends CrudController<Sala, Long> {
}
