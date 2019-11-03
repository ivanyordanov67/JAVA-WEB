package web;

import domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobDetailsBean {

    private HomeViewModel model;
    private JobService jobService;
    private ModelMapper modelMapper;

    public JobDetailsBean() {
    }

    @Inject
    public JobDetailsBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    public HomeViewModel getById(String id){
        return this.modelMapper.map(this.jobService.getById(id), HomeViewModel.class);
    }

    public HomeViewModel getModel() {
        return model;
    }

    public void setModel(HomeViewModel model) {
        this.model = model;
    }
}
