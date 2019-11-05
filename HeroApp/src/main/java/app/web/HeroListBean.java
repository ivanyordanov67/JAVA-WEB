package app.web;

import app.domain.models.service.HeroServiceModel;
import app.domain.models.view.HomeViewModel;
import org.modelmapper.ModelMapper;
import app.services.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HeroListBean extends BaseBean {

    private List<HomeViewModel> models;


    private ModelMapper modelMapper;
    private HeroService heroService;

    public HeroListBean() {
    }

    @Inject
    public HeroListBean(ModelMapper modelMapper, HeroService heroService) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @PostConstruct
    public void init(){

        List<HeroServiceModel> models2 = this.heroService.getAll();
        this.models=models2
                .stream()
                .map(m->this.modelMapper.map(m, HomeViewModel.class))
                .collect(Collectors.toList());

    }

    public List<HomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<HomeViewModel> models) {
        this.models = models;
    }
}
