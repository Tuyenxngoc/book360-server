package com.tuyenngoc.bookstore;

import com.tuyenngoc.bookstore.config.CloudinaryConfig;
import com.tuyenngoc.bookstore.config.MailConfig;
import com.tuyenngoc.bookstore.config.properties.AdminInfo;
import com.tuyenngoc.bookstore.constant.RoleConstant;
import com.tuyenngoc.bookstore.domain.entity.Role;
import com.tuyenngoc.bookstore.repository.CustomerRepository;
import com.tuyenngoc.bookstore.repository.RoleRepository;
import com.tuyenngoc.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
@EnableConfigurationProperties({
        AdminInfo.class,
        MailConfig.class,
        CloudinaryConfig.class
})
@EnableScheduling
public class BookStoreApplication {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        Environment env = SpringApplication.run(BookStoreApplication.class, args).getEnvironment();
        String appName = env.getProperty("spring.application.name");
        if (appName != null) {
            appName = appName.toUpperCase();
        }
        String port = env.getProperty("server.port");
        log.info("-------------------------START " + appName
                + " Application------------------------------");
        log.info("   Application         : " + appName);
        log.info("   Url swagger-ui      : http://localhost:" + port + "/swagger-ui.html");
        log.info("-------------------------START SUCCESS " + appName
                + " Application----------------------");
    }

    @Bean
    CommandLineRunner init(AdminInfo adminInfo) {
        return args -> {
            //init role
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(1, RoleConstant.ADMINISTRATOR, Collections.emptyList()));
                roleRepository.save(new Role(2, RoleConstant.CUSTOMER, Collections.emptyList()));
                roleRepository.save(new Role(3, RoleConstant.SALES_STAFF, Collections.emptyList()));
            }
            //init admin
            if (userRepository.count() == 0) {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
