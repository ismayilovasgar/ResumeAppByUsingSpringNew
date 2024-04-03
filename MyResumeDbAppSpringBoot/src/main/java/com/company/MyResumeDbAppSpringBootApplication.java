package com.company;

import com.company.dao.inter.*;
import com.company.entity.TableGroup;
import com.company.entity.TableGroupRole;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyResumeDbAppSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyResumeDbAppSpringBootApplication.class, args);
    }

    @Autowired
    private UserServiceInter userService;

    @Autowired
    private TableGroupUserRepository tableGroupUserDao;

    @Autowired
    private TableGroupRoleRepository tableGroupRoleDao;

    @Autowired
    private TableRoleRepository tableRoleDao;

    @Autowired
    private TableGroupRepository tableGroupDao;

    @Autowired
    private UserRepository userDao;


//
//    @Autowired
//    private CountryRepository countryDao;
//
//    @Autowired
//    private EmploymentHistoryRepository empDao;
//
//    @Autowired
//    private SkillRepository skillDao;
//
//    @Autowired
//    private UserSkillRepository userSkillDao;
//
//    @Autowired
//    private TableGroupRoleRepository groupRoleDao;
//
//    @Autowired
//    private TableGroupUserRepository groupUserDao;

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                List<User> list = userDao.getAll(null, null, null);
//                for (User u : list) {
//                    System.out.println(u.getEmail());
//                }
                User u = userDao.myFindByEmail2("azayjalilov@gmail.com");
                System.out.println("u:"+u);
//                boolean b = userService.removeUser(8);
//                System.out.println("b:" + b);


                //* Spring Data
//                List<User> userList = userRepo.findByName("test1");
//                System.out.println("findByName / userList:" + userList);

//                User user = userRepo.findByNameAndSurname("testa", "test2");
//                System.out.println("findByNameAndSurname / user:" + user);

//                List<User>userList1 = userRepo.findByEmailNative("test@gmail.com");
//                System.out.println("findByEmailNative / userList1:"+userList1);

//                User user2 = userRepo.findByEmailJPQL("eldarnovruzov@gmail.com");
//                System.out.println("findByEmailJPQL / user2:" + user2);
//
//                User user3 =userRepo.findByEmailAndSurnameJPQL("sarkhanrasullu@gmail.com","RASULLU");
//                System.out.println("findByEmailAndSurnameJPQL / user3:"+user3);

                //* NamedQuery
//                User uu = userRepo.myFindByEmail("javidkhalilov@gmail.com");
//                System.out.println("NamedQuery / myFindByEmail" + uu);

                //* Table Group Role User All Test
//                List<TableGroupUser> list = tableGroupUserDao.getAllGroupByUserId(4);
//                System.out.println("list:" + list.get(0).getUser().getName());

//                List<TableGroupRole> list = tableGroupRoleDao.getAllRoleByUserId(2);
//                System.out.println("list:"+list.get(0).getRole().getName());

            }
        };
        return clr;
    }
}
