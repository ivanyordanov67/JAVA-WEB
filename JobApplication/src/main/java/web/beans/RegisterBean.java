package web.beans;


import domain.models.binding.UserRegisterBinding;
import domain.models.services.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private UserRegisterBinding user;
    private UserService userService;
    private ModelMapper modelMapper;



    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    public RegisterBean() {
    }

    @PostConstruct
    public void init(){
        this.user = new UserRegisterBinding();
    }


    public void register(){
        if (!this.user.getPassword().equals(this.user.getConfirmPassword())){
            return;
        }
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        this.userService.save(this.modelMapper.map(user, UserServiceModel.class));

        this.redirect("/login");
    }

    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }
}
