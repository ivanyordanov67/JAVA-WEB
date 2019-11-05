package repository;

import domain.entities.Hero;

import java.util.List;

public interface HeroRepository {

    void saveHero(Hero hero);
    void delete(String heroId);
    List<Hero> findAll();
    Hero findById(String id);
}
