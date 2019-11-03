package web.beans;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class BaseBean {

    public void redirect(String url)  {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/views" + url + ".jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
