package br.com.fiap.locatech.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(
        @Schema (description = "Número que identifica um registro da pessoa que realiza a locação",
                requiredMode = Schema.RequiredMode.REQUIRED

        )
        @NotNull (message = "O id da pessoa não pode ser nulo")
        Long pessoaId,
        @NotNull (message = "O id do veiculo não pode ser nulo")
        Long veiculoId,

        LocalDate dataInicio,
        LocalDate dataFim

) {

}
