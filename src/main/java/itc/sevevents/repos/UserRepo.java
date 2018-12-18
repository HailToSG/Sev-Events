package itc.sevevents.repos;

import itc.sevevents.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepo extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
