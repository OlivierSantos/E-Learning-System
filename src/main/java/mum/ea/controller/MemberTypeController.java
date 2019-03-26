package mum.ea.controller;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.MemberType;
import mum.ea.service.MemberTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memberType")
public class MemberTypeController extends CrudController<MemberType, MemberTypeService> {
}
