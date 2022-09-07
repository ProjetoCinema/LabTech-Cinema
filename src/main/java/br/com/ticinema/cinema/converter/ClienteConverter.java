package br.com.ticinema.cinema.converter;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.DTO.cliente.ClienteDTO;
import br.com.ticinema.cinema.DTO.cliente.IngressoCliDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.IngressoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClienteConverter implements CrudConverter<Cliente, ClienteDTO>  {


    @Override
    public ClienteDTO entidadeParaDTO(Cliente entidade) {
        var dto = new ClienteDTO();
        dto.setIdcliente(entidade.getIdcliente());
        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());


        return dto;
    }

    @Override
    public Cliente dtoParaEntidade(ClienteDTO dto) {
        var cliente = new Cliente();

        cliente.setIdcliente(dto.getIdcliente());
        cliente.setNome(dto.getNome());
        cliente.setSenha(dto.getSenha());
        cliente.setEmail(dto.getEmail());


        return cliente;
    }

    public List<CliSelecDTO> mostrarCliente(List<Cliente> clientes){

        return clientes.stream()
                .map(c -> new CliSelecDTO(c.getIdcliente(),
                        c.getEmail(),
                        c.getNome(),
                        c.getValorPago(),
                        c.getIngressos().stream().map(i -> new IngressoCliDTO(i.getIdingresso(),i.getValorIngresso(), i.getValor(),
                                        i.getQuantidade(), i.getSessao().getIdsessao(), i.getSessao().getHorario(),

                                        i.getSessao().getSala().getNome(), i.getSessao().getSala().getCapacidadesala(),

                                        i.getSessao().getFilme().getNomefilme(), i.getSessao().getFilme().getGenero(),
                                        i.getSessao().getFilme().getClassificacao()


                                ))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());

    }

}
