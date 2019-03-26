package mum.ea.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

//	@Pointcut("execution(* mum.ea.service..save(..)")
//	public void applicationMethod() {}
//	
//	@Pointcut("args(Long)")
//	public void argss() {}
//	
//	
//	@Pointcut("args(obje)")
//	public void argsss(Object obje){}
//	
//	
//	@Before("argsss(obje)&&argss()||applicationMethod()")
//	public void doJointPoint(Object obje) {
//		
//		System.out.println("Got error");
//	}
//	
}
