package mum.ea.serviceImpl;

import mum.ea.dao.LessonDao;
import mum.ea.domain.Lesson;
import mum.ea.dto.MailBuilder;
import mum.ea.dto.MailDto;
import mum.ea.mail.EaMailSender;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.LessonService;
import mum.ea.validation.EaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;
    
  @Autowired
  private EaMailSender eaMailSender;

    @Secured(value = "ROLE_ADD_LESSON")
    @EaValidate
    public EaResult save(Lesson lesson) {

    	EaResult result= lessonDao.save(lesson);
       
   	if(result.isSuccess()) {
	       MailBuilder mailBuilder = new MailBuilder();
	       MailDto mailDto = mailBuilder.buildTo(lesson.getCourse().getInstructor().getMail())
	               .buildName(lesson.getCourse().getInstructor().getFirstname() + " " + lesson.getCourse().getInstructor().getLastname())
	               .buildSubject("Successfully create lesson")
	               .buildTemplate("lessonTemp")
	               .build();
	       eaMailSender.sendMail(mailDto);
	       
	   	
	    	}
   	
    return result;
    }
    
   

    public EaResult delete(Long id) {
       return lessonDao.delete(id);
    }

    @Secured(value = "ROLE_ADD_LESSON")
    public EaResult update(Lesson t) {
        return lessonDao.update(t);
    }

    public EaResultData<Lesson> findById(Long id) {
        return lessonDao.findById(id);
    }

    public EaResultData<List<Lesson>> findAll() {
        return lessonDao.findAll();
    }
}
