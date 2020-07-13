package kyalo.innocent.travelmantics.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import kyalo.innocent.travelmantics.R;
import kyalo.innocent.travelmantics.models.TravelDeals;
import kyalo.innocent.travelmantics.utils.FirebaseUtils;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealViewHolder> {

    private ArrayList<TravelDeals> dealsArray;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ChildEventListener fChildEventListener;

    public DealAdapter() {

        FirebaseUtils.openFirbaseConnection("traveldeals");

        database = FirebaseUtils.firebaseDatabase;
        reference = FirebaseUtils.databaseReference;
        dealsArray = FirebaseUtils.travelDealsList;
        fChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                TravelDeals deal = dataSnapshot.getValue(TravelDeals.class);
                dealsArray.add(deal);
                deal.setId(dataSnapshot.getKey());
                notifyItemInserted(dealsArray.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        reference.addChildEventListener(fChildEventListener);

    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new DealViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
       TravelDeals deals = dealsArray.get(position);
       holder.textTitle.setText(deals.getTitle());
    }

    @Override
    public int getItemCount() {
        return dealsArray.size();
    }

    public class DealViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;

        public DealViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.tv_title_display);
        }

        public void bind(TravelDeals deal) {
            textTitle.setText(deal.getTitle());
        }
    }
}
