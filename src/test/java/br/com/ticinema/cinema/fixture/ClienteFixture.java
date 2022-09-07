package br.com.ticinema.cinema.fixture;

import br.com.ticinema.cinema.domain.Cliente;

public class ClienteFixture {
    public static Cliente createCliente(){

        var cliente = new Cliente();

        cliente.setIdcliente(1L);
        cliente.setNome("Manuel");
        cliente.setEmail("manuel@gmail.com");
        cliente.setSenha("manuel123");
        cliente.getIngressos().add(IngreessoFixture.createIngresso());

        return cliente;
    }
}
