package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by zsp on 2019/4/23.
 */
public interface OrderSend {

    String ORDER_SEND = "orderSend";

    @Output(ORDER_SEND)
    MessageChannel outputChannel();

}
