package yu.betn.tutorials.producer.stream;

import org.springframework.stereotype.Component;
import yu.betn.tutorials.producer.domain.Order;

/**
 * Created by zsp on 2019/4/22.
 */
@Component
public class OrderHandler {

    public void handle(Order order) {
        System.out.println("Order：" + order);
    }

}
