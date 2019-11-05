package web;

import domain.models.binding.RegisterBindingModel;
import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserRegisterBean extends BaseBean {

    private RegisterBindingModel model;
    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.model=new RegisterBindingModel();
    }

    public void register(){


        if (!this.model.getPassword().equals(this.model.getConfirmPassword())){
            this.redirect("/login");
        }

        String hashPassword = this.userService.hashPassword(model.getPassword());
        model.setPassword(hashPassword);

        this.userService.addUser(this.modelMapper.map(model, UserServiceModel.class));

        this.redirect("/login");

    }

    public RegisterBindingModel getModel() {
        return model;
    }

    public void setModel(RegisterBindingModel model) {
        this.model = model;
    }
}
