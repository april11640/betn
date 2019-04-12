package yu.betn.produce.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 最大努力通知事务（Best effort to notify）- 在事务提交后发送通知
 *
 * 在业务逻辑中收集通知，然后在业务逻辑本地事务提交之后发送（异常引起事务回滚不发送通知），
 * 但并不保证通知消息的发送是否成功。
 *
 * @author zsp
 *
 */
@Target({ METHOD })
@Retention(RUNTIME)
public @interface SendAfterTransactionCommitted {

}
