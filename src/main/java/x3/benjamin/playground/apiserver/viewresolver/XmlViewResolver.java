package x3.benjamin.playground.apiserver.viewresolver;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;
import x3.benjamin.playground.apiserver.model.User;

import java.util.Locale;

/**
 * Created by benjamin on 2017. 2. 18..
 */
public class XmlViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        MarshallingView view = new MarshallingView();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(User.class);
        view.setMarshaller(jaxb2Marshaller);
        return view;
    }
}
