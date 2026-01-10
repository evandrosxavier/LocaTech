package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.service.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
@Tag(name = "Aluguel Controller", description = "(Controller para crud de locação de veículos)")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @Operation(
            description = "Busca a uma locação específica usando o id como parâmetro",
            summary = "Busca locação por id",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Operação bem-sucedida. O recurso foi encontrado e está sendo retornado no corpo da resposta."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Recurso não encontrado. O ID fornecido não corresponde a nenhum recurso existente na base de dados."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Algo inesperado aconteceu."
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findByID(
            @PathVariable("id") Long id) {
        var aluguel = this.aluguelService.findById(id);
        return ResponseEntity.ok(aluguel);
    }

    @Operation(
            summary = "Lista todos os alguéis de forma paginada",
            description = "Retorna uma lista de recursos, permitindo controle de paginação através dos parâmetros 'page' e 'size'.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operação bem-sucedida. A lista de alugueis (pode estar vazia) é retornada no corpo da resposta."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Algo inesperado aconteceu."
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Aluguel>> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        var alugueis = this.aluguelService.findAll(page, size);
        return ResponseEntity.ok(alugueis);

    }

    @Operation(
            summary = "Cria um novo aluguel",
            description = "Registra um novo recurso na base de dados com base nos dados fornecidos no corpo da requisição.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Recurso criado com sucesso. O novo recurso, incluindo seu ID gerado, é retornado no corpo da resposta."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os dados enviados, pois um ou mais campos não atendem às regras de validação."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Algo inesperado aconteceu."
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AluguelRequestDTO aluguel) {
        this.aluguelService.save(aluguel);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Atualiza um aluguel existente",
            description = "Modifica um recurso existente, identificado pelo seu ID, com base nos novos dados fornecidos no corpo da requisição.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Recurso atualizado com sucesso. A versão atualizada do recurso é retornada no corpo da resposta."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os dados enviados, pois um ou mais campos não atendem às regras de validação."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Recurso não encontrado. O ID fornecido não corresponde a nenhum recurso existente."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Algo inesperado aconteceu."
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity update(
            @RequestBody Aluguel aluguel,
            @PathVariable("id") Long id) {
        this.aluguelService.update(aluguel, id);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "Deleta um aluguel",
            description = "Remove permanentemente um recurso da base de dados com base no seu ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Operação bem-sucedida. O recurso foi deletado e não há conteúdo para retornar."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Recurso não encontrado. O ID fornecido não corresponde a nenhum recurso existente."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Algo inesperado aconteceu."
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id) {
        this.aluguelService.delete(id);
        return ResponseEntity.ok().build();
    }
}

