package itc.sevevents.repos;

import itc.sevevents.domain.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<ScheduleItem, Long> {
}
