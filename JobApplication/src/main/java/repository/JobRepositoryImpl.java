package repository;

import domain.entities.Job;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobRepositoryImpl implements JobRepository {

    private final EntityManager entityManager;

    @Inject
    public JobRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveJob(Job job) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(job);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List <Job> findAll() {
        this.entityManager.getTransaction().begin();
        List<Job> jobs=this.entityManager
                .createQuery("select j from Job j", Job.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return jobs;
    }

    @Override
    public Job findById(String id) {
        this.entityManager.getTransaction().begin();
        Job job = this.entityManager
                .createQuery("select j from Job j where j.id= :id", Job.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return job;
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager
                .createQuery("delete from Job j where j.id= :id").setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
