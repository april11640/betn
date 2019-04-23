package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import yu.betn.tutorials.producer.domain.Order;

import static yu.betn.tutorials.producer.stream.OrderReceive.ORDER_RECEIVE;

/**
 * Created by zsp on 2019/4/22.
 */
@EnableBinding({OrderReceive.class})
public class OrderHandler {

    @StreamListener(ORDER_RECEIVE)
    public void handle(Order order) {
        System.out.println("Order：" + order);
        throw new RuntimeException("test a exception");
    }

    @ServiceActivator(inputChannel = "pri.test.order.q.errors")
    public void error(Message<?> message) {
        System.err.println("Message consumer failed, call fallback! " + message);
    }

}
