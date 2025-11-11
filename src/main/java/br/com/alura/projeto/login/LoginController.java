package br.com.alura.projeto.login;

import br.com.alura.projeto.category.Category;
import br.com.alura.projeto.category.CategoryRepository;
import br.com.alura.projeto.category.CategoryWithCoursesDTO;
import br.com.alura.projeto.course.CourseRepository;
import br.com.alura.projeto.course.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;

    public LoginController(CategoryRepository categoryRepository, CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Category> categories = categoryRepository.findAllByOrderByOrderAsc();

        List<CategoryWithCoursesDTO> categoriesWithCourses = categories.stream()
                .map(category -> {
                    List<String> courseNames = courseRepository
                            .findByCategoryIdAndStatus(category.getId(), Status.ACTIVE)
                            .stream()
                            .map(course -> course.getName())
                            .collect(Collectors.toList());

                    return new CategoryWithCoursesDTO(category, courseNames);
                })
                .collect(Collectors.toList());

        model.addAttribute("categories", categoriesWithCourses);

        return "login";
    }
}