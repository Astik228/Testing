package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role getFirstByRoleName(String roleName);
}
