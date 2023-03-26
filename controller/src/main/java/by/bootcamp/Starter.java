package by.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "by.bootcamp")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class Starter {
    public static void main(String[] args) {

        SpringApplication.run(Starter.class, args);
    }
}
