package yu.betn.tutorials.producer.dao.api;

import yu.betn.tutorials.producer.domain.Order;

/**
 * Created by zsp on 2019/4/12.
 */
public interface ProducerDao {

    String selectX();

    int saveOrder(Order order);

}
