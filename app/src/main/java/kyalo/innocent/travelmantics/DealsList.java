package kyalo.innocent.travelmantics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import kyalo.innocent.travelmantics.adapters.DealAdapter;
import kyalo.innocent.travelmantics.models.TravelDeals;
import kyalo.innocent.travelmantics.utils.FirebaseUtils;

public class DealsList extends AppCompatActivity {

    private ArrayList<TravelDeals> dealsList;
    private RecyclerView recylcer;
    private DealAdapter fAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_list);

        recylcer = findViewById(R.id.recycler_deals);
        fAdapter = new DealAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recylcer.setLayoutManager(layoutManager);
        recylcer.setAdapter(fAdapter);

    }
}