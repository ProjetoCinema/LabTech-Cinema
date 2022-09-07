package br.com.ticinema.cinema.repository;

import br.com.ticinema.cinema.core.CrudRepository;
import br.com.ticinema.cinema.domain.Ingresso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IngressoRepository extends CrudRepository<Ingresso, Long> {

    @Query("select sum(i.quantidade) from Ingresso i where i.sessao.idsessao in (:ids)")
    Integer recuperarPorIds(@Param("ids") List<Long> ids);


//    List<Ingresso> findByIdIn(List<Long> ids);

}
