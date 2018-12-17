package itc.sevevents.repos;

import itc.sevevents.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository <Event, Long> {
    @Override
    Event getOne(Long aLong);
}

