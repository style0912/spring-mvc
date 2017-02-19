package x3.benjamin.playground.apiserver.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by benjamin on 2017. 2. 19..
 */
@Data
public class CreateUserRequest {
    @NotNull
    private String name;
}
