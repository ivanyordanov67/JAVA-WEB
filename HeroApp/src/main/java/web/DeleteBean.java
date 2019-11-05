package web;

import domain.models.service.HeroServiceModel;
import domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import services.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DeleteBean extends BaseBean {



    private HeroService heroService;

    public DeleteBean() {
    }

    @Inject
    public DeleteBean(HeroService heroService) {

        this.heroService = heroService;
    }

    public HeroServiceModel getById(String id){
        return this.heroService.getById(id);
    }



    public void delete(){
        System.out.println();
        String id = ((HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest()).getParameter("id");
        this.heroService.delete(id);
        this.redirect("/home");
    }


}
