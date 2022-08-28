package br.com.ticinema.cinema.DTO.sessao;

import br.com.ticinema.cinema.domain.Filme;
import br.com.ticinema.cinema.domain.Ingresso;
import br.com.ticinema.cinema.domain.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoDTO {

    private Long idsessao;

    private LocalDate horario;
    private Boolean disponivel;
    private List<Ingresso> ingresso;
    private Long salaId;
    private Sala sala;
    private Long filmeId;
    private Filme filme;


}
