package yu.betn.tutorials.producer.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yu.betn.tutorials.producer.domain.Order;
import yu.betn.tutorials.producer.service.api.ProducerService;

/**
 * Created by zsp on 2019/4/11.
 */
@RestController
public class ProducerFacedeImpl {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/select-x")
    public void selectX() {
        producerService.selectX();
    }

    @PostMapping("/save-order")
    public void saveOrder(@RequestBody Order order) {
        producerService.saveOrder(order);
    }

}
