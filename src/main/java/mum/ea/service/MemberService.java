package mum.ea.service;

import java.util.List;

import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.model.EaResultData;
import mum.ea.service.abstracts.EaCrudService;

public interface MemberService extends EaCrudService<Member> {

	List<Course> myCourses(Long id);
}
