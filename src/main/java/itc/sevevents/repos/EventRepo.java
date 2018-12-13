package itc.sevevents.repos;

import itc.sevevents.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository <Event, Long> {
}

