package br.com.alura.projeto.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByCode(String code);

    List<Category> findAllByOrderByOrderAsc();
}
