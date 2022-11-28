package com.mobile.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class DataLoader {

    private void pushDataRow(String line){
        if(line == null || line.isEmpty() || line.isBlank()){
            log.warn("Incorrect row format: ignoring line " + line);
            return;
        }
        List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
        for(int i=0;i<items.size();i++){
            if(i==0){ //locationId

            }
        }
    }
}
