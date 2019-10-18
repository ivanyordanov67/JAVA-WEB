package models.services.base;


import models.entity.User;
import models.service.UserServiceModel;
import models.services.HashingService;
import models.services.UserService;
import models.services.UserValidationService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


public class UserServiceImpl implements UserService {


    private final HashingService hashingService;
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;
    private final UserValidationService userValidationService;



    @Inject
    public UserServiceImpl(HashingService hashingService,
                           EntityManager entityManager,
                           ModelMapper modelMapper,
                           UserValidationService userValidationService) {
        this.hashingService = hashingService;
        this.entityManager = entityManager;
      this.modelMapper = modelMapper;
        this.userValidationService = userValidationService;
    }


    @Override
    public void register(String username, String email, String password, String confirmPassword) throws Exception {
        if (!userValidationService.canCreateUser(username, email, password, confirmPassword)){
            throw new Exception("User can not be create.");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashingService.hash(password));

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public UserServiceModel login(String username, String password) {
        List<User> users = entityManager.createQuery("select u from User u " +
                "where u.username= :username", User.class)
                .setParameter("username", username)
                .getResultList();
        if (users.isEmpty()){
            return null;
        }
        User user = users.get(0);
        if (!user.getPassword().equals(hashingService.hash(password))){
            return null;
        }
        return modelMapper.map(user, UserServiceModel.class);
    }
}
