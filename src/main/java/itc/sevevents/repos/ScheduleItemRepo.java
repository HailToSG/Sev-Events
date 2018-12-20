package itc.sevevents.repos;

import itc.sevevents.domain.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleItemRepo extends JpaRepository<ScheduleItem, Long> {
}
