package x3.benjamin.playground.apiserver.dto;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by benjamin on 2017. 2. 19..
 */
@Component
public class CreateUserRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return CreateUserRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserRequest createUserRequest = (CreateUserRequest) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Username is empty");
        if (createUserRequest.getName().length() < 5) {
            errors.rejectValue("name", "", "Username length is less than 5");
        }
    }
}
