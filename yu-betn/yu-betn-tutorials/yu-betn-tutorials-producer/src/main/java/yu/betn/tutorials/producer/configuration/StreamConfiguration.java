package yu.betn.tutorials.producer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import yu.betn.tutorials.producer.domain.Order;
import yu.betn.tutorials.producer.stream.OrderHandler;
import yu.betn.tutorials.producer.stream.OrderProcessor;
import yu.betn.tutorials.producer.stream.SimpleHandler;
import yu.betn.tutorials.producer.stream.SimpleProcessor;

import static yu.betn.tutorials.producer.stream.Constants.ORDER_RECEIVE;
import static yu.betn.tutorials.producer.stream.Constants.SIMPLE_RECEIVE;

/**
 * Created by zsp on 2019/4/22.
 */
@EnableBinding({SimpleProcessor.class, OrderProcessor.class})
public class StreamConfiguration {

    @Autowired
    private SimpleHandler simpleHandler;

    @Autowired
    private OrderHandler orderHandler;

    @StreamListener(SIMPLE_RECEIVE)
    public void handleSimple(String message) {
        simpleHandler.handle(message);
    }

    @StreamListener(ORDER_RECEIVE)
    public void handleOrder(Order order) {
        orderHandler.handle(order);
    }

}
