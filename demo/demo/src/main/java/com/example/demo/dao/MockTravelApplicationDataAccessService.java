package com.example.demo.dao;

import com.example.demo.model.TravelApplication;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Repository("mockTravelApplicationDao")
public class MockTravelApplicationDataAccessService implements TravelApplicationDao{

    private static List<TravelApplication> DB = new ArrayList<> ();

    @Override
    public int insertTravelApplication(UUID applicationId, TravelApplication travelApplication) {
        DB.add(new TravelApplication(applicationId,
                travelApplication.getCompanyName(),
                travelApplication.getCompanyAddress(),
                travelApplication.getUENNum(),
                travelApplication.getApplicantName(),
                travelApplication.getApplicantContact(),
                travelApplication.getApplicantEmail(),
                travelApplication.getEmployeeName(),
                travelApplication.getEmployeeID(),
                travelApplication.getEmployeePassport(),
                travelApplication.getEmployeeOriginCountry(),
                travelApplication.getEmployeeDestination(),
                travelApplication.getTravelPeriod()
                ));
        return 1;
    }

    @Override
    public List<TravelApplication> selectAllApplication ()
    {
             return DB;
    }

    @Override
    public Optional<TravelApplication> selectTravelApplicationById(UUID id) {
        return DB.stream()
                .filter(travelApplication -> travelApplication.getApplicationId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTravelApplicationByID(UUID id) {
        Optional<TravelApplication> applicationMaybe = selectTravelApplicationById(id);
        if(applicationMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(applicationMaybe.get());
        return 1;
    }

    @Override
    public int updateTravelApplicationByID(UUID id, TravelApplication travelApplicationToUpdate) {
        return selectTravelApplicationById(id)
                .map(travelApplication -> {
                    int indexOfApplicationToUpdate = DB.indexOf(travelApplication);
                    if(indexOfApplicationToUpdate >= 0){
                        DB.set(indexOfApplicationToUpdate,new TravelApplication
                                (id, travelApplicationToUpdate.getCompanyName(),
                                 travelApplicationToUpdate.getCompanyAddress(),
                                 travelApplicationToUpdate.getUENNum(),
                                 travelApplicationToUpdate.getApplicantName(),
                                 travelApplicationToUpdate.getApplicantContact(),
                                 travelApplicationToUpdate.getApplicantEmail(),
                                 travelApplicationToUpdate.getEmployeeName(),
                                 travelApplicationToUpdate.getEmployeeID(),
                                 travelApplicationToUpdate.getEmployeePassport(),
                                 travelApplicationToUpdate.getEmployeeOriginCountry(),
                                 travelApplicationToUpdate.getEmployeeDestination(),
                                 travelApplicationToUpdate.getTravelPeriod()));
                        return 1;
                    }
                       return 0;
        })
                .orElse(0);


    }
}
