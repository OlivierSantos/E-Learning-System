package mum.ea.controller;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.model.EaResultData;
import mum.ea.service.CourseService;
import mum.ea.service.MemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController extends CrudController<Member, MemberService> {


	@Autowired
	MemberService memberService;
	//Member courses
	
			@RequestMapping(value="/mycourses/member/{id}",method=RequestMethod.GET)
			
			public @ResponseBody List<Course> myCourses(@PathVariable("id") Long id) {
				
				return memberService.myCourses(id);
			}
	
	
}
