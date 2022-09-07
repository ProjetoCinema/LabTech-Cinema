package br.com.ticinema.cinema.converter;

import br.com.ticinema.cinema.DTO.sessao.IngressoSessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoSelDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Sessao;
import br.com.ticinema.cinema.repository.FilmeRepository;
import br.com.ticinema.cinema.repository.SalaRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SessaoConverter implements CrudConverter<Sessao, SessaoDTO> {

    private final SalaRepository salaRepository;
    private final FilmeRepository filmeRepository;

    @Override
    public SessaoDTO entidadeParaDTO(Sessao entidade) {
        var dto = new SessaoDTO();

        dto.setIdsessao(entidade.getIdsessao());
        dto.setHorario(entidade.getHorario());
        dto.setDisponivel(entidade.getDisponivel());
        dto.setIngresso(entidade.getIngressos());

        return dto;
    }

    @Override
    public Sessao dtoParaEntidade(SessaoDTO dto) {
        var sessao = new Sessao();

        sessao.setIdsessao(dto.getIdsessao());
        sessao.setHorario(dto.getHorario());
        sessao.setDisponivel(dto.getDisponivel());
        sessao.setSala(salaRepository.findById(dto.getSalaId()).orElse(null));
        sessao.setFilme(filmeRepository.findById(dto.getFilmeId()).orElse(null));

        return sessao;
    }

    public List<SessaoSelDTO> mostrarSessao(List<Sessao> sessoes){
        return sessoes.stream()
                .map(s -> new SessaoSelDTO(s.getIdsessao(),
                        s.getHorario(),

                        s.getFilme().getIdfilme(), s.getFilme().getNomefilme(),
                        s.getFilme().getGenero(), s.getFilme().getClassificacao(),

                        s.getSala().getIdsala(), s.getSala().getNome(),
                        s.getSala().getCapacidadesala(),

                        s.getIngressos().stream().map(i -> new IngressoSessaoDTO(i.getIdingresso(), i.getValor(),
                                        i.getQuantidade(), i.getCliente().getIdcliente(), i.getCliente().getNome()
                                ))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

}
