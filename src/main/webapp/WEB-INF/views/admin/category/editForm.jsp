<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Categoria</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Editar Categoria</h1>

        <div class="card">
            <div class="card-body">
                <form action="/admin/category/edit/${categoryId}" method="post">
                    
                    <div class="mb-3">
                        <label for="name" class="form-label">Nome da Categoria *</label>
                        <input type="text" 
                               class="form-control ${not empty errors['name'] ? 'is-invalid' : ''}" 
                               id="name" 
                               name="name" 
                               value="${param.name != null ? param.name : form.name}"
                               placeholder="Ex: Escola_PROGRAMAÇÃO"
                               required>
                        <div class="form-text">
                            Nome da escola/categoria (ex: Escola_PROGRAMAÇÃO, Escola_FRONT-END)
                        </div>
                        <c:if test="${not empty errors['name']}">
                            <div class="invalid-feedback">${errors['name']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="code" class="form-label">Código *</label>
                        <input type="text" 
                               class="form-control ${not empty errors['code'] ? 'is-invalid' : ''}" 
                               id="code" 
                               name="code" 
                               value="${param.code != null ? param.code : form.code}"
                               placeholder="Ex: prog"
                               pattern="^[a-z]+(-[a-z]+)*$"
                               minlength="4"
                               maxlength="10"
                               required>
                        <div class="form-text">
                            Código único da categoria (4-10 caracteres)
                        </div>
                        <c:if test="${not empty errors['code']}">
                            <div class="invalid-feedback">${errors['code']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="color" class="form-label">Cor *</label>
                        <input type="color" 
                               class="form-control form-control-color ${not empty errors['color'] ? 'is-invalid' : ''}" 
                               id="color" 
                               name="color" 
                               value="${param.color != null ? param.color : form.color}"
                               required>
                        <div class="form-text">
                            Escolha a cor que representa esta categoria
                        </div>
                        <c:if test="${not empty errors['color']}">
                            <div class="invalid-feedback">${errors['color']}</div>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="order" class="form-label">Ordem de Exibição *</label>
                        <input type="number" 
                               class="form-control ${not empty errors['order'] ? 'is-invalid' : ''}" 
                               id="order" 
                               name="order" 
                               value="${param.order != null ? param.order : form.order}"
                               min="1"
                               placeholder="Ex: 1"
                               required>
                        <div class="form-text">
                            Ordem em que a categoria aparecerá na listagem
                        </div>
                        <c:if test="${not empty errors['order']}">
                            <div class="invalid-feedback">${errors['order']}</div>
                        </c:if>
                    </div>

                    <div class="d-flex gap-2">
                        <button type="submit" class="btn btn-primary">Salvar Alterações</button>
                        <a href="/admin/categories" class="btn btn-secondary">Cancelar</a>
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