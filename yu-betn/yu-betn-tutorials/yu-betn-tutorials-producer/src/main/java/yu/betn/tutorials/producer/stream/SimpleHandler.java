package yu.betn.tutorials.producer.stream;

import org.springframework.stereotype.Component;

/**
 * Created by zsp on 2019/4/22.
 */
@Component
public class SimpleHandler {

    public void handle(String message) {
        System.out.println("Hello：" + message);
    }

}
