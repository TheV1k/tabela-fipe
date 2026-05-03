🚗 Consulta Tabela FIPE (Java)
==============================

Aplicação em Java que consome uma API pública da Tabela FIPE para consulta de preços de veículos com base em **marca, modelo e ano**.

O sistema funciona via terminal e permite ao usuário navegar pelas opções até encontrar o valor atualizado do veículo.

* * *

📌 Sobre o projeto
------------------

Este projeto foi desenvolvido com foco em:

* Consumo de API REST

* Manipulação de JSON

* Boas práticas com Java

* Tratamento de erros e validações

* * *

🔥 Funcionalidades
------------------

* ✅ Listagem de marcas disponíveis

* ✅ Consulta de modelos por marca

* ✅ Filtro de modelos por nome digitado

* ✅ Consulta de preços por ano

* ✅ Exibição detalhada das informações do veículo

* * *

🛠️ Tecnologias utilizadas
--------------------------

* Java 17+

* API REST (Tabela FIPE)

* Biblioteca Jackson (conversão JSON → objeto)

* Programação orientada a objetos (POO)

* * *

▶️ Como executar o projeto
--------------------------

### 🔧 Pré-requisitos

* Java instalado (versão 17 ou superior)

### 🚀 Passo a passo

1. Clone o repositório:

    git clone https://github.com/seu-usuario/tabela-fipe-java.git

2. Acesse a pasta do projeto:

    cd tabela-fipe-java

3. Compile o projeto:

    javac br/com/projetos/tabela_fipe/principal/Principal.java

4. Execute a aplicação:

    java br.com.projetos.tabela_fipe.principal.Principal

* * *

📸 Exemplo de uso
-----------------

    Digite o tipo de veículo (carros, motos, caminhões):
    carros
    
    Digite o código da marca:
    59
    
    Digite o nome do modelo:
    civic
    
    Modelos encontrados:
    Cód: 5940 | Descrição: Honda Civic
    
    Consultando valores por ano...
    
    Ano: 2020 | Valor: R$ 98.000
    Ano: 2021 | Valor: R$ 105.000

* * *

📂 Estrutura do projeto
-----------------------

    tabela-fipe/
    │
    ├── model/        → Classes de dados (records)
    ├── service/      → Consumo da API e conversão de dados
    ├── principal/    → Classe principal (execução)

* * *

⚠️ Tratamento de erros
----------------------

O sistema possui validações para evitar falhas comuns:

* Entrada inválida do usuário

* Código de marca inexistente

* Modelo não encontrado

* Erros na requisição da API

* Listas vazias

* * *

🚀 Melhorias futuras
--------------------

* Interface gráfica (JavaFX ou Web)

* Integração com banco de dados

* Histórico de consultas

* Exportação de resultados (CSV ou PDF)

* API própria para consumo externo

* * *

💡 Aprendizados
---------------

Durante o desenvolvimento, foram aplicados conceitos importantes como:

* Consumo de APIs externas

* Desserialização de JSON com Jackson

* Uso de Streams e filtros

* Organização em camadas (model, service, principal)

* * *

👨‍💻 Autor
-----------

**Victor Moreira**

* * *

📄 Licença
----------

Este projeto está sob a licença MIT. Sinta-se livre para usar e modificar.
