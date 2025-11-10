<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Curso - Alura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error {
            color: #dc3545;
            font-size: 0.875rem;
            margin-top: 0.25rem;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Cadastrar Novo Curso</h1>

        <div class="card">
            <div class="card-body">
                <form action="/admin/course/new" method="post">
                    
                    <div class="mb-3">
                        <label for="name" class="form-label">Nome do Curso *</label>
                        <input type="text" 
                               class="form-control ${not empty errors['name'] ? 'is-invalid' : ''}" 
                               id="name" 
                               name="name" 
                               value="${param.name}"
                               placeholder="Ex: Spring Boot Avançado"
                               required>
                        <c:if test="${not empty errors['name']}">
                            <div class="invalid-feedback">${errors['name']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="code" class="form-label">Código do Curso *</label>
                        <input type="text" 
                               class="form-control ${not empty errors['code'] ? 'is-invalid' : ''}" 
                               id="code" 
                               name="code" 
                               value="${param.code}"
                               placeholder="Ex: spring-boot-avancado"
                               pattern="^[a-z]+(-[a-z]+)*$"
                               minlength="4"
                               maxlength="10"
                               required>
                        <div class="form-text">
                            Apenas letras minúsculas e hífen, sem espaços ou números (4-10 caracteres)
                        </div>
                        <c:if test="${not empty errors['code']}">
                            <div class="invalid-feedback">${errors['code']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="instructorEmail" class="form-label">Email do Instrutor *</label>
                        <input type="email" 
                               class="form-control ${not empty errors['instructorEmail'] ? 'is-invalid' : ''}" 
                               id="instructorEmail" 
                               name="instructorEmail" 
                               value="${param.instructorEmail}"
                               placeholder="Ex: instrutor@alura.com.br"
                               required>
                        <c:if test="${not empty errors['instructorEmail']}">
                            <div class="invalid-feedback">${errors['instructorEmail']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="categoryId" class="form-label">Categoria *</label>
                        <select class="form-select ${not empty errors['categoryId'] ? 'is-invalid' : ''}" 
                                id="categoryId" 
                                name="categoryId" 
                                required>
                            <option value="">Selecione uma categoria...</option>
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}" 
                                        ${param.categoryId == category.id ? 'selected' : ''}>
                                    ${category.name}
                                </option>
                            </c:forEach>
                        </select>
                        <c:if test="${not empty errors['categoryId']}">
                            <div class="invalid-feedback">${errors['categoryId']}</div>
                        </c:if>
                    </div>

                    <!-- Descrição -->
                    <div class="mb-3">
                        <label for="description" class="form-label">Descrição *</label>
                        <textarea class="form-control ${not empty errors['description'] ? 'is-invalid' : ''}" 
                                  id="description" 
                                  name="description" 
                                  rows="4"
                                  placeholder="Descreva o conteúdo e objetivos do curso..."
                                  required>${param.description}</textarea>
                        <c:if test="${not empty errors['description']}">
                            <div class="invalid-feedback">${errors['description']}</div>
                        </c:if>
                    </div>

                    <div class="d-flex gap-2">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a href="/admin/courses" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="mt-3">
            <small class="text-muted">* Campos obrigatórios</small>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>