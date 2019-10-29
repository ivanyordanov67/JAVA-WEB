package web.beans;


import domain.models.view.JobViewModel;
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
public class JobsListBean {

    private List<JobViewModel> jobs;
    private JobService jobService;
    private ModelMapper modelMapper;

    @Inject
    public JobsListBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    public JobsListBean() {
    }

    @PostConstruct
    void init(){

        this.setJobs(this.jobService.getAll().stream()
                .map(j -> this.modelMapper.map(j, JobViewModel.class))
                .collect(Collectors.toList()));

        this.getJobs().forEach(j -> j.setSector(j.getSector().toLowerCase()));
    }

    public List<JobViewModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobViewModel> jobs) {
        this.jobs = jobs;
    }
}
