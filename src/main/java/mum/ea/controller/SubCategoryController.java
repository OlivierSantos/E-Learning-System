package mum.ea.controller;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.SubCategory;
import mum.ea.service.SubCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subCategory")
public class SubCategoryController extends CrudController<SubCategory, SubCategoryService> {
}
