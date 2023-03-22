package com.example.spring.ioc.anno;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
