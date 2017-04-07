package ru.datatex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.DataDao;
import ru.datatex.model.Disk;
import ru.datatex.model.Users;

import java.util.List;

@Service
public class DiskService {

    @Autowired
    DataDao dataDao;

    public List<Users> getUsers(){
        return dataDao.getAllUsers();
    }

    public List<Disk> getFreeDisks(Long id){
        return dataDao.getFreeDisks(id);
    }

    public void addDisk(String title, String rating, String description){
            dataDao.addDisk(title,rating,description );
    }

    public List<Disk> getTakenDisks(Long id){
        return dataDao.getTakenDisk(id);
    }

    public void rentDisk(Long diskId, Long userId){
        dataDao.rentDisk(diskId,userId);
    }

    public void returnDisk(Long diskId, Long userId){
        dataDao.returnDisk(diskId,userId);
    }

    public List<Disk> getGivenDisks(Long userId){
        return dataDao.getGivenDisks(userId);
    }

}
