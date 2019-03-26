package mum.ea.serviceImpl;

import mum.ea.dao.CategoryDao;
import mum.ea.domain.Category;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public EaResult save(Category t) {
      return  categoryDao.save(t);
    }

    public EaResult delete(Long id) {
        return categoryDao.delete(id);
    }

    public EaResult update(Category t) {
        return categoryDao.update(t);
    }

    public EaResultData<Category> findById(Long id) {
        return categoryDao.findById(id);
    }

    public EaResultData<List<Category>> findAll() {
        return categoryDao.findAll();
    }
}
