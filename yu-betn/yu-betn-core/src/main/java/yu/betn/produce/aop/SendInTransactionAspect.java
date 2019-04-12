package yu.betn.produce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import yu.betn.AspectOrder;

/**
 * Created by zsp on 2019/4/11.
 */
@Order(AspectOrder.TRANSACTION_INNER_ORDER)
@Aspect
public class SendInTransactionAspect {

    private final Logger logger = LoggerFactory.getLogger(SendInTransactionAspect.class);

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void access() {

    }

    @Around("access()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        if(!((MethodSignature) pjp.getSignature()).getMethod().isAnnotationPresent(
                SendAfterTransactionCommitted.class)) {
            return pjp.proceed();
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
