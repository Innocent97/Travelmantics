package kyalo.innocent.travelmantics.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import kyalo.innocent.travelmantics.models.TravelDeals;

public class FirebaseUtils {

    public static FirebaseDatabase firebaseDatabase;
    public static DatabaseReference databaseReference;
    private static FirebaseUtils firebaseUtils;
    public static ArrayList<TravelDeals> travelDealsList;

    private FirebaseUtils(){}

    public static void openFirbaseConnection(String path) {

        if ( firebaseUtils == null ) {
            firebaseUtils = new FirebaseUtils();
            firebaseDatabase = FirebaseDatabase.getInstance();
            travelDealsList = new ArrayList<>();
        }

        databaseReference = firebaseDatabase.getReference().child(path);
    }
}
