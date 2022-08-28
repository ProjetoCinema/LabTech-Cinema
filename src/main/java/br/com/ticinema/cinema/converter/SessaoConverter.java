package br.com.ticinema.cinema.converter;

import br.com.ticinema.cinema.DTO.sessao.SessaoDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Sessao;
import br.com.ticinema.cinema.repository.FilmeRepository;
import br.com.ticinema.cinema.repository.SalaRepository;
import br.com.ticinema.cinema.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}
