package name.luoyong.spring.aspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PoliceAspect {
	
	@Pointcut("execution(public * name.luoyong.spring.aspect.animal.Fox.findChicken())")
	public void find() {}
	
	@Pointcut("execution(public * name.luoyong.spring.aspect.animal.Fox.stealChicken())")
	public void steal() {}
	
	@Before("find()")
	public void watch() {
		System.out.println("Police is watching fox");
	}
	
	
	@Around("steal()")
	public void catch2(ProceedingJoinPoint pjp) throws Throwable {
		pjp.proceed();
		System.out.println("Police Catched fox");
	}

}
