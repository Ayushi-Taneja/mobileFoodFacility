package com.mobile.service;

import com.mobile.constant.FacilityType;
import com.mobile.constant.Status;
import com.mobile.model.MobileFoodFacilityPermit;
import com.mobile.repository.MobileFoodRepository;
import com.mobile.request.AddFoodTruckRequest;
import com.mobile.response.FoodFacilityPermit;
import com.mobile.utils.ConvertToResponse;
import com.mobile.utils.FoodTruckUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class FoodFacilityServiceImpl implements FoodFacilityService {

    @Autowired
    private MobileFoodRepository mobileFoodRepository;

    @Autowired
    private ConvertToResponse convertToResponse;

    @Autowired
    private FoodTruckUtility foodTruckUtility;

    @Override
    public List<FoodFacilityPermit> getDataByApplicantName(String applicantName) {
        if(applicantName == null || applicantName.isBlank()){
            throw new IllegalArgumentException();
        }
        List<MobileFoodFacilityPermit> foodTrucks = mobileFoodRepository.findAllByApplicant(applicantName);
        List<FoodFacilityPermit> result = convertToResponse.createFoodTruckResponseBulk(foodTrucks);
        return result;
    }

    @Override
    public List<FoodFacilityPermit> getDataByStreetName(String streetName) {
        if(streetName == null || streetName.isBlank()){
            throw new IllegalArgumentException();
        }
        List<MobileFoodFacilityPermit> foodTrucks = mobileFoodRepository.findAllByStreet(streetName);
        List<FoodFacilityPermit> result = convertToResponse.createFoodTruckResponseBulk(foodTrucks);
        return result;
    }

    @Override
    public List<FoodFacilityPermit> getDataByExpiryDate(String expiryDate) throws ParseException {
        if(expiryDate == null || expiryDate.isBlank() || !foodTruckUtility.isDateValid(expiryDate)){
            throw new IllegalArgumentException();
        }
        Date expiry = foodTruckUtility.convertStringToDate(expiryDate);
        List<MobileFoodFacilityPermit> foodTrucks = mobileFoodRepository.findAllByExpirationDateLessThanEqual(expiry);
        List<FoodFacilityPermit> result = convertToResponse.createFoodTruckResponseBulk(foodTrucks);
        return result;
    }

    @Override
    public FoodFacilityPermit addFoodTruck(AddFoodTruckRequest addFoodTruckRequest) throws ParseException {
        if(addFoodTruckRequest == null || FacilityType.fromValue(addFoodTruckRequest.getFacilityType()).isEmpty()) throw new IllegalArgumentException();
        MobileFoodFacilityPermit mobileFoodFacilityPermit = convertToResponse.createFoodTruckModel(addFoodTruckRequest);
        mobileFoodRepository.save(mobileFoodFacilityPermit);
        return convertToResponse.createFoodTruckResponse(mobileFoodFacilityPermit);
    }

    @Override
    public FoodFacilityPermit getClosestTruck(Double latitude, Double longitude) {
        Pageable pageable = Pageable.ofSize(1);
        List<MobileFoodFacilityPermit> closest = mobileFoodRepository.findByStatusAndLocationNear(Status.APPROVED, new GeoJsonPoint(longitude, latitude), pageable);
        if(CollectionUtils.isEmpty(closest)) {
            return null;
        }
        FoodFacilityPermit result = convertToResponse.createFoodTruckResponse(closest.get(0));
        return result;
    }
}
