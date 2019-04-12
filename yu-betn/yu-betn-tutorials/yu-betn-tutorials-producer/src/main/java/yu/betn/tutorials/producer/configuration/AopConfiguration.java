package yu.betn.tutorials.producer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yu.betn.produce.aop.SendAfterTransactionCommittedAspect;
import yu.betn.produce.aop.SendInTransactionAspect;
import yu.betn.produce.service.api.ProduceLogService;

/**
 * Created by zsp on 2019/4/12.
 */
@Configuration
public class AopConfiguration {

    @Bean
    public SendAfterTransactionCommittedAspect sendAfterTransactionCommittedAspect(
            ProduceLogService produceLogService) {
        return new SendAfterTransactionCommittedAspect(produceLogService);
    }

    @Bean
    public SendInTransactionAspect sendInTransactionAspect() {
        return new SendInTransactionAspect();
    }

}
