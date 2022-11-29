package com.mobile.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobile.constant.FacilityType;
import com.mobile.constant.Status;
import lombok.Data;

import java.util.List;

@Data
public class AddFoodTruckRequest {

    @JsonProperty(value = "locationId", required = true)
    private long locationId;
    @JsonProperty(value = "applicant", required = true)
    private String applicant;
    @JsonProperty(value = "facilityType", required = true)
    private String facilityType;
    @JsonProperty("cnn")
    private Integer cnn;
    @JsonProperty("locationDescription")
    private String locationDescription;
    @JsonProperty("address")
    private String address;
    @JsonProperty("blocklot")
    private String blocklot;
    @JsonProperty("block")
    private String block;
    @JsonProperty("lot")
    private String lot;
    @JsonProperty("permit")
    private String permit;
    @JsonProperty(value = "status", required = true)
    private Status status;
    @JsonProperty("foodItems")
    private String foodItems;
    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonProperty(value = "latitude", required = true)
    private Double latitude;
    @JsonProperty(value = "longitude", required = true)
    private Double longitude;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("daysHours")
    private String daysHours;
    @JsonProperty("noiSent")
    @JsonFormat(pattern="dd-MM-yyyy")
    private String noiSent;
    @JsonProperty("approved")
    @JsonFormat(pattern="dd-MM-yyyy")
    private String approved;
    @JsonProperty("received")
    @JsonFormat(pattern="dd-MM-yyyy")
    private String received;
    @JsonProperty("priorPermit")
    private Integer priorPermit;
    @JsonProperty("expirationDate")
    @JsonFormat(pattern="dd-MM-yyyy")
    private String expirationDate;
}
