package com.mobile.constant;

import lombok.Getter;

import java.util.Optional;

public enum Status {

    REQUESTED("REQUESTED"),
    APPROVED("APPROVED"),
    EXPIRED("EXPIRED");

    @Getter
    String value;

    Status(String value){
        this.value = value;
    }

    public static Optional<Status> fromValue(String value){
        for(Status status: Status.values()){
            if(status.value.equals(value)){
                return Optional.of(status);
            }
        }
        return Optional.empty();
    }

}
