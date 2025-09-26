package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPopulator {
    @Autowired
    private FileLoader fileLoader;

    @Autowired
    private DatabaseConduit databaseConduit;

//     public void populate() {
//         String[] userLines = fileLoader.loadStrings("/test_data/lkjhgfdsa.hjkl");
//         for (String userLine : userLines) {
//             String[] userData = userLine.split(", ");
//             UserRecord user = new UserRecord(userData[0], Float.parseFloat(userData[1]));
//             databaseConduit.save(user);
//         }
//     }

public void populate() {
    String[] userLines = fileLoader.loadStrings("/test_data/lkjhgfdsa.hjkl");
    for (String userLine : userLines) {
        String[] userData = userLine.split(", ");
        // Remove non-numeric and non-decimal characters
        String cleanBalance = userData[1].replaceAll("[^0-9.]", "");
        UserRecord user = new UserRecord(userData[0], Float.parseFloat(cleanBalance));
        databaseConduit.save(user);
    }
}
}
