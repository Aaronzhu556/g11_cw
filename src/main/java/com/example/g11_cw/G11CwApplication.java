package com.example.g11_cw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.g11_cw.mapper")
//@SpringBootApplication(scanBasePackages = "com.example")
@SpringBootApplication
public class G11CwApplication {

    public static void main(String[] args) {
        SpringApplication.run(G11CwApplication.class, args);
    }

}
