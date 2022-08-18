package br.com.ticinema.cinema.repository;

import br.com.ticinema.cinema.core.crud.CrudRepository;
import br.com.ticinema.cinema.domain.Cliente;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query(value = "select * from Cliente c order by nome asc", nativeQuery = true)
    List<Cliente> findAllNative();

    @Query(value = "select c from Cliente c order by c.email asc")
    List<Cliente> consultarPeloEmail(@Param("email") String email);

}
