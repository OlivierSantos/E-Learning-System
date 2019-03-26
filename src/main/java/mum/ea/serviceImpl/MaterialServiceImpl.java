package mum.ea.serviceImpl;

import mum.ea.amqp.ResourceSvrNotifier;
import mum.ea.dao.MaterialDao;
import mum.ea.domain.Material;
import mum.ea.dto.MailBuilder;
import mum.ea.dto.MailDto;
import mum.ea.mail.EaMailSender;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData; 
import mum.ea.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	ResourceSvrNotifier resourceSvrNotifier;

    @Autowired
    private MaterialDao materialDao;
    
  
    public EaResult save(Material t) {
    	EaResult result = materialDao.save(t);
    	
    	if(result.isSuccess()) {
    		
    		resourceSvrNotifier.savePayload(t);    		
    		
    	}
    	
        return result;
    }

    public EaResult delete(Long id) {
    	EaResult result = materialDao.delete(id);
    	System.out.println("come into deleting");
    	if(result.isSuccess()) {
    		System.out.println("success");
    		resourceSvrNotifier.deletePayload(id);
    	}
    	
    	
       return materialDao.delete(id);
    }

    public EaResult update(Material t) {
       return materialDao.update(t);
    }

    public EaResultData<Material> findById(Long id) {
    	EaResultData<Material> result= materialDao.findById(id);
    	
    	if(result.isSuccess())
    		result.getData().setName(resourceSvrNotifier.getPayload(id));
    	
        return result;
    }

    public EaResultData<List<Material>> findAll() {
        return materialDao.findAll();
    }
}
