package com.stosik.electric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class ElectricServiceApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(ElectricServiceApplication.class)
            .profiles("dev")
            .bannerMode(Banner.Mode.OFF)
            .headless(true)
            .application()
            .run(args);
    
        log.info("\nhttp://localhost:8080/\n");
    }
}
