package com.example.demo.dao;
import java.util.UUID;
import com.example.demo.model.TravelApplication;
import java.util.List;
import java.util.Optional;

public interface TravelApplicationDao {

    int insertTravelApplication (UUID applicationId, TravelApplication travelApplication );

    default int insertTravelApplication(TravelApplication application)
    {
        UUID applicationID = UUID.randomUUID();
        return insertTravelApplication(applicationID, application);
    }

    List<TravelApplication>  selectAllApplication();

    Optional<TravelApplication> selectTravelApplicationById(UUID id);

    int deleteTravelApplicationByID(UUID id);

    int updateTravelApplicationByID(UUID id, TravelApplication travelApplication);
}
