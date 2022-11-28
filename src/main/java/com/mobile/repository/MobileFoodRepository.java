package com.mobile.repository;

import com.mobile.constant.Status;
import com.mobile.model.MobileFoodFacilityPermit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface MobileFoodRepository extends MongoRepository<MobileFoodFacilityPermit, Integer> {


    List<MobileFoodFacilityPermit> findAllByApplicant(String applicantName);

    List<MobileFoodFacilityPermit> findAllByStreet(String streetName);

    List<MobileFoodFacilityPermit> findAllByExpirationDateLessThanEqual(Date expiry);

    List<MobileFoodFacilityPermit> findByStatusNotAndLocationNear(Status status, GeoJsonPoint point, Pageable pageable);
}
