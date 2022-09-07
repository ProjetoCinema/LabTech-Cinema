package br.com.ticinema.cinema.DTO.cliente;

import br.com.ticinema.cinema.domain.Sessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngressoCliDTO {

    private Long idingresso;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Integer quantidade;
    private Long sessao;
    private LocalDate horario;


    private String nomeSala;
    private Integer capacidade;


    private String filmeNome;
    private String classificacao;
    private String genero;




}
