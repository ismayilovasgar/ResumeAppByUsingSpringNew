package com.company;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching      //* to enable spring cache
public class ResumeDbAppJpaSpringApplication {
//    DI - Dependecy Injection
//    IoC - Inversion of Control, RMI

    @Autowired
//    @Qualifier("userDao1")
    private UserRepository userDao;


    @Autowired
    private UserServiceInter userService;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

    //
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                List<User> list = userDao.getAll(null, null, null);
//                for (User u : list) {
//                    System.out.println(u.getName());
//                }
                //                List<User> list = userRepository.findAll();
//                System.out.println(list);
//                System.out.println("--------------------");
//                list = userRepository.findAll(Sort.by(Sort.Order.desc("id")));
//                System.out.println(list);

                //  User u = userRepository.findById(5).get();
                // System.out.println(u);

//                User u = userDao.findByName("testa");
//                System.out.println(u);

//                User u2 = userRepository.findByNameAndSurname("test", "test");
//                System.out.println(u2);

//                User u = userRepository.findByEmailJPQL("sarkhanrasullu@gmail.com");
//                System.out.println(u);

//                User u = userRepository.findByEmailAndSurnameJPQL("test@gmail.com", "test");
//                System.out.println(u);

//                List<User> list = userRepository.getAll(null, null, null);
//                System.out.println(list);
            }
        };
        return clr;
    }

}
