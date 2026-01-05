package br.com.fiap.locatech.service;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.repositories.VeiculoRespository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final VeiculoRespository veiculoRespository;

    public AluguelService(AluguelRepository aluguelRepository, VeiculoRespository veiculoRespository) {
        this.aluguelRepository = aluguelRepository;
        this.veiculoRespository = veiculoRespository;
    }

    public Optional<Aluguel> findById (Long id) {
        return this.aluguelRepository.findById(id);
    }

    public List<Aluguel> findAll (int page, int size) {
        int offset = (page-1)* size;
        return this.aluguelRepository.findAlL(size, offset);
    }

    public Integer save(AluguelRequestDTO aluguel) {
        var aluguelEntity = calculaValorTotal(aluguel);
        return this.aluguelRepository.save(aluguelEntity);
    }

    public Integer update(Aluguel aluguel, Long id) {
        return this.aluguelRepository.update(aluguel, id);
    }

    public Integer delete (Long id) {
        return this.aluguelRepository.delete(id);
    }

    private Aluguel calculaValorTotal (AluguelRequestDTO aluguelRequestDTO) {
        var veiculo = this.veiculoRespository.findById(aluguelRequestDTO.veiculoId()).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        var qtdDiarias = BigDecimal.valueOf(aluguelRequestDTO.dataFim().getDayOfYear() - aluguelRequestDTO.dataInicio().getDayOfYear());
        var valorTotal = veiculo.getValorDiaria().multiply(qtdDiarias);
        return new Aluguel(aluguelRequestDTO, valorTotal);
    }
}
