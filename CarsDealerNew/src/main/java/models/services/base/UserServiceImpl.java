package models.services.base;

import models.entity.User;
import models.services.HashingService;
import models.services.UserService;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;
    private final HashingService hashingService;

    @Inject
    public UserServiceImpl(EntityManager entityManager, HashingService hashingService) {
        this.entityManager = entityManager;
        this.hashingService = hashingService;
    }

    @Override
    public void register(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashingService.hash(password));

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();


    }
}
