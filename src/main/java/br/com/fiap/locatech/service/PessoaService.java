package br.com.fiap.locatech.service;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Optional<Pessoa> findById (Long id) {
        return this.pessoaRepository.findById(id);
    }

    public List<Pessoa> findAll (int page, int size) {
        int offset = (page-1)* size;
        return this.pessoaRepository.findAlL(size, offset);
    }

    public Integer save(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public Integer update(Pessoa pessoa, Long id) {
        return this.pessoaRepository.update(pessoa, id);
    }

    public Integer delete (Long id) {
        return this.pessoaRepository.delete(id);
    }
}
