package br.com.alura.projeto.course;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CourseDTO(
        Long id,
        String name,
        String code,
        String instructorEmail,
        String description,
        String status,
        String inactivationDate,
        String categoryName) {
    public CourseDTO(Course course) {
        this(
                course.getId(),
                course.getName(),
                course.getCode(),
                course.getInstructorEmail(),
                course.getDescription(),
                course.getStatus().name(),
                formatDate(course.getInactivationDate()),
                course.getCategory().getName());
    }

    private static String formatDate(LocalDateTime date) {
        if (date == null) {
            return "-";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter);
    }
}