package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by zsp on 2019/4/22.
 */
public interface SimpleReceive {

    String SIMPLE_RECEIVE = "simpleReceive";

    @Input(SIMPLE_RECEIVE)
    SubscribableChannel inputChannel();

}
