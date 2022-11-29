package com.mobile.model;

import com.mobile.constant.FacilityType;
import com.mobile.constant.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "mobile_food_facility_permit")
public class MobileFoodFacilityPermit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    private String id;
    @Field(name = "locationId")
    private long locationId;
    @Field(name = "applicant")
    private String applicant;
    @Field(name = "facilityType")
    private FacilityType facilityType;
    @Field(name = "cnn")
    private Integer cnn;
    @Field(name = "locationDescription")
    private String locationDescription;
    @Field(name = "address")
    private String address;
    @Field(name = "blocklot")
    private String blocklot;
    @Field(name = "block")
    private String block;
    @Field(name = "lot")
    private String lot;
    @Field(name = "permit")
    private String permit;
    @Field(name = "status")
    private Status status;
    @Field(name = "foodItems")
    private String foodItems;
    @Field(name = "x")
    private Double x;
    @Field(name = "y")
    private Double y;
    @Field(name = "latitude")
    private Double latitude;
    @Field(name = "longitude")
    private Double longitude;
    @Field(name = "schedule")
    private String schedule;
    @Field(name = "daysHours")
    private String daysHours;
    @Field(name = "noiSent")
    private Date noiSent;
    @Field(name = "approved")
    private Date approved;
    @Field(name = "received")
    private Date received;
    @Field(name = "priorPermit")
    private Integer priorPermit;
    @Field(name = "expirationDate")
    private Date expirationDate;
    @Field(name = "location")
    @GeoSpatialIndexed(name = "location_index", type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJson<List<Double>> location;
    @Field(name = "street")
    private String street; //populate as Location Description before “:”
}
