package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by zsp on 2019/4/22.
 */
public interface OrderReceive {

    String ORDER_RECEIVE = "orderReceive";

    @Input(ORDER_RECEIVE)
    SubscribableChannel inputChannel();

}
