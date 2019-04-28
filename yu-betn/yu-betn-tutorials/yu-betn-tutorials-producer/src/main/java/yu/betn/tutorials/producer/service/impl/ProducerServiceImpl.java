package yu.betn.tutorials.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.betn.produce.aop.SendAfterTransactionCommitted;
import yu.betn.tutorials.producer.dao.api.ProducerDao;
import yu.betn.tutorials.producer.domain.Order;
import yu.betn.tutorials.producer.service.api.ProducerService;
import yu.betn.tutorials.producer.stream.OrderTemplate;
import yu.betn.tutorials.producer.stream.SimpleTemplate;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/12.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerDao producerDao;

    @Autowired
    private SimpleTemplate simpleTemplate;

    @Autowired
    private OrderTemplate orderTemplate;

    @SendAfterTransactionCommitted
    @Transactional
    @Override
    public void selectX() {
        System.out.println("Hello " + producerDao.selectX());
    }

    @SendAfterTransactionCommitted
    @Transactional
    @Override
    public int saveOrder(Order order) {
        simpleTemplate.send("World");
        orderTemplate.send(order);
        order.setCreateTime(LocalDateTime.now());
        return producerDao.saveOrder(order);
    }

    @Transactional
    @Override
    public void updateOrder(Order order) {
        int tryCount = 0;
        for(;;) {
            Order beforeUpdateOrder = producerDao.getOrder(order.getGoods());
            if (beforeUpdateOrder != null) {
                int affectedRows = producerDao.updateOrderCount(beforeUpdateOrder, order.getCount());
                System.out.println("affectedRows: " + affectedRows);
                if(affectedRows > 0) {
                    break;
                }
                tryCount++;
                if (tryCount > 10) {
                    throw new RuntimeException("Try 3 times, but no rows affected");
                }
            }
            break;
        }
    }

    @Override
    public Order getOrder(String goods) {
        return producerDao.getOrder(goods);
    }

}
