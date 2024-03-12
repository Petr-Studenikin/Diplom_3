package api;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String email;
    private String password;
    private String name;
}
