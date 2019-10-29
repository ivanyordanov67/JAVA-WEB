package service;

import domain.models.services.JobServiceModel;

import java.util.List;

public interface JobService {

     void saveJob(JobServiceModel job);

     List<JobServiceModel> getAll();

    JobServiceModel getById(String id);

    void delete(String id);

}
