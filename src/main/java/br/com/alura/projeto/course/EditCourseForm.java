package br.com.alura.projeto.course;

import br.com.alura.projeto.category.Category;
import br.com.alura.projeto.category.CategoryRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class EditCourseForm {

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 4, max = 10)
    private String code;

    @NotBlank
    @Email
    private String instructorEmail;

    @NotNull
    private Long categoryId;

    @NotBlank
    private String description;

    public void updateCourse(Course course, CategoryRepository categoryRepository) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        course.setName(this.name);
        course.setCode(this.code);
        course.setInstructorEmail(this.instructorEmail);
        course.setCategory(category);
        course.setDescription(this.description);
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}