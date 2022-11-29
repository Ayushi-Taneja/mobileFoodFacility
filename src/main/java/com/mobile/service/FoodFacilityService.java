package com.mobile.service;

import com.mobile.request.AddFoodTruckRequest;
import com.mobile.response.FoodFacilityPermit;

import java.text.ParseException;
import java.util.List;

public interface FoodFacilityService {

    /**
     * A function which returns all food trucks/carts of the given applicant
     * @param applicantName
     * @return List<FoodFacilityPermit>
     * @throws IllegalArgumentException if applicantName is null or blank
     */
    List<FoodFacilityPermit> getDataByApplicantName(String applicantName);


    /**
     * A function which returns all food trucks/carts by the given street name
     * @param streetName
     * @return List<FoodFacilityPermit>
     * @throws IllegalArgumentException if streetName is null or blank
     */
    List<FoodFacilityPermit> getDataByStreetName(String streetName);

    /**
     * A function which returns all food trucks/carts with expiry date on or before the given date
     * @param expiryDate
     * @return List<FoodFacilityPermit>
     * @throws ParseException if given expiryDate is not of dd-MM-yyyy format
     * @throws IllegalArgumentException if expiry date is null/blank/invalid date
     */
    List<FoodFacilityPermit> getDataByExpiryDate(String expiryDate) throws ParseException;

    /**
     * Adds a new truck/push cart to the database, populates the new street column using locationDescription
     * and sets location using longitude and latitude
     * @param addFoodTruckRequest
     * @return FoodFacilityPermit response of newly added truck/cart
     * @throws ParseException if any non-null date given in the request is of an incorrect format
     * @throws IllegalArgumentException if addRequest is null or given FacilityType is not a know type
     */
    FoodFacilityPermit addFoodTruck(AddFoodTruckRequest addFoodTruckRequest) throws ParseException;

    /**
     * To get closest approved truck/cart from the given location
     * @param latitude
     * @param longitude
     * @return FoodFacilityPermit response of the closest truck/cart
     */
    FoodFacilityPermit getClosestTruck(Double latitude, Double longitude);
}
