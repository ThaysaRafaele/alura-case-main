package br.com.alura.projeto.course;

import br.com.alura.projeto.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * Representa uma Categoria de cursos.
 * 
 * Características principais:
 * - Categorias organizam os cursos na página inicial
 * e definem cores para identificação visual.
 * 
 * @author Thaysa Rafaele
 * @since 09-11-2025
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 4, max = 10)
    @Column(unique = true)
    private String code;

    @NotBlank
    @Column(name = "instructor_email")
    private String instructorEmail;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @Column(name = "inactivation_date")
    private LocalDateTime inactivationDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Deprecated
    public Course() {
    }

    public Course(String name, String code, String instructorEmail, Category category, String description) {
        this.name = name;
        this.code = code;
        this.instructorEmail = instructorEmail;
        this.category = category;
        this.description = description;
        this.status = Status.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public void inactivate() {
        this.status = Status.INACTIVE;
        this.inactivationDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getInactivationDate() {
        return inactivationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void reactivate() {
        if (this.status == Status.INACTIVE) {
            this.status = Status.ACTIVE;
            this.inactivationDate = null;
        }
    }
}