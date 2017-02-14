package x3.benjamin.playground.apiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Data
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;
    private String address;
}
