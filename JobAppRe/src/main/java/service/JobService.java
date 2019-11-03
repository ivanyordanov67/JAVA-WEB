package service;

import domain.models.services.JobServiceModel;

import java.util.List;

public interface JobService {

    void addJob(JobServiceModel job);
    List<JobServiceModel> getAll();
    JobServiceModel getById(String id);
    void delete(String jobServiceModelId);
}
