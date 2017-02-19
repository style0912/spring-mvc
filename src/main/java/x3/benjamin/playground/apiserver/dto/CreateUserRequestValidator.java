package x3.benjamin.playground.apiserver.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import x3.benjamin.playground.apiserver.utils.MessageBundleUtil;

/**
 * Created by benjamin on 2017. 2. 19..
 */
@Component
public class CreateUserRequestValidator implements Validator {

    @Autowired
    private MessageBundleUtil messageBundleUtil;

    @Override
    public boolean supports(Class<?> aClass) {
        return CreateUserRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserRequest createUserRequest = (CreateUserRequest) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", messageBundleUtil.getMessage("user.name.empty"));
        if (createUserRequest.getName().length() < 5) {
            errors.rejectValue("name", "", messageBundleUtil.getMessage("user.name.short"));
        }
    }
}
