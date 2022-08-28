package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.DTO.sala.SalaDTO;
import br.com.ticinema.cinema.controller.SalaController;
import br.com.ticinema.cinema.converter.SalaConverter;
import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Sala;
import br.com.ticinema.cinema.repository.SalaRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaService extends CrudService<Sala, Long> {



    @Override
    protected Sala editarEntidade(Sala recuperado, Sala entidade, Long id) {

        recuperado.setIdsala(id);
        recuperado.setCapacidadesala(entidade.getCapacidadesala());
        recuperado.setNome(entidade.getNome());

        return recuperado;
    }
}
