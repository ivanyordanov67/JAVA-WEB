package services;

import domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    void addHero(HeroServiceModel hero);
    void delete(String id);
    List<HeroServiceModel> getAll();
    HeroServiceModel getById(String id);
}
