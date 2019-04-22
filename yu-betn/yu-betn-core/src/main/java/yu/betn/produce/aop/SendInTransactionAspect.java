package yu.betn.produce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import yu.betn.AspectOrder;
import yu.betn.BetnException;

/**
 * Created by zsp on 2019/4/11.
 */
@Order(AspectOrder.TRANSACTION_INNER_ORDER)
@Aspect
public class SendInTransactionAspect {

    private final Logger logger = LoggerFactory.getLogger(SendInTransactionAspect.class);

    @Pointcut("@annotation(yu.betn.produce.aop.SendAfterTransactionCommitted)")
    public void access() {

    }

    @Around("access()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        if(!((MethodSignature) pjp.getSignature()).getMethod().isAnnotationPresent(Transactional.class)) {
            throw new BetnException("The annotation of @SendAfterTransactionCommitted must be with @Transactional.");
        }
        if(logger.isDebugEnabled()) {
            logger.debug("@SendAfterTransactionCommitted: in transaction.");
        }

        Object returnValue = pjp.proceed();

        //TODO persistence produce log
        if(logger.isDebugEnabled()) {
            logger.debug("persistence produce log.");
        }

        return returnValue;
    }

}
