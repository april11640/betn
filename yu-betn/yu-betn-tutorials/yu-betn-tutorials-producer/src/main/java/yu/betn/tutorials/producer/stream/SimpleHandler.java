package yu.betn.tutorials.producer.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import static yu.betn.tutorials.producer.stream.SimpleReceive.SIMPLE_RECEIVE;

/**
 * Created by zsp on 2019/4/22.
 */
@EnableBinding({SimpleReceive.class})
public class SimpleHandler {

    @StreamListener(SIMPLE_RECEIVE)
    public void handle(String message) {
        System.out.println("Hello：" + message);
    }

}
