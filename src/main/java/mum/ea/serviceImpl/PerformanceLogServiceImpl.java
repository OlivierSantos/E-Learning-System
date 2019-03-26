package mum.ea.serviceImpl;

import mum.ea.dao.PerformanceLogDao;
import mum.ea.domain.PerformanceLog;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.PerformanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PerformanceLogServiceImpl implements PerformanceLogService {

    @Autowired
    private PerformanceLogDao performanceLogDao;

    public EaResult save(PerformanceLog t) {
      return   performanceLogDao.save(t);
    }

    public EaResult delete(Long id) {
        return null;
    }

    public EaResult update(PerformanceLog t) {
        return null;
    }

    public EaResultData<PerformanceLog> findById(Long id) {
        return null;
    }

    public EaResultData<List<PerformanceLog>> findAll() {
        return performanceLogDao.findAll();
    }
}
