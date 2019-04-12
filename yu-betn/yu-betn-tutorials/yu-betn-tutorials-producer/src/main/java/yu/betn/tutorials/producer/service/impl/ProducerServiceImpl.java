package yu.betn.tutorials.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.betn.produce.aop.SendAfterTransactionCommitted;
import yu.betn.tutorials.producer.dao.api.ProducerDao;
import yu.betn.tutorials.producer.domain.Order;
import yu.betn.tutorials.producer.service.api.ProducerService;

import java.time.LocalDateTime;

/**
 * Created by zsp on 2019/4/12.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerDao producerDao;

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
        order.setCreateTime(LocalDateTime.now());
        return producerDao.saveOrder(order);
    }

}
