package br.com.previsao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private int idade;
    private int mesesDeContrato; // Tempo que o cliente está com o serviço
    private int chamadasSuporte; // Frequência de contato com o suporte
    private double valorMensal;

    // Campos que serão preenchidos pela PREVISÃO do modelo (API)
    private boolean riscoDeCancelamento; // TRUE ou FALSE
    private double probabilidadeChurn; // Ex: 0.85 (85%)
}
