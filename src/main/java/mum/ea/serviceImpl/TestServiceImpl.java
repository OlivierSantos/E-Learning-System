package mum.ea.serviceImpl;

import mum.ea.logger.PerformanceLog;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.validation.EaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import mum.ea.domain.Test;
import mum.ea.dao.TestDao;
import mum.ea.service.TestService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @EaValidate
    public EaResult save(Test t) {
        return testDao.save(t);
    }

    public EaResult delete(Long id) {
        return testDao.delete(id);
    }

    @EaValidate
    public EaResult update(Test t) {
        return testDao.update(t);
    }

    public EaResultData<Test> findById(Long id) {
        return testDao.findById(id);
    }


    @Secured("ROLE_test")

    @PerformanceLog
    public EaResultData<List<Test>> findAll() {
        return testDao.findAll();
    }

}
