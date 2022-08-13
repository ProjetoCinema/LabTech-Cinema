package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.crud.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Sala;
import org.springframework.stereotype.Service;

@Service
public class SalaService extends CrudService<Sala, Long> {
    @Override
    protected Sala editarEntidade(Sala recuperado, Sala entidade) {
        recuperado.setNome(entidade.getNome());
        recuperado.setCapacidade(entidade.getCapacidade());
        return recuperado;
    }
}
