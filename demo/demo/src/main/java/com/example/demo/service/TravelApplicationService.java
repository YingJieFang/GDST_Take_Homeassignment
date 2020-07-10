package com.example.demo.service;

import com.example.demo.dao.TravelApplicationDao;
import com.example.demo.model.TravelApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TravelApplicationService {

     private final TravelApplicationDao travelapplicationDao;

     @Autowired
    public TravelApplicationService(@Qualifier("mockTravelApplicationDao") TravelApplicationDao travelapplicationDao) {
        this.travelapplicationDao = travelapplicationDao;
    }

    public int addTravelApplication(TravelApplication application){
        return travelapplicationDao.insertTravelApplication(application);
    }

    public List<TravelApplication> getAllApplication()
    {
        return travelapplicationDao.selectAllApplication();
    }

    public Optional<TravelApplication> getApplicationByID(UUID id){
         return travelapplicationDao.selectTravelApplicationById(id);
    }

    public int deleteTravelApplicationByID (UUID id)
    {
        return travelapplicationDao.deleteTravelApplicationByID(id);
    }

    public int updateTravelApplicationByID (UUID id, TravelApplication newTravelApplication)
    {
        return travelapplicationDao.updateTravelApplicationByID(id,newTravelApplication);
    }
}
