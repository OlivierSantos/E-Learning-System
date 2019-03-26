package mum.ea.controller;


import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Category;
import mum.ea.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends CrudController<Category, CategoryService> {
}
