package ru.datatex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.DiskDataProvider;
import ru.datatex.model.DiskEntity;
import ru.datatex.service.DiskService;

import java.util.List;

@Service
public class DiskServiceImpl implements DiskService {

    @Autowired
    DiskDataProvider diskDataProvider;

    public List<DiskEntity> getFreeDisks() {
        return diskDataProvider.getFreeDisks();
    }

    public void addDisk(String title, String rating, String description, Long ownerId) {
        diskDataProvider.addDisk(title, rating, description, ownerId);
    }

    public List<DiskEntity> getTakenDisks(Long id) {
        return diskDataProvider.getTakenDisk(id);
    }

    public void rentDisk(Long diskId, Long userId) {
        diskDataProvider.rentDisk(diskId, userId);
    }

    public void returnDisk(Long diskId) {
        diskDataProvider.returnDisk(diskId);
    }

    public List<DiskEntity> getGivenDisks(Long userId) {
        return diskDataProvider.getGivenDisks(userId);
    }

}
