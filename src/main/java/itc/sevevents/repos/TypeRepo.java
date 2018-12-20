package itc.sevevents.repos;

import itc.sevevents.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo  extends JpaRepository<Type, Long> {

}