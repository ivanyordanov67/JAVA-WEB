package web;

import domain.models.services.JobServiceModel;
import domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class JobListBean {

    private List<HomeViewModel> models;

    private JobService jobService;
    private ModelMapper modelMapper;

    public JobListBean() {
    }

    @Inject
    public JobListBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){

       List<JobServiceModel> models2 = this.jobService.getAll();
        this.models=models2
        .stream()
        .map(m->this.modelMapper.map(m, HomeViewModel.class))
        .collect(Collectors.toList());

    }


    public List<HomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<HomeViewModel> models) {
        this.models = models;
    }
}
