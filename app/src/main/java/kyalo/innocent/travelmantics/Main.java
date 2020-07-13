package kyalo.innocent.travelmantics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kyalo.innocent.travelmantics.models.TravelDeals;
import kyalo.innocent.travelmantics.utils.FirebaseUtils;

public class Main extends AppCompatActivity {

    private FirebaseDatabase fDatabase;
    private DatabaseReference fReference;
    EditText title, price, desc;
    Button save;

    String fTitle, fPrice, fDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // firebase databse instance
        FirebaseUtils.openFirbaseConnection("traveldeals");

        fDatabase = FirebaseUtils.firebaseDatabase;
        fReference = FirebaseUtils.databaseReference;

        title = findViewById(R.id.edt_title);
        price = findViewById(R.id.edt_price);
        desc = findViewById(R.id.edt_description);
        save = findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDeal();
                clean();
            }
        });
        
    }

    private void saveDeal() {
        fTitle = title.getText().toString();
        fPrice = price.getText().toString();
        fDesc = desc.getText().toString();

        TravelDeals deal = new TravelDeals(fTitle, fPrice, fDesc, "");
        fReference.push().setValue(deal);
    }

    private void clean() {
        title.setText("");
        price.setText("");
        desc.setText("");
        title.requestFocus();
    }
}