package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.crud.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService extends CrudService<Cliente, Long> {


    @Override
    protected Cliente editarEntidade(Cliente recuperado, Cliente entidade) {

        recuperado.setEmail(entidade.getEmail());
        recuperado.setSenha(entidade.getSenha());
        recuperado.setNome(entidade.getNome());

        return recuperado;
    }
}
