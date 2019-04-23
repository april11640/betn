package yu.betn.tutorials.producer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import static yu.betn.tutorials.producer.stream.SimpleSend.SIMPLE_SEND;

/**
 * Created by zsp on 2019/4/22.
 */
@EnableBinding({SimpleSend.class})
public class SimpleTemplate {

    @Autowired
    @Qualifier(SIMPLE_SEND)
    private MessageChannel outChannel;

    public void send(String message) {
        outChannel.send(MessageBuilder.withPayload(message).build());
    }

}
