package yu.betn.consume.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import yu.betn.AspectOrder;
import yu.betn.BetnException;

/**
 * Created by zsp on 2019/4/11.
 */
@Order(AspectOrder.TRANSACTION_OUTER_ORDER)
@Aspect
public class AckAfterTransactionCommittedAspect {

    @Pointcut("@annotation(yu.betn.consume.aop.AckAfterTransactionCommitted)")
    public void access() {

    }

    @Around("access()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        if(!((MethodSignature) pjp.getSignature()).getMethod().isAnnotationPresent(Transactional.class)) {
            throw new BetnException("The annotation of @AckAfterTransactionCommitted must be with @Transactional.");
        }

        try{
            Object returnValue = pjp.proceed();

            //TODO ack

            return returnValue;
        } finally {

        }
    }

}
