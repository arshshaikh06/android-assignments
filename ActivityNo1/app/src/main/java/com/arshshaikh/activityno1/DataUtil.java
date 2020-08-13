package com.arshshaikh.activityno1;

import java.util.HashMap;

public class DataUtil {
    HashMap<String, HashMap<String, String>> detailsMap = new HashMap<>();
    HashMap<String, String> adnanDetails = new HashMap<>();
    HashMap<String, String> arshDetails = new HashMap<>();
        DataUtil(){
            // Adnan Details
            adnanDetails.put("name", "Adnan");
            adnanDetails.put("email", "adnan@gmail.com");
            adnanDetails.put("sap", "60003170004");

            // Arsh Details
            arshDetails.put("name", "Arsh");
            arshDetails.put("email", "arsh@gmail.com");
            arshDetails.put("sap", "60003170009");

            // Add to DetailsMap
            detailsMap.put("adnan", adnanDetails);
            detailsMap.put("arsh", arshDetails);
        }
}
