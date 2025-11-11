# Projeto Alura

Bem-vinda(o) ao teste para **Pessoa Desenvolvedora - Fullstack** da Alura!

Neste desafio, será simulado uma parte do domínio de uma plataforma educacional para que você possa demonstrar seus conhecimentos técnicos.

Não há respostas certas ou erradas, queremos avaliar como você aplica conceitos de lógica e orientação a objetos para resolver problemas.

## Requisitos

- Java 18 ou superior
- Spring Boot
- Spring Data JPA
- MySQL
- Migrações de banco de dados manuais com [Flyway](https://www.baeldung.com/database-migrations-with-flyway)
- HTML, CSS e JavaScript
- JSP

## Instruções

1. Faça o upload do template inicial do projeto no seu repositório GitHub e mantenha-o público (seus commits serão avaliados).
2. Importe o projeto na IDE de sua escolha.
3. O código deve ser todo escrito em inglês, mesmo que os requisitos estejam em português.

## Desafio

O projeto base já contém a configuração das tecnologias requeridas. Algumas funcionalidades relacionadas à entidade `Category` e `User` estão implementadas e podem servir como guia para a resolução das questões.

### Questão 1 - Cadastro de Cursos

Na Alura, grande parte das funcionalidades gira em torno dos cursos. Sua primeira tarefa é listar e implementar o cadastro de cursos, obedecendo às regras definidas abaixo.

#### Atributos

- Nome
- Código (entre 4 e 10 caracteres)
- Instrutor
- Categoria
- Descrição
- Status (`ACTIVE`, `INACTIVE`)
- Data de inativação

#### Regras

- O código do curso deve ser único, textual, sem espaços, números ou caracteres especiais, podendo ser separado por hífen (ex.: `spring-boot-avancado`).
- Os novos cursos devem ser automaticamente definidos como `ACTIVE`.
- O campo "data de inativação" só deve ser preenchido quando o curso for inativado.

> [!TIP]
> Há um ponto de partida no `CourseController` com a rota `admin/course/new`.

### Questão 2 - Inativação de Cursos

Cursos podem ser inativados por diversos motivos, como atualizações ou descontinuação. Você será responsável por implementar essa funcionalidade, seguindo as regras a seguir.

#### Regras

- Acesse a rota `/course/{code}/inactive` para inativar o curso com o código fornecido.
- Ao inativar, o campo "status" deve ser alterado para `INACTIVE` e o campo "data de inativação" deve ser registrado com a data e hora atuais.


### Questão 3 - Front-end página de Login

Com as categorias e os cursos criados, o próximo passo é fazer com que a página de login receba essas informações dinâmica e a estilização de acordo com o Figma disponibilizado.

- [Figma](https://www.figma.com/design/LNOkJ6pnamwQfoWtOlRCPm/Login?node-id=1-303)

> [!TIP]
> Já existe um ponto de partida no `LoginController`.


### Bônus (não obrigatório para as questões 4, 5, 6)

### Questão 4 - Edição de Categorias e Cursos

Com a criação das Categorias e Cursos, podemos criar a edição para ambos.
- Podemos deixar na opção de edição desativar e ativar Cursos.


### Questão 5 - Matrícula de Alunos via API

Com os cursos criados, o próximo passo é permitir que os alunos se matriculem nos cursos disponíveis.

#### Atributos

- Usuário
- Curso
- Data de matrícula

#### Regras

- Um usuário não pode se matricular mais de uma vez no mesmo curso.
- Só é permitido matrícula em cursos ativos.

> [!TIP]
> Já existe um ponto de partida no `RegistrationController`.

### Questão 6 - Relatório de Cursos Mais Acessados via API

Agora que temos usuários e matrículas, queremos gerar um relatório para identificar os cursos mais acessados. Implemente a lógica na rota `/registration/report` para listar os cursos com mais matrículas, ordenados pelo número de inscrições.

> [!IMPORTANT]
> A Alura possui um grande volume de dados. Portanto, priorize o uso de SQL nativo na construção do relatório e evite o [anti-pattern N+1](https://semantix.ai/o-que-e-o-problema-n1/).

## Considerações Finais

- A avaliação será baseada na implementação dos requisitos e na forma como você aplica conceitos de lógica e orientação a objetos.
- Caso tenha dúvidas durante o desenvolvimento, faça anotações no código e implemente o que considerar mais adequado.
- Testes são altamente valorizados, e candidatos que implementarem testes automatizados ganharão pontos extras.
- Códigos muito semelhantes aos de outros candidatos podem resultar na anulação do teste.
- O uso de ferramentas de IA é permitido, mas o código gerado deve ser revisado. Caso avance para a próxima etapa, a entrevista técnica será baseada no código que você produziu.

> [!TIP]
> Para uma melhor organização dos commits, considere seguir as [convenções de commits](https://www.conventionalcommits.org/pt-br/v1.0.0/). Isso ajuda a manter um histórico claro e compreensível do projeto.
>

#### Imagem do projeto rodando em localhost:
<img width="1909" height="965" alt="image" src="https://github.com/user-attachments/assets/0bed835e-3c79-40f3-88fc-a90021961ea3" />

- Listando categorias:
<img width="1637" height="730" alt="image" src="https://github.com/user-attachments/assets/c7ebd88b-d6c9-495c-8f71-ed21e6d80e92" />

- Criando / Editando Categorias
<img width="1524" height="746" alt="image" src="https://github.com/user-attachments/assets/62aef115-6d7f-49f7-96cc-8e8ef98ee61e" />
<img width="1493" height="699" alt="image" src="https://github.com/user-attachments/assets/44acd593-8b6e-411d-ad2b-3a2155326dac" />

- Listando Cursos
<img width="1493" height="657" alt="image" src="https://github.com/user-attachments/assets/ee4e19f3-268e-4a86-b6d6-3dc895ebae37" />

- Criando / Editando Cursos
<img width="1490" height="813" alt="image" src="https://github.com/user-attachments/assets/6657d76d-1fca-4c51-8de3-a4549430f17c" />
<img width="1486" height="815" alt="image" src="https://github.com/user-attachments/assets/43aaa8d3-c6d6-4687-8d44-9ec8d67d5842" />


