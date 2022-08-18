package br.com.ticinema.cinema.repository;

import br.com.ticinema.cinema.core.crud.CrudRepository;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Ingresso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngressoRepository extends CrudRepository<Ingresso, Long> {

    @Query(value = "select idingresso, valor from ingresso i where valor > 20 ", nativeQuery = true)
    List<Ingresso> qValor();

}
