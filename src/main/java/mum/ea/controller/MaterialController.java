package mum.ea.controller;


import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Material;
import mum.ea.service.MaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/material")
public class MaterialController extends CrudController<Material, MaterialService> {
}
