package br.com.ticinema.cinema.core.crud;

import br.com.ticinema.cinema.domain.Cliente;
import br.com.ticinema.cinema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public abstract class CrudService<T, ID>{

    @Autowired
    protected CrudRepository<T, ID> repository;

    public List<T> listar(){
        return repository.findAll();

    }

    public T porId(ID id){
        return repository.findById(id).orElse(null);
    }

    public T criar(T entidade){
        return repository.save(entidade);
    }

    public T editar(ID id, T entidade){
        var recuperado= porId(id);

        if(Objects.isNull(recuperado)){
            throw new RuntimeException("Não foi encontrado.");
        }
        var entidadeSalvar = editarEntidade(recuperado, entidade);

        return repository.save(recuperado);
    }

    protected abstract T editarEntidade(T recuperado, T entidade);


    public void excluir(ID id){repository.deleteById(id);
    }
}
