package mum.ea.controller.abstracts;

import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mum.ea.domain.abstracts.BaseDomain;
import mum.ea.service.abstracts.EaCrudService;

import java.util.List;

public abstract class CrudController<TDomain extends BaseDomain, TService extends EaCrudService<TDomain>>
        extends EaController {

    @Autowired
    private TService service;

    @PostMapping(produces = "application/json")
    public EaResult save(@RequestBody TDomain t) {
        return service.save(t);
    }

    @DeleteMapping("/{id}")
    public EaResult delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping
    public EaResult update(@RequestBody TDomain t) {
        return service.update(t);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public EaResultData<TDomain> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = "application/json")
    public EaResultData<List<TDomain>> findAll() {
        return service.findAll();
    }

}
