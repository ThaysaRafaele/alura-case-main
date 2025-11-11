# Autoria e Decisões de Implementação

**Desenvolvedora:** Thaysa Rafaele  
**Data:** Novembro 2025  
**Contexto:** Case Técnico Alura - Processo Seletivo

---

### 1. Priorização de Testes Automatizados
**Decisão:** Implementei testes ao invés de todas as funcionalidades opcionais (bônus).

**Motivação:**
- compromisso com qualidade de código, código testado é código confiável
- Facilita refatoração futura sem medo de quebrar funcionalidades

**Cobertura de Testes:**
- 9 testes unitários (Course + Category)
- 7 testes de integração (Controllers)

---

### 2. Separação com DTOs
**Decisão:** Usar DTOs (Data Transfer Objects) para receber dados de formulários.

**Motivação:**
- Separar camada de apresentação da camada de domínio
- Permitir validações específicas do formulário

---

## Funcionalidades Implementadas

### Obrigatórias (100%)
- Cadastro de Cursos
- Inativação de Cursos
- Página de Login/Dashboard com cursos por categoria
- Edição e Reativação de Cursos

### Bônus
- Testes Automatizados (16 testes)
- Edição de Categorias

### Não Implementadas
- Matrícula de Alunos (Questão 5)
- Relatório de Cursos (Questão 6)

**Justificativa:** Foco na qualidade x quantidade, investindo tempo em testes e código organizado ao invés de implementar todas as features solicitadas.

---

## Stack Tecnológico

- **Java 21** - Versão LTS mais recente
- **Spring Boot 3.3.3** - Framework principal
- **Spring Data JPA** - Persistência
- **MySQL 8.0** - Banco de dados
- **Flyway** - Versionamento de schema
- **JSP + JSTL** - Templates
- **Bootstrap 5** - Estilização
- **JUnit 5 + AssertJ** - Testes

---

**Última Atualização:** 11/11/2025