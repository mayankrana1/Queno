package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bussiness extends AppCompatActivity {

    ListView businessListView;
    ArrayList<SubService> businessList;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiness);
        businessListView = (ListView)findViewById(R.id.bussinessListView);
        businessList = new ArrayList<SubService>();
        firebaseAuth=FirebaseAuth.getInstance();

        businessList = new ArrayList<SubService>();



    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        //progressDialog.setMessage("Fetching Details!!");

        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("subServices");

        try {

            adminsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    businessList.clear();

                    for (DataSnapshot mealSnapshot : dataSnapshot.getChildren()) {
                        SubService a = mealSnapshot.getValue(SubService.class);
                        businessList.add(a);

                    }


                    ListAdapter customListAdapter = new BussinessListAdapter(Bussiness.this,businessList);
                    businessListView.setAdapter(customListAdapter);
                    //progressDialog.dismiss();
                    if (businessList.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No Services found", Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }
                    businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox3);
                            if(checkBox.isChecked()){
                                Toast.makeText(Bussiness.this,"1"+position,Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(Bussiness.this,"1"+position,Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w("res", databaseError.toException());
                    Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
