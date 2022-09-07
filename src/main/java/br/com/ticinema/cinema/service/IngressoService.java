package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;

@Service
@AllArgsConstructor
public class IngressoService extends CrudService<Ingresso, Long> {

    private final IngressoRepository repository;

    @Override
    public Ingresso criar(Ingresso entidade) {
        var quantidadeIngre = (repository
                .recuperarPorIds(Collections.singletonList(entidade.getSessao().getIdsessao()))) +
                entidade.getQuantidade();
        var quantiMax = entidade.getSessao().getSala().getCapacidadesala();

        if(quantidadeIngre > quantiMax){
            ResponseEntity.ok().body("Deu certo");
            return null;

        }

        return repository.save(entidade);
    }

    @Override
    protected Ingresso editarEntidade(Ingresso recuperado, Ingresso entidade, Long id) {

        var quantidadeIngre = (repository
                .recuperarPorIds(Collections.singletonList(entidade.getSessao().getIdsessao()))) +
                entidade.getQuantidade() - recuperado.getQuantidade();
        var quantiMax = entidade.getSessao().getSala().getCapacidadesala();

        if(quantidadeIngre > quantiMax) {
            ResponseEntity.ok().body("Deu certo");
            return null;
        }
        recuperado.setIdingresso(id);
        recuperado.setValor(entidade.getValorIngresso().multiply(BigDecimal.valueOf(entidade.getQuantidade())));
        recuperado.setQuantidade(entidade.getQuantidade());
        recuperado.setCliente(entidade.getCliente());
        recuperado.setSessao(entidade.getSessao());

        return recuperado;
    }
}
