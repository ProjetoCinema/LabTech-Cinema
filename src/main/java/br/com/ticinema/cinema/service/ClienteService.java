package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends CrudService<Cliente, Long> {
    @Override
    protected Cliente editarEntidade(Cliente recuperado, Cliente entidade, Long id) {

        recuperado.setIdcliente(id);
        recuperado.setSenha(entidade.getSenha());
        recuperado.setEmail(entidade.getEmail());
        recuperado.setNome(entidade.getNome());
        recuperado.getIngressos();


        return recuperado;
    }
}
