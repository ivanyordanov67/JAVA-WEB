package web;

import domain.models.services.JobServiceModel;
import service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DeleteBean extends BaseBean{

    private JobService jobService;

    public DeleteBean() {
    }

    @Inject
    public DeleteBean(JobService jobService) {
        this.jobService = jobService;
    }


    public JobServiceModel getById(String id){
       return this.jobService.getById(id);
    }




    public void delete(){

        String id = ((HttpServletRequest)FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest()).getParameter("id");
        this.jobService.delete(id);
        this.redirect("/home");
    }


}
