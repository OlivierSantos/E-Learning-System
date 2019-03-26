package mum.ea.daoImpl;

import mum.ea.dao.TestDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Test;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl extends GenericDaoImpl<Test> implements TestDao {

    public TestDaoImpl() {
        super.domainClass = Test.class;
    }

}
