package br.com.ticinema.cinema.domain;

import br.com.ticinema.cinema.core.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingresso implements CrudDomain<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idingresso;

    private BigDecimal valor;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;


    @Transient
    private BigDecimal valorIngresso = new BigDecimal("10.0");

    @Override
    public Long getId() {
        return idingresso;
    }
}


