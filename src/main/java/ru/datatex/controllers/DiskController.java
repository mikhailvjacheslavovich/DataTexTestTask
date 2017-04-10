package ru.datatex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.datatex.model.DiskEntity;
import ru.datatex.service.DiskService;


import java.util.List;

@RestController
public class DiskController {

    @Autowired
    DiskService diskService;

    @RequestMapping(value = "/getFreeDisks", method = RequestMethod.GET)
    public List<DiskEntity> getAllDisks() {
        return diskService.getFreeDisks();
    }

    @RequestMapping(value = "/getTakenDisks", method = RequestMethod.GET)
    public List<DiskEntity> getTakenDisk(@RequestParam(value = "id") Long id){
        return diskService.getTakenDisks(id);
    }

    @RequestMapping(value = "/getGivenDisks", method = RequestMethod.GET)
    public List<DiskEntity> getGivenDisks(@RequestParam(value = "user_id") Long userId){
        return diskService.getGivenDisks(userId);
    }

    @RequestMapping(value = "/addDisk", method = RequestMethod.POST)
    public void addDisk(@RequestParam(value = "title") String title,
                        @RequestParam(value = "rating") String rating,
                        @RequestParam(value = "description") String description,
                        @RequestParam(value = "owner_id") Long ownerId) {

        diskService.addDisk(title, rating, description, ownerId);
    }


    @RequestMapping(value = "/rentDisk", method = RequestMethod.POST)
    public void rentDisk(@RequestParam(value = "disk_id") Long diskId,
                         @RequestParam(value = "user_id") Long userId){
        diskService.rentDisk(diskId,userId);
    }
    @RequestMapping(value = "/returnDisk", method = RequestMethod.POST)
    public void returnDisk(@RequestParam(value = "disk_id") Long diskId){
        diskService.returnDisk(diskId);
    }
}
