package itc.sevevents.repos;

import itc.sevevents.domain.Favor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorRepo extends JpaRepository<Favor,Long> {
}
