package com.mobile.utils;

import com.mobile.constant.FacilityType;
import com.mobile.model.MobileFoodFacilityPermit;
import com.mobile.request.AddFoodTruckRequest;
import com.mobile.response.FoodFacilityPermit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ConvertToResponse {

    @Autowired
    private FoodTruckUtility foodTruckUtility;

    public List<FoodFacilityPermit> createFoodTruckResponseBulk(List<MobileFoodFacilityPermit> foodTrucks) {
        if(CollectionUtils.isEmpty(foodTrucks)){
            return Collections.EMPTY_LIST;
        }
        List<FoodFacilityPermit> result = new ArrayList<>();
        for(MobileFoodFacilityPermit permit: foodTrucks){
            result.add(createFoodTruckResponse(permit));
        }
        return result;
    }

    public MobileFoodFacilityPermit createFoodTruckModel(AddFoodTruckRequest addFoodTruckRequest) {
        MobileFoodFacilityPermit permit = new MobileFoodFacilityPermit();
        BeanUtils.copyProperties(addFoodTruckRequest, permit);
        permit.setFacilityType(FacilityType.fromValue(addFoodTruckRequest.getFacilityType()).orElse(FacilityType.TRUCK));
        String street = addFoodTruckRequest.getLocationDescription() == null || addFoodTruckRequest.getLocationDescription().isBlank() ? null :
                addFoodTruckRequest.getLocationDescription().substring(0, addFoodTruckRequest.getLocationDescription().indexOf(":"));
        permit.setStreet(street);
        permit.setNoiSent(foodTruckUtility.convertStringToDate(addFoodTruckRequest.getNoiSent()));
        permit.setExpirationDate(foodTruckUtility.convertStringToDate(addFoodTruckRequest.getExpirationDate()));
        permit.setApproved(foodTruckUtility.convertStringToDate(addFoodTruckRequest.getApproved()));
        permit.setReceived(foodTruckUtility.convertStringToDate(addFoodTruckRequest.getReceived()));
        permit.setLocation(new GeoJsonPoint(addFoodTruckRequest.getLongitude(), addFoodTruckRequest.getLatitude()));
        return permit;
    }

    public FoodFacilityPermit createFoodTruckResponse(MobileFoodFacilityPermit mobileFoodFacilityPermit) {
        if(mobileFoodFacilityPermit == null) return null;
        /*FoodFacilityPermit result = FoodFacilityPermit.builder().locationId(mobileFoodFacilityPermit.getLocationId())
                .address(mobileFoodFacilityPermit.getAddress())
                .applicant(mobileFoodFacilityPermit.getApplicant())
                .approved(mobileFoodFacilityPermit.getApproved())
                .block(mobileFoodFacilityPermit.getBlock())
                .blocklot(mobileFoodFacilityPermit.getBlocklot())
                .cnn(mobileFoodFacilityPermit.getCnn())
                .foodItems(mobileFoodFacilityPermit.getFoodItems())
                .daysHours(mobileFoodFacilityPermit.getDaysHours())
                .expirationDate(mobileFoodFacilityPermit.getExpirationDate())
                .facilityType(mobileFoodFacilityPermit.getFacilityType())
                .latitude(mobileFoodFacilityPermit.getLatitude())
                .longitude(mobileFoodFacilityPermit.getLongitude())
                .x(mobileFoodFacilityPermit.getX())
                .y(mobileFoodFacilityPermit.getY())
                .lot(mobileFoodFacilityPermit.getLot())
                .permit(mobileFoodFacilityPermit.getPermit())
                .locationDescription(mobileFoodFacilityPermit.getLocationDescription())
                .noiSent(mobileFoodFacilityPermit.getNoiSent())
                .priorPermit(mobileFoodFacilityPermit.getPriorPermit())
                .schedule(mobileFoodFacilityPermit.getSchedule())
                .received(mobileFoodFacilityPermit.getReceived())
                .status(mobileFoodFacilityPermit.getStatus())
                .location(mobileFoodFacilityPermit.getLocation().getCoordinates())
                .build();*/
        FoodFacilityPermit result = new FoodFacilityPermit();
        BeanUtils.copyProperties(mobileFoodFacilityPermit, result);
        result.setLocation(mobileFoodFacilityPermit.getLocation().getCoordinates());
        return result;
    }


}
