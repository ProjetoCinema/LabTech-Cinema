package br.com.ticinema.cinema.repository;

import br.com.ticinema.cinema.core.crud.CrudRepository;
import br.com.ticinema.cinema.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
