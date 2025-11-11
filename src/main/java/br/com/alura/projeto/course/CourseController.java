package br.com.alura.projeto.course;

import br.com.alura.projeto.category.CategoryDTO;
import br.com.alura.projeto.category.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseController(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/admin/courses")
    public String list(Model model) {
        List<CourseDTO> courses = courseRepository.findAll()
                .stream()
                .map(CourseDTO::new)
                .toList();

        model.addAttribute("courses", courses);

        return "admin/course/list";
    }

    @GetMapping("/admin/course/new")
    public String create(NewCourseForm form, Model model) {
        List<CategoryDTO> categories = categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();

        model.addAttribute("categories", categories);

        return "admin/course/newForm";
    }

    @Transactional
    @PostMapping("/admin/course/new")
    public String save(@Valid NewCourseForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(form, model);
        }

        if (courseRepository.existsByCode(form.getCode())) {
            result.rejectValue("code", "Duplicate.code", "Já existe um curso com este código");
            return create(form, model);
        }

        Course course = form.toModel(categoryRepository);
        courseRepository.save(course);

        return "redirect:/admin/courses";
    }

    @Transactional
    @PostMapping("/course/{code}/inactive")
    public ResponseEntity<?> updateStatus(@PathVariable("code") String courseCode) {
        Course course = courseRepository.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        course.inactivate();
        courseRepository.save(course);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/admin/course/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        EditCourseForm form = new EditCourseForm();
        form.setName(course.getName());
        form.setCode(course.getCode());
        form.setInstructorEmail(course.getInstructorEmail());
        form.setCategoryId(course.getCategory().getId());
        form.setDescription(course.getDescription());

        List<CategoryDTO> categories = categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();

        model.addAttribute("form", form);
        model.addAttribute("courseId", id);
        model.addAttribute("courseStatus", course.getStatus());
        model.addAttribute("categories", categories);

        return "admin/course/editForm";
    }

    @Transactional
    @PostMapping("/admin/course/edit/{id}")
    public String update(@PathVariable("id") Long id,
            @Valid EditCourseForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            List<CategoryDTO> categories = categoryRepository.findAll()
                    .stream()
                    .map(CategoryDTO::new)
                    .toList();
            model.addAttribute("courseId", id);
            model.addAttribute("categories", categories);
            return "admin/course/editForm";
        }

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        courseRepository.findAll().stream()
                .filter(c -> !c.getId().equals(id))
                .filter(c -> c.getCode().equals(form.getCode()))
                .findFirst()
                .ifPresent(c -> {
                    result.rejectValue("code", "Duplicate.code", "Já existe outro curso com este código");
                });

        if (result.hasErrors()) {
            List<CategoryDTO> categories = categoryRepository.findAll()
                    .stream()
                    .map(CategoryDTO::new)
                    .toList();
            model.addAttribute("courseId", id);
            model.addAttribute("categories", categories);
            return "admin/course/editForm";
        }

        form.updateCourse(course, categoryRepository);
        courseRepository.save(course);

        return "redirect:/admin/courses";
    }

    @Transactional
    @PostMapping("/course/{id}/reactivate")
    public String reactivate(@PathVariable("id") Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        course.reactivate();
        courseRepository.save(course);

        return "redirect:/admin/courses";
    }
}