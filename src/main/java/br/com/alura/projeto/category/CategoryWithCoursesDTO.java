package br.com.alura.projeto.category;

import java.util.List;

public record CategoryWithCoursesDTO(
        Long id,
        String name,
        String code,
        String color,
        int order,
        List<String> courseNames) {
    public CategoryWithCoursesDTO(Category category, List<String> courseNames) {
        this(
                category.getId(),
                category.getName(),
                category.getCode(),
                category.getColor(),
                category.getOrder(),
                courseNames);
    }

    public String getCoursesDescription() {
        if (courseNames == null || courseNames.isEmpty()) {
            return "Explore os cursos dessa categoria";
        }
        return String.join(", ", courseNames);
    }

    public String getIconPath() {
        return switch (code.toLowerCase()) {
            case "prog" -> "/assets/images/icon-color-programacao.png";
            case "front" -> "/assets/images/icon-categoria-frontend.png";
            case "data" -> "/assets/images/icon-Science.png";
            case "ia" -> "/assets/images/icon-ia.png";
            case "devops" -> "/assets/images/icon-categoria-infraestrutura.png";
            case "ux" -> "/assets/images/icon-eye.png";
            case "mobile" -> "/assets/images/icon-categoria-mobile.png";
            case "gestao" -> "/assets/images/icon-light.png";
            default -> "/assets/images/icon-default.png";
        };
    }
}