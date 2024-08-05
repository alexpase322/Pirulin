package finlandia.finlandia.DAO.RolDao;

import finlandia.finlandia.Models.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface RolDao extends JpaRepository<RolEntity, UUID> {
}
