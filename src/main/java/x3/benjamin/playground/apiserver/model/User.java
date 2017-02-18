package x3.benjamin.playground.apiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
public class User {
    private Long userId;
    private String name;
    private String address;
}
