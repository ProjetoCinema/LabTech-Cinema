package br.com.ticinema.cinema.DTO.sessao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngressoSessaoDTO {

    private Long idingresso;
    private BigDecimal valorTotal;
    private Integer quantidade;
    private Long cliente;
    private String nome;



}
