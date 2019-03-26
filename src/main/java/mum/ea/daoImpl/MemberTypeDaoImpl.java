package mum.ea.daoImpl;

import mum.ea.dao.MemberTypeDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.MemberType;
import org.springframework.stereotype.Repository;

@Repository
public class MemberTypeDaoImpl extends GenericDaoImpl<MemberType> implements MemberTypeDao {
    public MemberTypeDaoImpl() {
        super.domainClass = MemberType.class;
    }
}
