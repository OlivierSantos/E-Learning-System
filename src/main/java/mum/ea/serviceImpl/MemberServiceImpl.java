package mum.ea.serviceImpl;

import mum.ea.dao.MemberDao;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.MemberService;
import mum.ea.validation.EaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @EaValidate
    public EaResult save(Member t) {
       return memberDao.save(t);
    }

    public EaResult delete(Long id) {
       return memberDao.delete(id);
    }

    public EaResult update(Member t) {
      return   memberDao.update(t);
    }

    public EaResultData<Member> findById(Long id) {
        return memberDao.findById(id);
    }

    public EaResultData<List<Member>> findAll() {
        return memberDao.findAll();
    }
    

	public List<Course> myCourses(Long id) {
		return  memberDao.myCourses(id);
	}

}
