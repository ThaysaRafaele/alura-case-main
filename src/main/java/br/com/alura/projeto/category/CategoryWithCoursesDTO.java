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
}