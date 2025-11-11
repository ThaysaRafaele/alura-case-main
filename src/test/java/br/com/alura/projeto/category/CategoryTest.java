package br.com.alura.projeto.category;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testes da entidade Category")
class CategoryTest {

    @Test
    @DisplayName("Deve criar categoria com todos os atributos")
    void shouldCreateCategoryWithAllAttributes() {
        Category category = new Category(
                "Escola_PROGRAMAÇÃO",
                "prog",
                "#00C86F",
                1);

        // todos os atributos foram definidos?
        assertThat(category.getName()).isEqualTo("Escola_PROGRAMAÇÃO");
        assertThat(category.getCode()).isEqualTo("prog");
        assertThat(category.getColor()).isEqualTo("#00C86F");
        assertThat(category.getOrder()).isEqualTo(1);
    }

    @Test
    @DisplayName("Deve criar categoria com código em minúsculas")
    void shouldCreateCategoryWithLowercaseCode() {
        Category category = new Category(
                "Escola_FRONT-END",
                "front",
                "#19D1D1",
                2);

        // o código está em minúsculas
        assertThat(category.getCode()).isEqualTo("front");
        assertThat(category.getCode()).isLowerCase();
    }

    @Test
    @DisplayName("Deve criar categoria com cor hexadecimal válida")
    void shouldCreateCategoryWithValidHexColor() {
        Category category = new Category(
                "Escola_DATA_SCIENCE",
                "data",
                "#E83E8C",
                3);

        // formato da cor (começa com # e tem 7 caracteres)
        assertThat(category.getColor()).startsWith("#");
        assertThat(category.getColor()).hasSize(7);
    }

    @Test
    @DisplayName("Deve criar múltiplas categorias com ordens diferentes")
    void shouldCreateMultipleCategoriesWithDifferentOrders() {
        Category prog = new Category("Escola_PROGRAMAÇÃO", "prog", "#00C86F", 1);
        Category front = new Category("Escola_FRONT-END", "front", "#19D1D1", 2);
        Category data = new Category("Escola_DATA_SCIENCE", "data", "#E83E8C", 3);

        // verificar as ordens
        assertThat(prog.getOrder()).isLessThan(front.getOrder());
        assertThat(front.getOrder()).isLessThan(data.getOrder());
    }

    @Test
    @DisplayName("Deve permitir categorias com nomes compostos")
    void shouldAllowCategoriesWithCompoundNames() {
        // categoria com nome composto
        Category category = new Category(
                "Escola_INOVAÇÃO_E_GESTÃO",
                "gestao",
                "#FFC107",
                4);

        // aceita _ no nome?
        assertThat(category.getName()).contains("_");
        assertThat(category.getName()).isEqualTo("Escola_INOVAÇÃO_E_GESTÃO");
    }
}