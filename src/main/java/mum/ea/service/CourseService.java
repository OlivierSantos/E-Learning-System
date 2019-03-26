package mum.ea.service;

import mum.ea.domain.Course;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.abstracts.EaCrudService;

import java.util.List;

public interface CourseService extends EaCrudService<Course> {
    EaResultData<List<Course>> listMyCourses();
     EaResult enroll(Long idCourse);
	EaResultData<List<Course>> myArchiveCourses();
}
