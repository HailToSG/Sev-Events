package itc.sevevents.service;

import itc.sevevents.domain.ScheduleItem;
import itc.sevevents.repos.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepo scheduleRepo;

    @Autowired
    public ScheduleService(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    public List<ScheduleItem> getAllScheduleItemsByEvent() {
        return scheduleRepo.findAll();
    }

    public void removeScheduleItem(ScheduleItem item){
        scheduleRepo.delete(item);
    }

    public ScheduleItem saveScheduleItem(ScheduleItem item) {
        return scheduleRepo.save(item);
    }

    public ScheduleItem getScheduleItem(ScheduleItem item) {
        return scheduleRepo.getOne(item.getId());
    }
}

