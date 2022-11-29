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
        return GenericValidator.isDate(expiryDate, "dd-MM-yyyy", true);
    }

    public Date convertStringToDate(String dateString) throws ParseException {
        if(dateString == null || dateString.isBlank()) return null;
        if(!isDateValid(dateString)){
            throw new IllegalArgumentException();
        }
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }
}
