package ru.datatex.database;

import ru.datatex.model.DiskEntity;

import java.util.List;


public interface DiskDataProvider {
    public List<DiskEntity> getFreeDisks();
    public void addDisk(String title, String rating, String description,Long ownerId);
    public void rentDisk(Long diskId, Long userId);
    public void returnDisk(Long diskId);
    public List<DiskEntity> getTakenDisk(Long id);
    public List<DiskEntity> getGivenDisks(Long id);
}
