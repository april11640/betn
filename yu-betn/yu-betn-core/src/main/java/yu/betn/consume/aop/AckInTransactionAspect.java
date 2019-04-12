package yu.betn.consume.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import yu.betn.AspectOrder;

/**
 * Created by zsp on 2019/4/11.
 */
@Order(AspectOrder.TRANSACTION_INNER_ORDER)
@Aspect
public class AckInTransactionAspect {

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void access() {

    }

    @Around("access()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        if(!((MethodSignature) pjp.getSignature()).getMethod().isAnnotationPresent(
                AckAfterTransactionCommitted.class)) {
            return pjp.proceed();
        }

        //TODO idempotency check

        return pjp.proceed();
    }

}
