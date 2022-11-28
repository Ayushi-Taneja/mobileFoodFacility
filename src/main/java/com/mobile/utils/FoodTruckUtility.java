package com.mobile.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class FoodTruckUtility {

    public boolean isDateValid(String expiryDate) {
        return GenericValidator.isDate(expiryDate, "dd-mm-yyyy", true);
    }

    public Date convertStringToDate(String dateString){
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        } catch (ParseException e) {
            log.error("Error parsing string to date {}", dateString, e);
            return null;
        }
    }
}
