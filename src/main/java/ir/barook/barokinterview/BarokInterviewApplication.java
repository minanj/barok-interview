package ir.barook.barokinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.  SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BarokInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarokInterviewApplication.class, args);
    }

}
