package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.crud.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Filme;
import org.springframework.stereotype.Service;

@Service
public class FilmeService extends CrudService<Filme, Long> {
    @Override
    protected Filme editarEntidade(Filme recuperado, Filme entidade) {

        recuperado.setNome(entidade.getNome());

        return recuperado;
    }
}
