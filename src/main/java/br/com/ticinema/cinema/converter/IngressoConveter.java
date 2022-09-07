package br.com.ticinema.cinema.converter;


import br.com.ticinema.cinema.DTO.ingresso.IngressoDTO;
import br.com.ticinema.cinema.DTO.ingresso.IngressoIngressoDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.repository.IngressoRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngressoConveter implements CrudConverter<Ingresso, IngressoDTO> {

      private final ClienteConverter clienteConverter;
      private final SessaoConverter sessaoConverter;
      private final ClienteRepository clienteRepository;
      private final SessaoRepository sessaoRepository;
      private final IngressoRepository ingressoRepository;

    @Override
    public IngressoDTO entidadeParaDTO(Ingresso entidade) {

        var dto = new IngressoDTO();

        dto.setIdingresso(entidade.getIdingresso());
        dto.setValorTotal(entidade.getValor());
        dto.setQuantidade(entidade.getQuantidade());



        return dto;
    }

    @Override
    public Ingresso dtoParaEntidade(IngressoDTO dto) {


        var quantidade =  dto.getQuantidade().floatValue();

        var ingresso = new Ingresso();

        ingresso.setIdingresso(dto.getIdingresso());

        ingresso.setQuantidade(dto.getQuantidade());

        ingresso.setValor(ingresso.getValorIngresso().multiply(BigDecimal.valueOf(quantidade)));


        ingresso.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));

        ingresso.setSessao(sessaoRepository.findById(dto.getSessaoId()).orElse(null));

        return ingresso;
    }

    public List<IngressoIngressoDTO> mostrarIngresso(List<Ingresso> ingressos){
        return ingressos.stream()
                .map(i -> new IngressoIngressoDTO(i.getIdingresso(),
                        i.getValor(),
                        i.getQuantidade(), i.getSessao().getIdsessao(), i.getSessao().getHorario(),
                        i.getCliente().getIdcliente(), i.getCliente().getNome()
                )).collect(Collectors.toList());
    }


}
