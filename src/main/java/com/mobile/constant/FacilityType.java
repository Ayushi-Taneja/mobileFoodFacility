package com.mobile.constant;

import lombok.Getter;

import java.util.Optional;

public enum FacilityType {

    TRUCK("Truck"),
    PUSH_CART("Push Cart");

    @Getter
    String value;

    FacilityType(String value){
        this.value = value;
    }

    public static Optional<FacilityType> fromValue(String value){
        for(FacilityType ft: FacilityType.values()){
            if(ft.value.equals(value)){
                return Optional.of(ft);
            }
        }
        return Optional.empty();
    }
}
