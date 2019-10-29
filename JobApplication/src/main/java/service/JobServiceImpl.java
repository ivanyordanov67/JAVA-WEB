package service;

import domain.entities.Job;
import domain.models.services.JobServiceModel;
import org.modelmapper.ModelMapper;
import repository.JobRepository;

import javax.inject.Inject;

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
}
