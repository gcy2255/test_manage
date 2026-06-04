package org.example.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example.backend", "Mapper", "Service", "Controller", "entity"})
@MapperScan("Mapper")//Mapper属于外来包，需要扫描到
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        System.out.println("启动成功");
        System.out.println("--------------------------------");
        System.out.println("访问 http://localhost:8080");



    }

}
