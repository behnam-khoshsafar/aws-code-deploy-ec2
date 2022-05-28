package b.kh.awscodedeployec.resource;

import b.kh.awscodedeployec.resource.dto.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserResource {

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = Arrays.asList(new User(1, "Behanm", 30),
                                         new User(2, "Brian", 30),
                                         new User(3, "Josh", 40));
        return ResponseEntity.ok(users);
    }

}
