package mum.ea.dao;

import mum.ea.dao.abstracts.GenericDao;
import mum.ea.domain.Course;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;

import java.util.List;

public interface CourseDao extends GenericDao<Course> {
    EaResultData<List<Course>>  listMyCourses(long idMember);
    public EaResult enroll(Long idCourse);
	EaResultData<List<Course>> myArchiveCourse(long currentuserId);
}
