package itc.sevevents.repos;

import itc.sevevents.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
}
