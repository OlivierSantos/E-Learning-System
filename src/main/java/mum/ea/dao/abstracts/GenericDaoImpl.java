package mum.ea.dao.abstracts;

import mum.ea.domain.abstracts.BaseDomain;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDaoImpl<TDomain extends BaseDomain> implements GenericDao<TDomain> {

    @PersistenceContext

    protected EntityManager entityManager;

    protected Class<TDomain> domainClass;


    public EaResult save(TDomain t) {
        entityManager.persist(t);
        return new EaResult().makeSuccess();
    }

    private void delete(TDomain entity) {
        entityManager.remove(entity);
    }

    public EaResult delete(Long id) {
        TDomain entity = findById(id).getData();
        delete(entity);
        return new EaResult().makeSuccess();
    }

    public EaResult update(TDomain t) {
        entityManager.merge(t);
        return new EaResult().makeSuccess();
    }

    public EaResultData<TDomain> findById(Long id) {
        EaResultData<TDomain> result = new EaResultData<TDomain>();
        result.setData((TDomain) entityManager.find(domainClass, id));
        result.makeSuccess();
        return result;
    }

    public EaResultData<List<TDomain>> findAll() {
        EaResultData<List<TDomain>> result = new EaResultData<List<TDomain>>();
        result.setData(entityManager.createQuery("from " + domainClass.getName()).getResultList());
        result.makeSuccess();
        return result;
    }
}
