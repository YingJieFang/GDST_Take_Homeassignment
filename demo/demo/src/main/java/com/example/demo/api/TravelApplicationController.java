package com.example.demo.api;

import com.example.demo.model.TravelApplication;
import com.example.demo.service.TravelApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/TravelApplication")
@RestController
public class TravelApplicationController {

    private final TravelApplicationService travelApplicationService;

    @Autowired
    public TravelApplicationController(TravelApplicationService travelApplicationService) {
        this.travelApplicationService = travelApplicationService;
    }

    @PostMapping  //Serve as Post Request
    public void  addTravelApplication (@RequestBody TravelApplication travelApplication) {
       travelApplicationService.addTravelApplication(travelApplication);
    }

    @GetMapping
    public List<TravelApplication> getAllApplication()
    {
        return travelApplicationService.getAllApplication();
    }

    @GetMapping(path="/{id}")
    public TravelApplication getApplicationByID(@PathVariable("id") UUID id){
        return travelApplicationService.getApplicationByID(id)
                .orElse(null); //return null
    }

    @DeleteMapping(path="/{id}")
    public void deleteTravelApplicationByID(@PathVariable("id") UUID id){
        travelApplicationService.deleteTravelApplicationByID(id);
    }

    @PutMapping(path="/{id}")
    public void updateTravelApplicationByID(@PathVariable("id") UUID id, @RequestBody TravelApplication applicationToUpdate){
        travelApplicationService.updateTravelApplicationByID(id,applicationToUpdate);;
    }

}
