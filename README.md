💻 ChurnInsight Backend
Visão Geral
O projeto ChurnInsight Backend é uma API REST desenvolvida em Java e Spring Boot para simular a previsão de cancelamento de clientes (Churn Prediction). O objetivo é expor um endpoint que retorna dados de clientes enriquecidos com a probabilidade de risco, permitindo que o frontend visualize e acione ações de retenção.

⚙️ Tecnologias
Linguagem: Java 21

Framework: Spring Boot 3.x

Construção: Maven

Auxiliar: Lombok (para redução de código boilerplate)

API Design: RESTful

🚀 Configuração e Execução
Pré-requisitos
Certifique-se de ter instalado:

Java Development Kit (JDK) 21

Maven 3.x


💻 ChurnInsight BackendVisão GeralO projeto ChurnInsight Backend é uma API REST desenvolvida em Java e Spring Boot para simular a previsão de cancelamento de clientes (Churn Prediction).
O objetivo é expor um endpoint que retorna dados de clientes enriquecidos com a probabilidade de risco, permitindo que o frontend visualize e acione ações de retenção.⚙️ TecnologiasLinguagem: 
Java 21 Framework: Spring Boot 3.xConstrução: MavenAuxiliar: Lombok (para redução de código boilerplate)API Design: 
RESTful🚀 Configuração e ExecuçãoPré-requisitosCertifique-se de ter instalado:Java Development Kit (JDK) 21Maven 
3.xPassos para RodarClone o Repositório:Bashgit clone [URL-DO-SEU-REPOSITÓRIO]
cd ChurnInsight-Backend
Compile o Projeto:Bashmvn clean install
Execute a Aplicação:Bashmvn spring-boot:run
O servidor será iniciado em http://localhost:8080.🌐 Endpoints da APIO principal endpoint fornece a lista de clientes com as métricas de previsão de churn simuladas.
MétodoEndpointDescriçãoGET/api/churn/clientesRetorna uma lista de clientes, cada um com sua probabilidadeChurn e riscoDeCancelamento.

[
  {
    "id": 1,
    "nome": "Ana Silva",
    "idade": 12,
    "mesesDeContrato": 10,
    "chamadasSuporte": 1,
    "valorMensal": 59.90,
    "riscoDeCancelamento": false,
    "probabilidadeChurn": 0.3542
  },
  // ... outros clientes
]

🧠 Como Funciona a Previsão (Simulação)
A lógica de previsão é simples e reside no PrevisaoService.java. Atualmente, ela SIMULA um modelo de Machine Learning, atribuindo maior risco a clientes que:

Têm poucos mesesDeContrato (clientes novos).

Fizeram muitas chamadasSuporte.

Possuem alto valorMensal.

Nota: Em um projeto real, esta lógica seria substituída por uma integração com um modelo de Machine Learning treinado (ex: via ONNX ou uma API de ML externa).

![can1](https://github.com/user-attachments/assets/e6d95777-97a0-463c-be5f-c717bc6dba78)
