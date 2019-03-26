package mum.ea.daoImpl;

import mum.ea.dao.CategoryDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
    public CategoryDaoImpl() {
        super.domainClass = Category.class;
    }
}
