package br.com.ticinema.cinema.DTO.ingresso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngressoIngressoDTO {

    private Long idingresso;
    private BigDecimal valorTotal;
    private Integer quantidade;
    private Long sessao;
    private LocalDate horario;

    private Long cliente;
    private String nome;

    public IngressoIngressoDTO(Long idingresso, BigDecimal valor, Integer quantidade, Long sessao, LocalDate horario) {
        this.idingresso = idingresso;
        this.valorTotal = valor;
        this.quantidade = quantidade;
        this.sessao = sessao;
        this.horario = horario;
    }
}
