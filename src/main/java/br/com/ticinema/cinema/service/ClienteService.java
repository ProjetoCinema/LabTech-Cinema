package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();

    }

    public Cliente porId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }

}
