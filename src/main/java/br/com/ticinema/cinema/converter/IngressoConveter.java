package br.com.ticinema.cinema.converter;


import br.com.ticinema.cinema.DTO.ingresso.IngressoDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.repository.ClienteRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngressoConveter implements CrudConverter<Ingresso, IngressoDTO> {

      private final ClienteConverter clienteConverter;
      private final SessaoConverter sessaoConverter;
      private final ClienteRepository clienteRepository;
      private final SessaoRepository sessaoRepository;


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

        ingresso.setValor((ingresso.getValorIngresso())*(quantidade));


        ingresso.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));

        ingresso.setSessao(sessaoRepository.findById(dto.getSessaoId()).orElse(null));

        return ingresso;
    }
}
