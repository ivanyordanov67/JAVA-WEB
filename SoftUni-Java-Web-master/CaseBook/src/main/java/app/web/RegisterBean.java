package app.web;


import app.domain.models.binding.UserRegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private UserRegisterBindingModel user;
    private UserService userService;
    private ModelMapper modelMapper;


    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.user = new UserRegisterBindingModel();
    }

    public RegisterBean() {
    }


    public void create() {
        if (!user.getPassword().equals(user.getConfirmPassword())) {

            this.redirect("/register");
        }

        String hashPassword = this.userService.hashPassword(this.user.getPassword());

       user.setPassword(hashPassword);
        this.userService.save(this.modelMapper.map(user, UserServiceModel.class));
        this.redirect("/login");
    }

    public UserRegisterBindingModel getUser() {
        return user;
    }

    public void setUser(UserRegisterBindingModel user) {
        this.user = user;
    }
}
