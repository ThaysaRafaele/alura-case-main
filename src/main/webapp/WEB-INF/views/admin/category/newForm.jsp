<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nova Categoria - Alura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .color-preview {
            width: 40px;
            height: 40px;
            border-radius: 4px;
            border: 2px solid #dee2e6;
            display: inline-block;
            vertical-align: middle;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Cadastrar Nova Categoria</h1>

        <div class="card">
            <div class="card-body">
                <form action="/admin/category/new" method="post">
                    
                    <div class="mb-3">
                        <label for="name" class="form-label">Nome da Categoria *</label>
                        <input type="text" 
                               class="form-control" 
                               id="name" 
                               name="name" 
                               value="${param.name}"
                               placeholder="Ex: Escola_PROGRAMAÇÃO"
                               required>
                        <div class="form-text">
                            Nome da escola/categoria (ex: Escola_PROGRAMAÇÃO, Escola_FRONT-END)
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="code" class="form-label">Código *</label>
                        <input type="text" 
                               class="form-control" 
                               id="code" 
                               name="code" 
                               value="${param.code}"
                               placeholder="Ex: prog"
                               minlength="4"
                               maxlength="10"
                               required>
                        <div class="form-text">
                            Código único da categoria (4-10 caracteres)
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="color" class="form-label">Cor *</label>
                        <div class="d-flex align-items-center">
                            <input type="color" 
                                   class="form-control form-control-color" 
                                   id="color" 
                                   name="color" 
                                   value="${param.color != null ? param.color : '#0066cc'}"
                                   style="width: 80px;"
                                   required>
                            <span class="ms-2">Escolha a cor que representa esta categoria</span>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="order" class="form-label">Ordem de Exibição *</label>
                        <input type="number" 
                               class="form-control" 
                               id="order" 
                               name="order" 
                               value="${param.order}"
                               min="1"
                               placeholder="Ex: 1"
                               style="max-width: 150px;"
                               required>
                        <div class="form-text">
                            Ordem em que a categoria aparecerá na listagem
                        </div>
                    </div>

                    <div class="d-flex gap-2">
                        <button type="submit" class="btn btn-primary">Salvar Categoria</button>
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