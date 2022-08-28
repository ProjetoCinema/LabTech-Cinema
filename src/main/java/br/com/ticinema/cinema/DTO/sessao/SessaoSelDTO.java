package br.com.ticinema.cinema.DTO.sessao;

import br.com.ticinema.cinema.DTO.filme.FilmeDTO;
import br.com.ticinema.cinema.DTO.sala.SalaDTO;
import br.com.ticinema.cinema.domain.Filme;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.domain.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoSelDTO {

    private Long idsessao;
    private LocalDate horario;


    private Long filme;
    private String filmeNome;
    private String genero;
    private String classificacao;


    private Long sala;
    private String nomeSala;
    private Integer capacidade;


    private List<IngressoSessaoDTO> ingresso;



}
