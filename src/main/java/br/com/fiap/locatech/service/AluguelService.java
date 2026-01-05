package br.com.fiap.locatech.service;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Optional<Aluguel> findById (Long id) {
        return this.aluguelRepository.findById(id);
    }

    public List<Aluguel> findAll (int page, int size) {
        int offset = (page-1)* size;
        return this.aluguelRepository.findAlL(size, offset);
    }

    public Integer save(Aluguel aluguel) {
        return this.aluguelRepository.save(aluguel);
    }

    public Integer update(Aluguel aluguel, Long id) {
        return this.aluguelRepository.update(aluguel, id);
    }

    public Integer delete (Long id) {
        return this.aluguelRepository.delete(id);
    }
}
