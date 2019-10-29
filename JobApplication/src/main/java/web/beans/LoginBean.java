package web.beans;

import domain.models.binding.LoginBinding;
import domain.models.services.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private LoginBinding user;
    private UserService userService;
    private ModelMapper modelMapper;

    public LoginBean() {
    }

    @Inject
    public LoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.user = new LoginBinding();
    }

    public void login() {

        UserServiceModel user =
                this.userService
                        .findByUsernameAndPassword(
                                this.user.getUsername(),
                                DigestUtils.sha256Hex(
                                        this.user.getPassword()));

        if (user==null){
            this.redirect("/login");
        }

        Map<String, Object> sessionMap = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSessionMap();
        sessionMap.put("username", user.getUsername());
        this.redirect("/home");

    }

    public LoginBinding getUser() {
        return user;
    }

    public void setUser(LoginBinding user) {
        this.user = user;
    }
}
