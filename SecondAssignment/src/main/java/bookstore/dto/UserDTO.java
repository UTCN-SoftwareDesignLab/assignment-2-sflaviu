package bookstore.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

    @Size(min=6,message="Username is too short!")
    public String username;
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-?]).{8,}$",message="Password must contain at least one uppercase letter, one lowercase letter, one digit and one symbol")
    public String password;

    public String getUsername() {
        return username;
    }
}
