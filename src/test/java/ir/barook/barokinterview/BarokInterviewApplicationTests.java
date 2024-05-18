package ir.barook.barokinterview;

import ir.barook.barokinterview.controller.WalletController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BarokInterviewApplicationTests {

    @Autowired
    private WalletController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }




}
