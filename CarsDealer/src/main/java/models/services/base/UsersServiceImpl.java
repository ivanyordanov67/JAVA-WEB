package models.services.base;



import models.services.UsersService;




public class UsersServiceImpl implements UsersService {

//    private final EntityManager entityManager;
//    //private final ModelMapper modelMapper;
//
//    @Inject
//    public UsersServiceImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//
//        //this.modelMapper = modelMapper;
//    }

//    @Override
//    public void register(String username, String email, String password, String confirmPassword) {
//
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(password);
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//
//    }

    //@Override
//    public UserServiceModel login(String username, String password) {
//        //check for user with username
//        User user =  entityManager.createQuery("select u from User u where u.username= :username", User.class)
//                .setParameter("username", username)
//        .getSingleResult();
//
//        if(user==null){
//            return null;
//        }
//        if(!user.getPassword().equals(hashingService.hash(password))){
//            return null;
//        }
//
//        return modelMapper.map(user, UserServiceModel.class);
//    }
}
