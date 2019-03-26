package mum.ea.serviceImpl;

import mum.ea.dao.SubCategoryDao;
import mum.ea.domain.SubCategory;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryDao subCategoryDao;

    public EaResult save(SubCategory t) {
       return subCategoryDao.save(t);
    }

    public EaResult delete(Long id) {
       return subCategoryDao.delete(id);
    }

    public EaResult update(SubCategory t) {
       return subCategoryDao.update(t);
    }

    public EaResultData<SubCategory> findById(Long id) {
        return subCategoryDao.findById(id);
    }

    public EaResultData<List<SubCategory>> findAll() {
        return subCategoryDao.findAll();
    }
}
