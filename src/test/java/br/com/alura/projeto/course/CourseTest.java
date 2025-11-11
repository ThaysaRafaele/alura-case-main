package br.com.alura.projeto.course;

import br.com.alura.projeto.category.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testes da entidade Course")
class CourseTest {

    @Test
    @DisplayName("Deve inativar um curso ativo")
    void shouldInactivateCourse() {
        // um curso ativo
        Category category = new Category("Escola_PROGRAMAÇÃO", "prog", "#00C86F", 1);
        Course course = new Course("Java Básico", "java-basico", "instrutor@alura.com.br", category, "Aprenda Java");

        // Quando inativar o curso
        course.inactivate();

        // status deve ser INACTIVE e a data deve ser preenchida
        assertThat(course.getStatus()).isEqualTo(Status.INACTIVE);
        assertThat(course.getInactivationDate()).isNotNull();
        assertThat(course.getInactivationDate()).isBefore(LocalDateTime.now().plusSeconds(1));
    }

    @Test
    @DisplayName("Deve reativar um curso inativo")
    void shouldReactivateCourse() {
        // curso inativo
        Category category = new Category("Escola_PROGRAMAÇÃO", "prog", "#00C86F", 1);
        Course course = new Course("Java Básico", "java-basico", "instrutor@alura.com.br", category, "Aprenda Java");
        course.inactivate();

        // quando reativar o curso
        course.reactivate();

        // o status deve ser ACTIVE e a data de inativação deve ser null
        assertThat(course.getStatus()).isEqualTo(Status.ACTIVE);
        assertThat(course.getInactivationDate()).isNull();
    }

    @Test
    @DisplayName("Não deve alterar status de curso já ativo ao tentar reativar")
    void shouldNotChangeActiveStatusWhenReactivating() {
        // qcurso ativo
        Category category = new Category("Escola_PROGRAMAÇÃO", "prog", "#00C86F", 1);
        Course course = new Course("Java Básico", "java-basico", "instrutor@alura.com.br", category, "Aprenda Java");

        // Ao tentar reativar
        course.reactivate();

        // ddeve continuar ativo sem data de inativação
        assertThat(course.getStatus()).isEqualTo(Status.ACTIVE);
        assertThat(course.getInactivationDate()).isNull();
    }

    @Test
    @DisplayName("Deve criar curso com status ACTIVE por padrão")
    void shouldCreateCourseWithActiveStatus() {
        // ao criar um novo curso
        Category category = new Category("Escola_PROGRAMAÇÃO", "prog", "#00C86F", 1);
        Course course = new Course("Java Básico", "java-basico", "instrutor@alura.com.br", category, "Aprenda Java");

        // o status deve ser ACTIVE
        assertThat(course.getStatus()).isEqualTo(Status.ACTIVE);
        assertThat(course.getInactivationDate()).isNull();
    }
}