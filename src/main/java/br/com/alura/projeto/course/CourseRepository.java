package br.com.alura.projeto.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Verifica se já existe um curso com o código informado
    boolean existsByCode(String code);

    // Busca um curso pelo código
    Optional<Course> findByCode(String code);
}