package ru.team55.mes_eds_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.team55.mes_eds_admin.entity.Maintenance;
import ru.team55.mes_eds_admin.service.AdminService;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService service;

    @RequestMapping(value = "/maintenances", method = RequestMethod.GET)
    @ResponseBody
    public List<Maintenance> getAllMaintenances(){
        return service.getAll();
    }

    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Maintenance getMaintenance(@PathVariable("id") int id){
        return service.getByID(id);
    }

    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Maintenance postMaintenance(@RequestBody Maintenance maintenance){
        return service.save(maintenance);
    }

    @RequestMapping(value = "/maintenances/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMaintenance(@PathVariable("id") Integer id){
        service.remove(id);
    }

//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @ResponseBody
//    public  String getHello(ModelMap model){
//        return "Hello";
//    }

}
