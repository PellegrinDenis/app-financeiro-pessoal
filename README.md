# 💰 App Financeiro Pessoal

Aplicação de console em **Java** para controle de finanças pessoais. As transações (receitas e despesas) ficam salvas em um banco **SQLite** local, e o app calcula o saldo a partir delas.

> 🚧 Projeto em desenvolvimento, criado para praticar Java, orientação a objetos e acesso a banco de dados com JDBC.

## ✨ Funcionalidades

- Listar transações cadastradas, ordenadas por data
- Calcular o saldo atual (receitas − despesas)
- Classificar transações por **tipo** (receita ou despesa) e **categoria** (alimentação, transporte, moradia, salário, saúde, educação, lazer, outros)
- Validar que o valor de toda transação seja maior que zero
- Criar a tabela do banco automaticamente na primeira execução

## 🛠️ Tecnologias

- Java 25
- Maven
- SQLite com JDBC (`sqlite-jdbc`)
- `BigDecimal` para valores monetários e `LocalDate` para datas

## 🗂️ Estrutura do projeto

O código segue uma arquitetura em camadas:

```
src/main/java
├── app/          → ponto de entrada (Main) e menu do console
├── model/        → Transacao e os enums TipoTransacao e Categoria
├── repository/   → conexão com o SQLite e persistência das transações
└── service/      → regras de negócio (listagem e cálculo de saldo)
```

## ▶️ Como executar

**Pré-requisitos:** JDK 25 ou superior e Maven.

1. Clone o repositório:
   ```bash
   git clone https://github.com/PellegrinDenis/app-financeiro-pessoal.git
   ```
2. Abra o projeto no IntelliJ IDEA (ou em outra IDE com suporte a Maven) e aguarde o download das dependências.
3. Execute a classe `app.Main`.

O arquivo `financeiro.db` é criado automaticamente na pasta do projeto.

## 🧭 Próximos passos

- [ ] Cadastrar transações pelo menu
- [ ] Editar e excluir transações
- [ ] Filtrar por categoria e por período
- [ ] Gerar relatório mensal de gastos por categoria
- [ ] Escrever testes unitários com JUnit

## 📚 Aprendizados

Com este projeto pratiquei:

- Separação de responsabilidades em camadas (model, repository, service)
- Uso de `PreparedStatement` para evitar SQL Injection
- `try-with-resources` para fechar conexões automaticamente
- Enums para representar valores fixos do domínio
- `BigDecimal` para cálculos monetários sem erro de arredondamento

## 👤 Autor

**Denis Pellegrin** · [GitHub](https://github.com/PellegrinDenis)
