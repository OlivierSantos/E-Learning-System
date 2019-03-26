package mum.ea.controller;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Lesson;
import mum.ea.service.LessonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lesson")
public class LessonController extends CrudController<Lesson, LessonService> {


}
