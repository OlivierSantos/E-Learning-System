package mum.ea.logger;


import mum.ea.domain.PerformanceLog;
import mum.ea.service.PerformanceLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLogAspect {

    @Autowired
    private PerformanceLogService performanceLogService;

    @Around("@annotation(PerformanceLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long executionTime = System.nanoTime() - start;
        performanceLogService.save(new PerformanceLog(executionTime, joinPoint.getSignature().toString()));
        return proceed;
    }
}
