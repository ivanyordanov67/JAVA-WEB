package repository;

import domain.entities.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private final EntityManager entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveHero(Hero hero) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(hero);
        this.entityManager.getTransaction().commit();

    }

    @Override
    public void delete(String heroId) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("delete from Hero j where j.id= :id")
                .setParameter("id", heroId)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<Hero> findAll() {
        this.entityManager.getTransaction().begin();
        List<Hero> jobs = this.entityManager.createQuery("select j from Hero j", Hero.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return jobs;
    }

    @Override
    public Hero findById(String id) {
        Hero hero = null;
        this.entityManager.getTransaction().begin();
        hero = this.entityManager.createQuery("select h from Hero h " +
                "where h.id= :id", Hero.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return hero;
    }
}
