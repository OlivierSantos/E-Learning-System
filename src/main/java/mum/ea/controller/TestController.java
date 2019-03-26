package mum.ea.controller;

import mum.ea.amqp.ResourceSvrNotifier;
import mum.ea.batch.MemberBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Course;
import mum.ea.domain.Lesson;
import mum.ea.domain.Material;
import mum.ea.domain.Test;
import mum.ea.service.CourseService;
import mum.ea.service.LessonService;
import mum.ea.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController extends CrudController<Test, TestService> {

    @Autowired
    private MemberBatch memberBatch;
    
    @Autowired
	ResourceSvrNotifier resourceSvrNotifier;
    
    @Autowired
    private LessonService lesssonService;
    
    @Autowired
    private CourseService courseService;
     
    
    @GetMapping(value = "/start")
    public void startBatch() {
        memberBatch.startjob();
    }
    
    @DeleteMapping(value="/message/{id}")
    public String testDeleteMessage(@PathVariable("id") Long id  ) {
    	
    	System.out.println("id: "+id.toString());
    	resourceSvrNotifier.deletePayload(id);
    	
    	
    	return "Successfully delete";
    }
    
    @GetMapping(value="/message/{id}")
    public String testGetMessage(@PathVariable("id") Long id  ) {
    	
    	System.out.println("id: "+id.toString());    	 
    	
    	return resourceSvrNotifier.getPayload(id);
    }
    
    @PostMapping(value="/message")
    public String testSaveMessage() {
    	
    	Material m=new Material();
    	m.setName("Test Resource File");
    	resourceSvrNotifier.savePayload(m);
    	
    	return "Successfully Save";
    	
    }
    
    @PostMapping(value="/lesson")
    public String testSaveLesson() {
    	Lesson l=new Lesson();
    	Course c=courseService.findById(1L).getData();
    	l.setName("Lesson1");
    	l.setCourse(c);
    	lesssonService.save(l);
    	
    	return "Successfully Save" ;
    	
    }
}