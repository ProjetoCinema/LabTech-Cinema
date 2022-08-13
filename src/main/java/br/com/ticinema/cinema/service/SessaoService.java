package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.crud.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Sessao;
import org.springframework.stereotype.Service;

@Service
public class SessaoService extends CrudService<Sessao, Long> {
    @Override
    protected Sessao editarEntidade(Sessao recuperado, Sessao entidade) {
        recuperado.setHorario(entidade.getHorario());
        recuperado.setDisponibilidade(entidade.getDisponibilidade());
        return recuperado;
    }
}
