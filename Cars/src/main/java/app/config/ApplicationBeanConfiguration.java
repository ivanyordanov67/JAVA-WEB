package app.config;

import app.util.FileUtilTest;
import app.util.FileUtilTestImpl;
import org.modelmapper.ModelMapper;
import javax.enterprise.inject.Produces;
public class ApplicationBeanConfiguration {

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Produces
    public FileUtilTest fileUtil(){
        return new FileUtilTestImpl();
    }
}
