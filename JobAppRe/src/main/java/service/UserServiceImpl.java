package service;

import domain.entities.User;
import domain.models.services.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import repository.UserRepository;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel user) {
        this.userRepository.register(this.modelMapper.map(user, User.class));

    }

    @Override
    public String hashPassword(String password) {
       return DigestUtils.sha256Hex(password);
    }

    @Override
    public UserServiceModel getByUsernameAndId(String username, String password) {
        return this.modelMapper.map(this.userRepository
                        .findByUsernameAndPassword(username, password), UserServiceModel.class);
    }


}
