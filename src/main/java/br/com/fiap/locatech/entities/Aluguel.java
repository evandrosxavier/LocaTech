package br.com.fiap.locatech.entities;

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
}
