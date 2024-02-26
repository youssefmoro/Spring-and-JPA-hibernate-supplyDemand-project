package dataTransferCommProject.example.RestApis.repo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepo {
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException ;

}
