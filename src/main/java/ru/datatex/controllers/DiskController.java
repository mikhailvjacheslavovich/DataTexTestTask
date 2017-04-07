package ru.datatex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.datatex.model.Disk;
import ru.datatex.model.Users;
import ru.datatex.service.DiskService;

import java.util.List;

@RestController
public class DiskController {

    @Autowired
    DiskService diskService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<Users> getAllUsers() {
        return diskService.getUsers();
    }


    @RequestMapping(value = "/getFreeDisks", method = RequestMethod.GET)
    public List<Disk> getAllDisks() {
        return diskService.getFreeDisks(new Long(4));
    }
    @RequestMapping(value = "/getTakenDisks", method = RequestMethod.GET)
    public List<Disk> getTakenDisk(@RequestParam(value = "id") Long id){
        return diskService.getTakenDisks(id);
    }
    @RequestMapping(value = "/getGivenDisks", method = RequestMethod.GET)
    public List<Disk> getGivenDisks(@RequestParam(value = "user_id") Long userId){
        return diskService.getGivenDisks(userId);
    }

    @RequestMapping(value = "/addDisk", method = RequestMethod.POST)
    public void addDisk(@RequestParam(value = "title") String title,
                        @RequestParam(value = "rating") String rating,
                        @RequestParam(value = "description") String description) {

        diskService.addDisk(title, rating, description);
    }


    @RequestMapping(value = "/rentDisk", method = RequestMethod.POST)
    public void rentDisk(@RequestParam(value = "disk_id") Long diskId,
                         @RequestParam(value = "user_id") Long userId){
        diskService.rentDisk(diskId,userId);
    }
    @RequestMapping(value = "/returnDisk", method = RequestMethod.POST)
    public void returnDisk(@RequestParam(value = "disk_id") Long diskId,
                           @RequestParam(value = "user_id") Long userId){
        diskService.returnDisk(diskId,userId);
    }


}
