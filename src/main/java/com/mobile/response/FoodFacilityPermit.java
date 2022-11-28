package com.mobile.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobile.constant.FacilityType;
import com.mobile.constant.Status;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class FoodFacilityPermit {

    @JsonProperty("locationId")
    private long locationId;
    @JsonProperty("applicant")
    private String applicant;
    @JsonProperty("facilityType")
    private FacilityType facilityType;
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
    @JsonProperty("status")
    private Status status;
    @JsonProperty("foodItems")
    private String foodItems;
    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("schedule")
    private String schedule;
    @JsonProperty("daysHours")
    private String daysHours;
    @JsonProperty("noiSent")
    private Date noiSent;
    @JsonProperty("approved")
    private Date approved;
    @JsonProperty("received")
    private Date received;
    @JsonProperty("priorPermit")
    private Integer priorPermit;
    @JsonProperty("expirationDate")
    private Date expirationDate;
    @JsonProperty("location")
    private List<Double> location;
}
