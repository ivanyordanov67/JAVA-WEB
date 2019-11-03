package web;

import domain.models.binding.RegisterBindingModel;
import domain.models.services.UserServiceModel;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean{

    private RegisterBindingModel model;
    private UserService userService;
    private ModelMapper modelMapper;


    public RegisterBean() {
    }

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
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

        this.userService.register(this.modelMapper.map(model, UserServiceModel.class));

        this.redirect("/login");

    }

    public RegisterBindingModel getModel() {
        return model;
    }

    public void setModel(RegisterBindingModel model) {
        this.model = model;
    }
}
