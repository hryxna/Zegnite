package com.example.ztest1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class group extends AppCompatActivity {
    EditText grpName,grpEnroll,grpCollege,grpBranch,grpSem,grpCont,grpID;
    Button gRegButton,gEventButton;
    String [] listEvents;
    TextView EventSelected;
    DatabaseReference gRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        gRef = FirebaseDatabase.getInstance().getReference("Zegnite");

        grpName=findViewById(R.id.gname);
        grpEnroll=findViewById(R.id.geno);
        grpCollege=findViewById(R.id.clgname);
        grpBranch=findViewById(R.id.gbranch);
        grpSem=findViewById(R.id.gsem);
        grpCont=findViewById(R.id.cont);
        grpID=findViewById(R.id.gID);

        EventSelected=findViewById(R.id.GEventSelected);
        listEvents =getResources().getStringArray(R.array.Group_Events);

        gRegButton=findViewById(R.id.rButton);

        gEventButton=findViewById(R.id.ge);

        //GEvent Button

        gEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder mBuilder = new android.app.AlertDialog.Builder(com.example.ztest1.group.this);
                mBuilder.setTitle("Select Group Event");
                mBuilder.setSingleChoiceItems(listEvents, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventSelected.setText(listEvents[which]);

                    }
                });
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventSelected.setText("");
                        dialog.dismiss();
                    }
                });
                AlertDialog Dialog = mBuilder.create();
                Dialog.show();

            }
        });

        //Register Button

        gRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==gRegButton){
                    Gregister();
                }
            }
        });



    }

    private  void Gregister(){

        String GName = grpName.getText().toString().trim();
        String GEnroll = grpEnroll.getText().toString().trim();
        String GCollege = grpCollege.getText().toString().trim();
        String GBranch = grpBranch.getText().toString().trim();
        String GSem = grpSem.getText().toString().trim();
        String GContact = grpCont.getText().toString().trim();
        String GEvents = EventSelected.getText().toString().trim();
        String GrpID = grpID.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        if (TextUtils.isEmpty(GEnroll)) {
            Toast.makeText(this, "Enter EnrollNo.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GName)) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GCollege)) {
            Toast.makeText(this, "Enter College Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GBranch)) {
            Toast.makeText(this, "Enter Branch Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GSem)) {
            Toast.makeText(this, "Enter Semester", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GContact)) {
            Toast.makeText(this, "Enter ContactNo.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GEvents)) {
            Toast.makeText(this, "Select Event", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(GrpID)){
            Toast.makeText(this,"Enter Group ID",Toast.LENGTH_SHORT).show();
        }
        else {

            String GrpuID = gRef.push().getKey();
            EGroup eGroup = new EGroup(GrpuID,GName,GEnroll,GCollege,GBranch,GSem,GContact,GEvents,GrpID,userId);

            if (GEvents.equals("Robobling")){gRef.child("Group Events").child("Robobling").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Xtreme Race")){gRef.child("Group Events").child("Xtreme Race").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Robo Sportyf")){gRef.child("Group Events").child("Sportyf").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Robozzle (4)")){gRef.child("Group Events").child("Robozzle").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Roll The Ball")){gRef.child("Group Events").child("Roll The Ball").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Bridge Mania")){gRef.child("Group Events").child("Bridge Mania").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Bob The Destroyer")){gRef.child("Group Events").child("Bob The Destroyer").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Bob The Builder")){gRef.child("Group Events").child("Bob The Builder").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Hydro Rocket")){gRef.child("Group Events").child("Hydro Rocket").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Electro Capture")){gRef.child("Group Events").child("Electro Capture").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Wireocity (2)")){gRef.child("Group Events").child("Wireocity").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Counter Strike")){gRef.child("Group Events").child("Counter Strike").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Scary Treasure Hunt")){gRef.child("Group Events").child("Scary Treasure Hunt").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Roadies Xtreme")){gRef.child("Group Events").child("Roadies Xtreme").child(GrpID).setValue(eGroup);}
            if (GEvents.equals("Quizmania")){gRef.child("Group Events").child("Quizmania").child(GrpID).setValue(eGroup);}

            Toast.makeText(this,"Group Registered Successfully",Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(getApplicationContext(),IndGrp.class));
        }
    }

}
