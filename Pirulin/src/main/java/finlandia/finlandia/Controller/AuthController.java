package finlandia.finlandia.Controller;

import finlandia.finlandia.DAO.RolDao.RolDao;
import finlandia.finlandia.DAO.User.UserInterface;
import finlandia.finlandia.DTO.RolDTO;
import finlandia.finlandia.DTO.UserDTO;
import finlandia.finlandia.Models.RolEntity;
import finlandia.finlandia.Models.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserInterface userInterface;

    @Autowired
    RolDao rolDao;

    @PostMapping("createuser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
        RolEntity roleEntity = userDTO.getRoles();

        UserEntity userEntity = UserEntity.builder()
                .userName(userDTO.getUserName())
                .userLastName(userDTO.getUserLastName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .rol(roleEntity)
                .build();

        userInterface.register(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("createRol")
    public ResponseEntity<?> createRol(@Valid @RequestBody RolDTO rolDTO){
        RolEntity rol = RolEntity.builder()
                .RolName(rolDTO.getRolname())
                .build();
        rolDao.save(rol);
        return ResponseEntity.ok(rol);
    }
}
