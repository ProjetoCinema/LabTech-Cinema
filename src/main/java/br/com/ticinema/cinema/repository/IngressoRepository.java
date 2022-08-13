package br.com.ticinema.cinema.repository;

import br.com.ticinema.cinema.core.crud.CrudRepository;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Ingresso;
import org.springframework.stereotype.Repository;

@Repository
public interface IngressoRepository extends CrudRepository<Ingresso, Long> {
}
