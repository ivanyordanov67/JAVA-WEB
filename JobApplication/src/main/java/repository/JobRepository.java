package repository;

import domain.entities.Job;

import java.util.List;

public interface JobRepository {

     void saveJob(Job job);

     List<Job> findAll();

     Job findById(String id);

     void delete(String id);

}
