package web;

import domain.entities.Clazz;
import domain.models.binding.CreateHeroBindingModel;
import domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import services.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddHeroBean extends BaseBean {

    private CreateHeroBindingModel model;
    private ModelMapper modelMapper;
    private HeroService heroService;

    public AddHeroBean() {
    }

    @Inject
    public AddHeroBean(ModelMapper modelMapper, HeroService heroService) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @PostConstruct
    public void init(){
        this.model=new CreateHeroBindingModel();
    }

    public void addHero(){
        System.out.println();
        HeroServiceModel serviceModel = this.modelMapper.map(model, HeroServiceModel.class);

        serviceModel.setClazz(Clazz.valueOf(model.getClazz().toLowerCase()));
        System.out.println();
        this.heroService.addHero(serviceModel);

        this.redirect("/home");
    }

    public CreateHeroBindingModel getModel() {
        return model;
    }

    public void setModel(CreateHeroBindingModel model) {
        this.model = model;
    }
}
