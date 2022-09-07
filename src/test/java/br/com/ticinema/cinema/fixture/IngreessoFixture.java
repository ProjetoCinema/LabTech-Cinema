package br.com.ticinema.cinema.fixture;

import br.com.ticinema.cinema.domain.Ingresso;

public class IngreessoFixture {

    public static Ingresso createIngresso(){
        var ingresso = new Ingresso();

        ingresso.setIdingresso(1L);


        return ingresso;
    }

}
