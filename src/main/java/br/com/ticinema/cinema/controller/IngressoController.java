package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.core.crud.CrudController;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.IngressoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingresso")
public class IngressoController extends CrudController<Ingresso, Long> {

    public IngressoRepository getRepository(){return (IngressoRepository) repository;}

    @GetMapping("/valor-maior-20")
    public List<Ingresso> valor20(){
        return getRepository().qValor();
    }

}
