package br.com.ticinema.cinema.core.crud;

import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public abstract class CrudController<T, ID> {

    @Autowired
    private CrudService<T, ID> service;


    @GetMapping
    public ResponseEntity<List<T>> listar(){
        var lista = service.listar();
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<T> porId(@PathVariable("id")ID id){
        var resultado = service.porId(id);

        if (Objects.isNull(resultado)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody T entidade){
        var salvo = service.criar(entidade);

        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@PathVariable("id") ID id, @RequestBody T entidade){
        return ResponseEntity.ok(service.editar(id, entidade));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")ID id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
