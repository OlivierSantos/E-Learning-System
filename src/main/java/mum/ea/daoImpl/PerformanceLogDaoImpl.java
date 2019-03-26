package mum.ea.daoImpl;

import mum.ea.dao.PerformanceLogDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.PerformanceLog;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceLogDaoImpl extends GenericDaoImpl<PerformanceLog> implements PerformanceLogDao {
    public PerformanceLogDaoImpl() {
        super.domainClass = PerformanceLog.class;
    }
}
