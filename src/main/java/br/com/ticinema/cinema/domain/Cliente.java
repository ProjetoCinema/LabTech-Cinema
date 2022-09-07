package br.com.ticinema.cinema.domain;

import br.com.ticinema.cinema.core.CrudDomain;
import liquibase.license.LicenseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente implements CrudDomain<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

    private String email;
    private String senha;
    private String nome;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Ingresso> ingressos = new ArrayList<>();


    @Override
    public Long getId() {
        return idcliente;
    }


    public BigDecimal getValorPago(){
        return ingressos.stream().map(Ingresso::getValor).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
