package repository;

import domain.entities.Job;

import javax.persistence.EntityManager;
import java.util.List;

public interface JobRepository {

   void addJob(Job job);
   List<Job> findAll();
   Job findById(String id);
   void delete(String jobId);
}
