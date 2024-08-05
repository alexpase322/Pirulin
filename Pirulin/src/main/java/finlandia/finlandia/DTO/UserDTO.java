package finlandia.finlandia.DTO;

import finlandia.finlandia.Models.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String userLastName;
    private String email;
    private String password;
    private RolEntity roles;
}
