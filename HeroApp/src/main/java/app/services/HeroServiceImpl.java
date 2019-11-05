package app.services;

import app.domain.entities.Hero;
import app.domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import app.repository.HeroRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    @Inject
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addHero(HeroServiceModel hero) {

        this.heroRepository.saveHero(this.modelMapper.map(hero, Hero.class));

    }

    @Override
    public void delete(String id) {
        this.heroRepository.delete(id);
    }

    @Override
    public List<HeroServiceModel> getAll() {
        List<HeroServiceModel> jobs = this.heroRepository.findAll()
                .stream()
                .map(j->this.modelMapper.map(j, HeroServiceModel.class))
                .collect(Collectors.toList());
        return jobs;
    }

    @Override
    public HeroServiceModel getById(String id) {
        return this.modelMapper
                .map(this.heroRepository.findById(id), HeroServiceModel.class);
    }
}
