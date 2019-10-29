package web.beans;

import domain.models.view.JobViewModel;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DetailsBean {

    private ModelMapper modelMapper;
    private JobService jobService;


    @Inject
    public DetailsBean(ModelMapper modelMapper, JobService jobService) {
        this.modelMapper = modelMapper;
        this.jobService = jobService;
    }

    public DetailsBean() {
    }

    public JobViewModel getJobById(String id){

        return this.modelMapper.map(this.jobService.getById(id), JobViewModel.class);

    }

}