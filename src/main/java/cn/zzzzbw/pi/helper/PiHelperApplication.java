package cn.zzzzbw.pi.helper;

import cn.zzzzbw.pi.helper.entity.Command;
import cn.zzzzbw.pi.helper.repository.CommandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PiHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiHelperApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CommandRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Command("Hello"));
            repository.save(new Command("Word"));
            repository.save(new Command("sudo kill"));
            repository.save(new Command("ll"));
        };
    }

}
