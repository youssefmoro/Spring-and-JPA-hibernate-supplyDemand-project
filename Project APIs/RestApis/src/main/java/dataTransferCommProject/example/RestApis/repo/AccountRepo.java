package dataTransferCommProject.example.RestApis.repo;

import dataTransferCommProject.example.RestApis.models.AccountModel;
import dataTransferCommProject.example.RestApis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepo extends JpaRepository<AccountModel,Long> {

    @Query("SELECT a FROM AccountModel a WHERE a.fullName = :fullName")
    User findByUsername(@Param("fullName") String fullName);
//    User findByUsername(String fullName);

}
