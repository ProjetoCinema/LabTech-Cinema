package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Sessao;
import org.springframework.stereotype.Service;

@Service
public class SessaoService extends CrudService<Sessao, Long> {
    @Override
    protected Sessao editarEntidade(Sessao recuperado, Sessao entidade, Long id) {

        recuperado.setIdsessao(id);
        recuperado.setDisponivel(entidade.getDisponivel());
        recuperado.setHorario(entidade.getHorario());
        recuperado.setIngressos(entidade.getIngressos());
        recuperado.setSala(entidade.getSala());
        recuperado.setFilme(entidade.getFilme());

        return recuperado;
    }
}
