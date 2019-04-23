package yu.betn.tutorials.producer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import yu.betn.tutorials.producer.domain.Order;

import static yu.betn.tutorials.producer.stream.OrderSend.ORDER_SEND;

/**
 * Created by zsp on 2019/4/22.
 */
@EnableBinding({OrderSend.class})
public class OrderTemplate {

    @Autowired
    @Qualifier(ORDER_SEND)
    private MessageChannel outputChannel;

    public void send(Order order) {
        outputChannel.send(MessageBuilder.withPayload(order).build());
    }

}
