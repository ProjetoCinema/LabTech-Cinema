package br.com.ticinema.cinema.controller;

import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        var clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> porId(@PathVariable("id")Long id){
        var resultado = clienteService.porId(id);

        if (Objects.isNull(resultado)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
        var salvo = clienteService.criar(cliente);

        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id){
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
