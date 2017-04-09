package ru.datatex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.DiskDataProvider;
import ru.datatex.model.Disk;
import ru.datatex.model.Users;

import java.util.List;

@Service
public class DiskService {

    @Autowired
    DiskDataProvider diskDataProvider;

    public List<Users> getUsers() {
        return diskDataProvider.getAllUsers();
    }

    public List<Disk> getFreeDisks(Long id) {
        return diskDataProvider.getFreeDisks(id);
    }

    public void addDisk(String title, String rating, String description, Long ownerId) {
        diskDataProvider.addDisk(title, rating, description, ownerId);
    }

    public List<Disk> getTakenDisks(Long id) {
        return diskDataProvider.getTakenDisk(id);
    }

    public void rentDisk(Long diskId, Long userId) {
        diskDataProvider.rentDisk(diskId, userId);
    }

    public void returnDisk(Long diskId, Long userId) {
        diskDataProvider.returnDisk(diskId, userId);
    }

    public List<Disk> getGivenDisks(Long userId) {
        return diskDataProvider.getGivenDisks(userId);
    }

}
