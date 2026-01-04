package br.com.fiap.locatech.service;


import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.repositories.VeiculoRespository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRespository veiculoRespository;

    public VeiculoService(VeiculoRespository veiculoRespository) {
        this.veiculoRespository = veiculoRespository;
    }

    public Optional<Veiculo> findById (Long id) {
        return  this.veiculoRespository.findById(id);
    }

    public List<Veiculo> findAll(int page, int size) {
        int offset = (page - 1) *size;
        return this.veiculoRespository.findAll(size, offset);
    }

    public void save(Veiculo veiculo) {
        var save = this.veiculoRespository.save(veiculo);
        Assert.state(save == 1, "Erro ao salvar o veículo" + veiculo.getPlaca());
    }

    public void update(Veiculo veiculo, Long id) {
        var update = this.veiculoRespository.update(veiculo, id);
        if (update == 0) {
            throw new RuntimeException( "Veiculo não encontrado");
        }
    }

    public void delete(Long id) {
        var delete = this.veiculoRespository.delete(id);
        if (delete == 0) {
            throw new RuntimeException( "Veiculo não encontrado");
        }
    }


}
