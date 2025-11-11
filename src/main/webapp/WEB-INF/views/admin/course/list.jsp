<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Cursos - Alura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Lista de Cursos</h1>
            <a href="/admin/course/new" class="btn btn-primary">+ Novo Curso</a>
        </div>

        <c:if test="${empty courses}">
            <div class="alert alert-info">
                Nenhum curso cadastrado ainda. 
                <a href="/admin/course/new" class="alert-link">Cadastrar o primeiro curso</a>
            </div>
        </c:if>

        <c:if test="${not empty courses}">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Código</th>
                            <th>Instrutor</th>
                            <th>Categoria</th>
                            <th>Status</th>
                            <th>Data Inativação</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="course" items="${courses}">
                            <tr>
                                <td>${course.id()}</td>
                                <td>${course.name()}</td>
                                <td><code>${course.code()}</code></td>
                                <td>${course.instructorEmail()}</td>
                                <td>${course.categoryName()}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${course.status() == 'ACTIVE'}">
                                            <span class="badge bg-success">Ativo</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-danger">Inativo</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${course.inactivationDate()}</td>
                                <td>
                                    <c:if test="${course.status() == 'ACTIVE'}">
                                        <form action="/course/${course.code()}/inactive" method="post" 
                                              style="display: inline;" 
                                              onsubmit="return handleInactivate(event, this)">
                                            <button type="submit" class="btn btn-sm btn-warning">
                                                Inativar
                                            </button>
                                        </form>
                                    </c:if>
                                </td>
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
    
    <script>
    function handleInactivate(event, form) {
        if (confirm('Deseja realmente inativar este curso?')) {
            event.preventDefault();
            
            fetch(form.action, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                }
            })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('Erro ao inativar o curso. Tente novamente.');
                }
            })
            .catch(error => {
                console.error('Erro:', error);
                alert('Erro ao inativar o curso. Tente novamente.');
            });
            
            return false;
        }
        return false;
    }
    </script>
</body>
</html>