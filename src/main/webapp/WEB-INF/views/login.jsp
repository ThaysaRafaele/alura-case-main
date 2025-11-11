<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/login.css">
</head>
<body>
    <div class="container">
        <div class="login-box">
            <h2>Já estuda com a gente?</h2>
            <p>Faça seu login e boa aula!</p>
            <a href="/admin/categories" class="btn-login">ENTRAR</a>
        </div>
        
        <div class="courses">
            <h2>Ainda não estuda com a gente?</h2>
            <p>São mais de mil cursos nas seguintes áreas:</p>
            
            <div class="grid">
                <c:forEach var="category" items="${categories}">
                    <div class="card" style="--card-color: ${category.color()}">
                        <div class="card-icon">
                            <img src="${category.getIconPath()}" 
                                 alt="${category.name()}" 
                                 onerror="this.style.display='none'; this.parentNode.innerHTML='${category.code().substring(0, 1).toUpperCase()}'">
                        </div>
                        <h3>${category.name()}</h3>
                        <p>${category.getCoursesDescription()}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>