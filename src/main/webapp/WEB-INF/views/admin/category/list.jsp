<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Categorias</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Lista de Categorias</h1>
            <a href="/admin/category/new" class="btn btn-primary">+ Nova Categoria</a>
        </div>

        <c:if test="${empty categories}">
            <div class="alert alert-info">
                Nenhuma categoria cadastrada ainda. 
                <a href="/admin/category/new" class="alert-link">Cadastrar a primeira categoria</a>
            </div>
        </c:if>

        <c:if test="${not empty categories}">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Código</th>
                            <th>Cor</th>
                            <th>Ordem</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.name}</td>
                                <td><code>${category.code}</code></td>
                                <td>
                                    <span style="display: inline-block; width: 30px; height: 30px; 
                                                 background-color: ${category.color}; border: 1px solid #ccc; 
                                                 border-radius: 4px; vertical-align: middle;"></span>
                                    <code class="ms-2">${category.color}</code>
                                </td>
                                <td>${category.order}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

        <div class="mt-4">
            <a href="/" class="btn btn-secondary">← Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>