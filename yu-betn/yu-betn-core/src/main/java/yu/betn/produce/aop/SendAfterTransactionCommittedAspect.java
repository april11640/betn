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
import yu.betn.produce.domain.ProduceLogHolder;
import yu.betn.produce.service.api.ProduceLogService;

import java.util.Objects;

/**
 * Created by zsp on 2019/4/11.
 */
@Order(AspectOrder.TRANSACTION_OUTER_ORDER)
@Aspect
public class SendAfterTransactionCommittedAspect {

    private final Logger logger = LoggerFactory.getLogger(SendAfterTransactionCommittedAspect.class);

    private final ProduceLogService produceLogService;

    public SendAfterTransactionCommittedAspect(ProduceLogService produceLogService) {
        Objects.requireNonNull(produceLogService);
        this.produceLogService = produceLogService;
    }

    @Pointcut("@annotation(yu.betn.produce.aop.SendAfterTransactionCommitted)")
    public void access() {

    }

    @Around("access()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        if(!((MethodSignature) pjp.getSignature()).getMethod().isAnnotationPresent(Transactional.class)) {
            throw new BetnException("The annotation of @SendAfterTransactionCommitted must be with @Transactional.");
        }
        if(logger.isDebugEnabled()) {
            logger.debug("@SendAfterTransactionCommitted: out transaction.");
        }

        ProduceLogHolder.clear();
        try{
            Object returnValue = pjp.proceed();
            if(isSuccess(returnValue)) {
                if(logger.isDebugEnabled()) {
                    logger.debug("emit produce log.");
                }
                produceLogService.emitProduceLog();
            }

            return returnValue;
        } finally {
            ProduceLogHolder.clear();
        }
    }

    private boolean isSuccess(Object result) {
        return true;
    }

}
