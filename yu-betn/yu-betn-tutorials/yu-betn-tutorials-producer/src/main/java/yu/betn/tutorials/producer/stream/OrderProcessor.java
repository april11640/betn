package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import static yu.betn.tutorials.producer.stream.Constants.ORDER_RECEIVE;
import static yu.betn.tutorials.producer.stream.Constants.ORDER_SEND;

/**
 * Created by zsp on 2019/4/22.
 */
public interface OrderProcessor {

    @Input(ORDER_RECEIVE)
    SubscribableChannel inputChannel();

    @Output(ORDER_SEND)
    MessageChannel outputChannel();

}