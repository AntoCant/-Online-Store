package OSapiuser.repository;

import OSapiuser.model.SystemUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserModel, Integer> {

   @Query("select u from SystemUserModel u where lower(u.username) = lower(:username)")
   SystemUserModel findByUsername(@Param("username") String username);
}
