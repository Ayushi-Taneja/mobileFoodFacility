package com.mobile.controller;

import com.mobile.request.AddFoodTruckRequest;
import com.mobile.response.FoodFacilityPermit;
import com.mobile.service.FoodFacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/truck")
public class FoodTruckController {

    @Autowired
    private FoodFacilityService foodFacilityService;

    @GetMapping(value = "/hello")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping(value = "/v1/searchBy/applicant/{name}")
    public ResponseEntity searchTruckDataByApplicant(@PathVariable("name") String applicantName){
        log.info("Received request to get all facility Data by applicant name {}", applicantName);
        try {
            List<FoodFacilityPermit> result = foodFacilityService.getDataByApplicantName(applicantName);
            if(CollectionUtils.isEmpty(result)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        }   catch (final IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Applicant Name is either blank/null, please provide valid name");
        } catch (final Exception e){
            log.error("Error getting all facility data by applicant name {}", applicantName, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/v1/searchBy/street/{name}")
    public ResponseEntity searchTruckDataByStreet(@PathVariable("name") String streetName){
        log.info("Received request to get all facility Data by street name {}", streetName);
        try {
            List<FoodFacilityPermit> result = foodFacilityService.getDataByStreetName(streetName);
            if(CollectionUtils.isEmpty(result)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        }   catch (final IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Street Name is either blank/null, please provide valid street");
        } catch (final Exception e){
            log.error("Error getting all facility data by street name {}", streetName, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/v1/searchBy/expiryDate/{date}")
    public ResponseEntity searchTruckDataByExpiry(@PathVariable("date") String expiryDate){
        log.info("Received request to get all facility Data by expiry date {}", expiryDate);
        try {
            List<FoodFacilityPermit> result = foodFacilityService.getDataByExpiryDate(expiryDate);
            if(CollectionUtils.isEmpty(result)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        }   catch (final IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Expiry date is invalid, please provide valid date in dd-MM-yyyy format");
        } catch (final Exception e){
            log.error("Error getting all facility data by expiry date {}", expiryDate, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/v1/addTruck")
    public ResponseEntity addTruck(@RequestBody AddFoodTruckRequest addFoodTruckRequest){
        log.info("Received request to add food truck {}", addFoodTruckRequest);
        try {
            FoodFacilityPermit result = foodFacilityService.addFoodTruck(addFoodTruckRequest);
            return ResponseEntity.ok(result);
        }   catch (final IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Add food truck request is null/invalid, please provide valid request");
        } catch (final Exception e){
            log.error("Error adding food truck {}", addFoodTruckRequest, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/v1/closestTruck")
    public ResponseEntity getClosestTruck(@RequestParam(value = "latitude", required = true) Double latitude,
                                          @RequestParam(value = "longitude", required = true) Double longitude) {
        log.info("Received request to get closest truck {},{}", latitude, longitude);
        try {
            FoodFacilityPermit result = foodFacilityService.getClosestTruck(latitude, longitude);
            return ResponseEntity.ok(result);
        } catch (final Exception e){
            log.error("Error getting closest truck {},{}", latitude, longitude, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/v1/updateTruck/{locationId}")
    public ResponseEntity addTruck(@PathVariable("locationId") Integer locationId,
                                   @RequestBody AddFoodTruckRequest updateFoodTruckRequest){
        log.info("Received request to update food truck for {}", locationId);
        try {
            FoodFacilityPermit result = foodFacilityService.updateFoodTruck(updateFoodTruckRequest);
            return ResponseEntity.ok(result);
        } catch (final Exception e){
            log.error("Error updating food truck for {}", locationId, e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
