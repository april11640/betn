package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by zsp on 2019/4/23.
 */
public interface SimpleSend {

    String SIMPLE_SEND = "simpleSend";

    @Output(SIMPLE_SEND)
    MessageChannel outputChannel();

}
