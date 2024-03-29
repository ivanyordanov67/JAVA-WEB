package app.web;

import app.domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import app.services.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DetailsHeroBean extends BaseBean {

    private HomeViewModel model;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public DetailsHeroBean() {
    }

    @Inject
    public DetailsHeroBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }



    public HomeViewModel getById(String id){
        return this.modelMapper.map(this.heroService.getById(id), HomeViewModel.class);
    }


}
