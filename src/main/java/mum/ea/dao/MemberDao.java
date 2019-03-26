package mum.ea.dao;

import java.util.List;

import mum.ea.dao.abstracts.GenericDao;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.model.EaResultData;

public interface MemberDao extends GenericDao<Member>{

	//List<Member> findByMemberType(String memberType);

//	List<Course> searchCourses(long id, String coursename);
List<Course> myCourses(long id);
//
//	List<Course> myArchiveCourses(long id);
//
//	List<Course> myInProgressCourses(long id);
//
//	Member findByUserName(String username);
//
//	boolean exit(String username, String password);

}
