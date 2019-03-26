package mum.ea.daoImpl;

import mum.ea.dao.MaterialDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Material;
import mum.ea.domain.Member;
import mum.ea.domain.MemberType;
import mum.ea.model.EaResult;

import org.springframework.stereotype.Repository;

@Repository
public class MaterialDaoImpl extends GenericDaoImpl<Material> implements MaterialDao {
    public MaterialDaoImpl() {
        super.domainClass = Material.class;
    }
    
    
}
