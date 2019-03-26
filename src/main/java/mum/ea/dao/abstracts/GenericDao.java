package mum.ea.dao.abstracts;

import mum.ea.domain.abstracts.BaseDomain;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;

import java.util.List;


public interface GenericDao<TDomain extends BaseDomain> {

    EaResult save(TDomain t);

    EaResult delete(Long id);

    EaResult update(TDomain t);

    EaResultData<TDomain> findById(Long id);

    EaResultData<List<TDomain>> findAll();

}
