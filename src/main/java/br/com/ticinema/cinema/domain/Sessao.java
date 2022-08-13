package br.com.ticinema.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sessao {
    @EmbeddedId
    private ChaveCompostaSessao id;
    
    @ManyToOne
    @MapsId("idFilme")
    @JoinColumn(name = "id_filme")
    private Filme filme;
    
    @ManyToOne
    @MapsId("idSala")
    @JoinColumn(name = "id_sala")
    private Sala sala;
    
    @OneToMany(mappedBy="sessao")
    private List<Ingresso> ingressos;
    
    private Timestamp horario;
    
    private Boolean disponibilidade;
}
