package mum.ea.daoImpl;


import mum.ea.dao.SubCategoryDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.SubCategory;
import org.springframework.stereotype.Repository;

@Repository
public class SubCategoryDaoImpl extends GenericDaoImpl<SubCategory> implements SubCategoryDao {
    public SubCategoryDaoImpl() {
        super.domainClass = SubCategory.class;
    }
}
