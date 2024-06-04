package OSapiuser.repository;

import OSapiuser.model.SystemUserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRolRepository extends JpaRepository<SystemUserRoleModel, Integer> {
}
