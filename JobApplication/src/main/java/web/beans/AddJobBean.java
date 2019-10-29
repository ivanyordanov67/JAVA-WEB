package web.beans;

import domain.entities.Sector;
import domain.models.binding.JobAddBindingModel;
import domain.models.services.JobServiceModel;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddJobBean extends BaseBean {

    private JobAddBindingModel job;
    private  JobService jobService;
    private  ModelMapper modelMapper;

    public AddJobBean() {
    }

    @Inject
    public AddJobBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;

    }

    @PostConstruct
    public void init(){
        this.job = new JobAddBindingModel();
    }

    public void createJob(){
       JobServiceModel job = this.modelMapper.map(this.job, JobServiceModel.class);
        Sector sector = null;

        try {
            sector = Sector.valueOf(this.job.getSector().toUpperCase());
        }catch (Exception e){
            this.redirect("/add-job");
        }

        job.setSector(sector);

        this.jobService.saveJob(job);
        this.redirect("/home");
    }

    public JobAddBindingModel getJob() {
        return job;
    }

    public void setJob(JobAddBindingModel job) {
        this.job = job;
    }
}
