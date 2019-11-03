package web;

import domain.entities.Sector;
import domain.models.binding.JobCreateBindingModel;
import domain.models.services.JobServiceModel;
import jdk.swing.interop.SwingInterOpUtils;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddJobBean extends BaseBean {

    private JobCreateBindingModel model;

    private JobService jobService;
    private ModelMapper modelMapper;

    public AddJobBean() {
    }

    @Inject
    public AddJobBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.model=new JobCreateBindingModel();
    }

    public void addJob(){
        JobServiceModel serviceModel = this.modelMapper.map(model, JobServiceModel.class);

        serviceModel.setSector(Sector.valueOf(model.getSector().toLowerCase()));
        System.out.println();
        this.jobService.addJob(serviceModel);

   this.redirect("/home");
    }

    public JobCreateBindingModel getModel() {
        return model;
    }

    public void setModel(JobCreateBindingModel model) {
        this.model = model;
    }
}
