package br.com.ticinema.cinema.DTO.ingresso;

import br.com.ticinema.cinema.DTO.cliente.ClienteDTO;
import br.com.ticinema.cinema.DTO.sessao.SessaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngressoDTO {

    private Long idingresso;
    private Float valorTotal;
    private Integer quantidade;
    private Long clienteId;
    private ClienteDTO clienteDTO;
    private Long sessaoId;
    private SessaoDTO sessaoDTO;



//    private Sessao sessao;

//    public IngressoDTO(Long idingresso, Float valor, Integer quantidade ) {
//        this.idingresso = idingresso;
//        this.valor = valor;
//        this.quantidade = quantidade;
//
//    }


}
