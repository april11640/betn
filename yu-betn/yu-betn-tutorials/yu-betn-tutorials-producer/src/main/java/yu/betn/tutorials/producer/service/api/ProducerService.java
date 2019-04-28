package yu.betn.tutorials.producer.service.api;

import yu.betn.tutorials.producer.domain.Order;

/**
 * Created by zsp on 2019/4/12.
 */
public interface ProducerService {

    void selectX();

    int saveOrder(Order order);

    void updateOrder(Order order);

    Order getOrder(String goods);

}
