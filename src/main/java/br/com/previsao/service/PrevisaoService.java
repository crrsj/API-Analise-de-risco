package br.com.previsao.service;


import br.com.previsao.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PrevisaoService {

    private static final Random RANDOM = new Random();

    /**
     * Simula a chamada a um modelo de Machine Learning
     * e preenche os campos de risco de cancelamento.
     */
    public Cliente preverRisco(Cliente cliente) {
        // --- Lógica de Previsão SIMULADA ---
        // A lógica real viria de um modelo treinado (Ex: um arquivo .pkl ou uma chamada para outra API de ML)

        // Simulação 1: Clientes novos (poucos meses) e com alto valor mensal tendem a ter mais risco.
        // Simulação 2: Clientes com muitas chamadas de suporte têm mais risco.
        double scoreDeRisco = 0.0;

        // Fatores de risco
        if (cliente.getMesesDeContrato() < 6) {
            scoreDeRisco += 0.3;
        }
        if (cliente.getChamadasSuporte() > 3) {
            scoreDeRisco += 0.4;
        }
        if (cliente.getValorMensal() > 100.0) {
            scoreDeRisco += 0.2;
        }

        // Adiciona uma pequena aleatoriedade para tornar a simulação mais "real"
        scoreDeRisco += (RANDOM.nextDouble() * 0.1); // Adiciona 0 a 10%

        // O score de risco máximo é 1.0 (100%)
        scoreDeRisco = Math.min(scoreDeRisco, 1.0);

        // Define a probabilidade e o risco (usando 50% como threshold)
        cliente.setProbabilidadeChurn(scoreDeRisco);
        cliente.setRiscoDeCancelamento(scoreDeRisco >= 0.5);

        return cliente;
    }
}
