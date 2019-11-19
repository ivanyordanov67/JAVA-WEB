package app.web;

import app.domain.models.binding.RegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import app.services.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {

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
        System.out.println();

        if(model.getUsername().equals("")||
                model.getPassword().equals("")||
                model.getConfirmPassword().equals("")||
                model.getEmail().equals("")||
                model.getCountry().equals("")){
            this.redirect("/register");
            return;
        }

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
