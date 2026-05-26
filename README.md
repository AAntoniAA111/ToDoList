# 📝 To-Do List com Banco de Dados em Java

Projeto desenvolvido em Java com conexão a banco de dados MySQL, permitindo gerenciar tarefas pelo terminal com operações de criar, listar, concluir e excluir.

---

## 👩‍💻 Desenvolvedoras

| Desenvolvedora | Arquivos |
|---|---|
| **Vitória** | `Main.java`, `TarefaDAO.java` |
| **Eu (seu nome)** | `Tarefas.java`, `ConexaoDB.java` |

---

## 🗂️ Estrutura do Projeto

```
todolist/
├── src/
│   └── main/java/
│       ├── model/
│       │   └── Tarefas.java       # Modelo da tarefa (atributos, getters/setters)
│       ├── dao/
│       │   └── TarefaDAO.java     # Operações com o banco (CRUD)
│       ├── db/
│       │   └── ConexaoDB.java     # Conexão com o MySQL
│       └── Main.java              # Menu interativo no terminal
└── pom.xml
```

---

## ⚙️ Funcionalidades

- ✅ Adicionar nova tarefa
- 📋 Listar todas as tarefas
- ✔️ Marcar tarefa como concluída
- 🗑️ Excluir tarefa
- 🔍 Buscar tarefa por ID

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **MySQL**
- **JDBC** (Java Database Connectivity)
- **IntelliJ IDEA**

---

## 🗄️ Configuração do Banco de Dados

1. Crie o banco de dados no MySQL:

```sql
CREATE DATABASE ToDoList;

USE ToDoList;

CREATE TABLE tarefas (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    titulo       VARCHAR(255) NOT NULL,
    descricao    TEXT,
    concluida    BOOLEAN DEFAULT FALSE,
    data_criacao DATE
);
```

2. Configure as credenciais em `ConexaoDB.java`:

```java
private static final String URL  = "jdbc:mysql://localhost:3306/ToDoList";
private static final String USER = "root";
private static final String PASSWORD = "sua_senha";
```

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/todolist-java.git
```

2. Abra o projeto no IntelliJ IDEA

3. Configure o banco de dados conforme a seção acima

4. Execute a classe `Main.java`

5. Interaja com o menu no terminal:

```
╔══════════════════════════════╗
║     BEM-VINDOS AO TO-DO!     ║
╚══════════════════════════════╝

--- MENU ---
1 - Adicionar tarefa
2 - Listar tarefas
3 - Concluir tarefa
4 - Excluir tarefa
5 - Buscar tarefa por ID
0 - Sair
```

---

## 📐 Arquitetura do Projeto

O projeto segue o padrão **DAO (Data Access Object)**, separando as responsabilidades em camadas:

```
Main.java         →   Interface com o usuário (menu)
    ↓
TarefaDAO.java    →   Comunicação com o banco (SQL)
    ↓
ConexaoDB.java    →   Conexão JDBC com o MySQL
    ↓
Tarefas.java      →   Modelo de dados (atributos da tarefa)
```

---

## 📚 Conceitos Aplicados

- **Orientação a Objetos** — encapsulamento com getters e setters
- **Padrão DAO** — separação entre lógica de negócio e acesso a dados
- **JDBC** — conexão e manipulação do banco via Java
- **PreparedStatement** — proteção contra SQL Injection
- **Try-with-resources** — gerenciamento automático de conexões
