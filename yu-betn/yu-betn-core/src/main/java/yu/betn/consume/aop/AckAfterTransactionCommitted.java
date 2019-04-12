package yu.betn.consume.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 最大努力通知事务（Best effort to notify）- 在事务提交后回执确认
 *
 * 在通知消息消费的业务逻辑本地事务提交之后发送通知的回执（异常引起事务回滚不发送回执），但并不保证回执的发送是否成功。
 *
 * @author zsp
 *
 */
@Target({ METHOD })
@Retention(RUNTIME)
public @interface AckAfterTransactionCommitted {
}
