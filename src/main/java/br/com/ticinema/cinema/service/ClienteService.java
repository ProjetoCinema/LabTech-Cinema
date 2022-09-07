package br.com.ticinema.cinema.service;

import br.com.ticinema.cinema.DTO.cliente.ClienteDTO;
import br.com.ticinema.cinema.DTO.ingresso.IngressoDTO;
import br.com.ticinema.cinema.core.CrudService;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService extends CrudService<Cliente, Long> {

//    private final IngressoRepository ingressoRepository;
//
//
//    public Cliente criarCliente(Cliente cliente, ClienteDTO dto){
//
//        var ids = cliente.getIngressos().stream().map(Ingresso::getIdingresso).collect(Collectors.toList());
//
//        var ingressos = ingressoRepository.findByIdIn(ids);
//
//        var valores = ingressos.stream()
//                .map(Ingresso::getValor).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
//
//        cliente.setIdcliente(dto.getIdcliente());
//        cliente.setEmail(dto.getEmail());
//        cliente.setSenha(dto.getSenha());
//        cliente.setNome(dto.getNome());
//
//
//        return super.criar(cliente);
//    }


    @Override
    protected Cliente editarEntidade(Cliente recuperado, Cliente entidade, Long id) {


        recuperado.setIdcliente(id);
        recuperado.setSenha(entidade.getSenha());
        recuperado.setEmail(entidade.getEmail());
        recuperado.setNome(entidade.getNome());
        recuperado.getIngressos();


        return recuperado;
    }
}
