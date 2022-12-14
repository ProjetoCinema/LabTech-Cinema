package br.com.ticinema.cinema.converter;

import br.com.ticinema.cinema.DTO.filme.FilmeDTO;
import br.com.ticinema.cinema.core.CrudConverter;
import br.com.ticinema.cinema.domain.Filme;
import br.com.ticinema.cinema.service.FilmeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmeConveter implements CrudConverter<Filme, FilmeDTO> {
    @Override
    public FilmeDTO entidadeParaDTO(Filme entidade) {
        var dto = new FilmeDTO();

        dto.setIdfilme(entidade.getIdfilme());
        dto.setGenero(entidade.getGenero());
        dto.setClassificacao(entidade.getClassificacao());
        dto.setNomefilme(entidade.getNomefilme());


        return dto;
    }

    @Override
    public Filme dtoParaEntidade(FilmeDTO dto) {
        var filme = new Filme();

        filme.setIdfilme(dto.getIdfilme());
        filme.setGenero(dto.getGenero());
        filme.setClassificacao(dto.getClassificacao());
        filme.setNomefilme(dto.getNomefilme());


        return filme;
    }

    public List<FilmeDTO> mostrarFilmes(List<Filme> filmes) {
        return filmes.stream()
                .map(f -> new FilmeDTO(f.getIdfilme(),
                        f.getNomefilme(),
                        f.getClassificacao(),
                        f.getGenero())).collect(Collectors.toList());

    }

}
