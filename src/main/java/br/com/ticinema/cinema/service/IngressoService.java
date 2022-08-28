package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Ingresso;
import org.springframework.stereotype.Service;

@Service
public class IngressoService extends CrudService<Ingresso, Long> {

    @Override
    protected Ingresso editarEntidade(Ingresso recuperado, Ingresso entidade, Long id) {
        recuperado.setIdingresso(id);
        recuperado.setValor(entidade.getValorIngresso()*entidade.getQuantidade());
        recuperado.setQuantidade(entidade.getQuantidade());
        recuperado.setCliente(entidade.getCliente());
        recuperado.setSessao(entidade.getSessao());

        return recuperado;
    }
}
