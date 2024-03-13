package api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetails {
    private String email;
    private String password;

    public static UserDetails from(api.User user) {
        return new UserDetails(user.getEmail(), user.getPassword());
    }
}
