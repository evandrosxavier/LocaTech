package br.com.fiap.locatech.repositories;

import br.com.fiap.locatech.entities.Pessoa;
import java.util.List;
import java.util.Optional;


public interface PessoaRepository {

    Optional<Pessoa> findById (Long id);

    List<Pessoa> findAlL(int size, int offset);

    Integer save (Pessoa pessoa);

    Integer update (Pessoa pessoa, Long id);

    Integer delete (Long id);

}
