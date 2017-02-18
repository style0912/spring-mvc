package x3.benjamin.playground.apiserver.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import x3.benjamin.playground.apiserver.model.User;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 19..
 */
public class UserClient {

    private static final ParameterizedTypeReference<List<User>> TYPE_REFERENCE;

    static {
        TYPE_REFERENCE = new ParameterizedTypeReference<List<User>>() {
        };
    }

    private static final RestTemplate restTemplate = new RestTemplate();

    public List<User> getUsers() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity httpEntity = new HttpEntity<>(headers);

        String url = "http://localhost:18080/users";

        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, TYPE_REFERENCE);

        return responseEntity.getBody();
    }

    public static void main(String[] args){
        UserClient client = new UserClient();
        List<User> users = client.getUsers();
        users.stream().forEach(System.out::println);
    }
}
