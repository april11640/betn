package yu.betn.tutorials.producer.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yu.betn.tutorials.producer.domain.Order;
import yu.betn.tutorials.producer.service.api.ProducerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsp on 2019/4/11.
 */
@RestController
public class ProducerFacedeImpl {

    @Autowired
    private ProducerService producerService;

    @PostMapping("select-x")
    public void selectX() {
        producerService.selectX();
    }

    @PostMapping("save-order")
    public void saveOrder(@RequestBody Order order) {
        producerService.saveOrder(order);
    }

    @PostMapping("multi-update-order")
    public void multiUpdateOrder() {
        List<Order> orderList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            orderList.add(createOrder("苹果", 10));
            orderList.add(createOrder("香蕉", 10));
            orderList.add(createOrder("苹果", 10));
            orderList.add(createOrder("香蕉", 10));
            orderList.add(createOrder("香蕉", 10));
            orderList.add(createOrder("苹果", 10));
        }
        orderList.stream().parallel().forEach(e -> {
            producerService.getOrder(e.getGoods());
            synchronized (this) {
                producerService.updateOrder(e);
            }
            producerService.getOrder(e.getGoods());
        });
    }

    private Order createOrder(String goods, int count) {
        Order order = new Order();
        order.setGoods(goods);
        order.setCount(count);
        return order;
    }

}
