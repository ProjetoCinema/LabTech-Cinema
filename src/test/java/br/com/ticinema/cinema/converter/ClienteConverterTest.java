package br.com.ticinema.cinema.converter;

import br.com.ticinema.cinema.DTO.cliente.CliSelecDTO;
import br.com.ticinema.cinema.fixture.ClienteFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class ClienteConverterTest {

    private ClienteConverter clienteConverter;

    @BeforeEach
    public void setUp() {
        clienteConverter = new ClienteConverter();
    }

    @Test
    public void deveConverterListaCliente() {
        List<CliSelecDTO> retorno = clienteConverter.mostrarCliente(Collections.singletonList(ClienteFixture.createCliente()));

        Assertions.assertNotNull(retorno);

    }
}
