package dataTransferCommProject.example.RestApis.Repo;

import dataTransferCommProject.example.RestApis.Models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface AccountRepo extends JpaRepository<AccountModel,Long> {
    //Optional<AccountModel> findByEmailAndPassword(String email, String password);
}
