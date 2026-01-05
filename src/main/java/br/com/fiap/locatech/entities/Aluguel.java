package br.com.fiap.locatech.entities;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {
    private Long id;
    private Long pessoaId;
    private String pessoaNome;
    private String pessoaCpf;
    private Long veiculoId;
    private String veiculoModelo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;

    public Aluguel(AluguelRequestDTO aluguelRequestDTO, BigDecimal valorTotal) {
        this.pessoaId = aluguelRequestDTO.pessoaId();
        this.veiculoId = aluguelRequestDTO.veiculoId();
        this.dataInicio = aluguelRequestDTO.dataInicio();
        this.dataFim = aluguelRequestDTO.dataFim();
        this.valorTotal = valorTotal;
    }
}
