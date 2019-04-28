package yu.betn.tutorials.producer.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zsp on 2019/4/11.
 */
@MapperScan(basePackages = {
        "yu.betn.tutorials.producer.dao.api"})
@EnableTransactionManagement(order = 0)
@SpringBootApplication(scanBasePackages = {
        "yu.betn.produce",
        "yu.betn.tutorials.producer"})
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
