package br.com.ticinema.cinema.DTO.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CliSelecDTO {

    private Long idcliente;
    private String email;
    private String nome;
    private List<IngressoCliDTO> InfoCompra;

}
