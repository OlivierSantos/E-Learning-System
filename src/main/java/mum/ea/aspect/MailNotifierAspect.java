package mum.ea.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.ea.domain.Lesson;
import mum.ea.dto.MailBuilder;
import mum.ea.dto.MailDto;
import mum.ea.mail.EaMailSender;
import mum.ea.model.EaResult;
 
@Aspect
@Component
public class MailNotifierAspect {
	
//    @Autowired
//    private EaMailSender eaMailSender;
//	
//	// @AfterReturning(pointcut="execution(* mum.ea.serviceimpl.LessonServiceImpl.save(..) && args(t))", returning="retVal")
//    @AfterReturning(pointcut="execution(* mum.ea.serviceImpl.LessonService.save(..)) && args(t)", returning="retVal")
//	  public void notify(JoinPoint joinPoint,Object retVal,Lesson t) {
//		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********"); 
//		EaResult result=(EaResult)retVal;
//		if(result.isSuccess()) {
//		       MailBuilder mailBuilder = new MailBuilder();
//		       MailDto mailDto = mailBuilder.buildTo(t.getCourse().getInstructor().getMail())
//		               .buildName(t.getCourse().getInstructor().getFirstname() + " " + t.getCourse().getInstructor().getLastname())
//		               .buildSubject("Successfully create lesson")
//		               .buildTemplate("lessonTemp")
//		               .build();
//		       eaMailSender.sendMail(mailDto);
//		       
//		   	System.out.println("email send to instructor");
//		    	}	
//	
		    	
	//}
	
	
}
