package service;

import domain.entities.User;
import domain.models.services.UserServiceModel;
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
    public void save(UserServiceModel user) {
        this.userRepository.save(this.modelMapper.map(user, User.class));
    }
}
