package br.com.previsao.controller;

import br.com.previsao.entity.Cliente;
import br.com.previsao.service.PrevisaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/churn/clientes")
@CrossOrigin(origins = "*")
public class ChurnController {

    @Autowired
    private PrevisaoService previsaoService;

    // --- Simulação de uma base de dados de clientes ---
    private List<Cliente> clientesBase = Arrays.asList(
            new Cliente(1L, "Ana Silva", 12, 10, 1, 59.90, false, 0.0), // Baixo Risco
            new Cliente(2L, "Bruno Costa", 30, 4, 5, 120.00, false, 0.0), // Alto Risco
            new Cliente(3L, "Carlos Dias", 45, 24, 2, 79.90, false, 0.0), // Baixo Risco
            new Cliente(4L, "Dani Souza", 22, 1, 4, 150.00, false, 0.0)  // Alto Risco (Novato + Alto Valor + Suporte)
    );

    /**
     * Endpoint que retorna a lista de clientes com a previsão de cancelamento (Churn)
     * GET /api/churn/clientes
     */
    @GetMapping
    @Operation(summary = "endpoint responsável por buscar clientes com risco de cancelamento.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<Cliente>> getClientesComPrevisao() {
        // Para cada cliente na nossa base simulada, fazemos a previsão
        clientesBase.forEach(previsaoService::preverRisco);

        return ResponseEntity.ok(clientesBase);
    }
}
