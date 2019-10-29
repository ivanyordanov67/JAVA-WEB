package service;

import domain.entities.Job;
import domain.models.services.JobServiceModel;
import org.modelmapper.ModelMapper;
import repository.JobRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveJob(JobServiceModel job) {
        this.jobRepository.saveJob(this.modelMapper.map(job, Job.class));
    }

    @Override
    public List<JobServiceModel> getAll() {
       return this.jobRepository.findAll()
               .stream()
               .map(j->this.modelMapper.map(j, JobServiceModel.class))
               .collect(Collectors.toList());
    }

    @Override
    public JobServiceModel getById(String id) {
        return this.modelMapper
                .map(this.jobRepository.findById(id), JobServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.jobRepository.delete(id);
    }
}
