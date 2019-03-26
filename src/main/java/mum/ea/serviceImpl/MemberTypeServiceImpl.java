package mum.ea.serviceImpl;

import mum.ea.dao.MemberTypeDao;
import mum.ea.domain.MemberType;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    private MemberTypeDao memberTypeDao;

    public EaResult save(MemberType t) {
      return   memberTypeDao.save(t);
    }

    public EaResult delete(Long id) {
       return memberTypeDao.delete(id);
    }

    public EaResult update(MemberType t) {
      return   memberTypeDao.update(t);
    }

    public EaResultData<MemberType> findById(Long id) {
        return memberTypeDao.findById(id);
    }

    public EaResultData<List<MemberType>> findAll() {
        return memberTypeDao.findAll();
    }
}
