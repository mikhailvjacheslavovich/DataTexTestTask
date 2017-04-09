package ru.datatex.service;

import ru.datatex.model.DiskEntity;

import java.util.List;

/**
 * Created by MainWork on 09.04.2017.
 */
public interface DiskService {
    public List<DiskEntity> getFreeDisks();
    public void addDisk(String title, String rating, String description, Long ownerId);
    public List<DiskEntity> getTakenDisks(Long id);
    public void rentDisk(Long diskId, Long userId);
    public void returnDisk(Long diskId);
    public List<DiskEntity> getGivenDisks(Long userId);
}
