package com.example.ztest1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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



public class show extends MainActivity implements View.OnClickListener {

    private EditText name, enroll, college, branch, sem, contact;
    private Button Regbt,EvtBt1,EvtBt2,EvtBt3;
    TextView EventSelected,EventSelected2,EventSelected3;
    String[] listEvents;
    DatabaseReference DatabaseStudent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        DatabaseStudent = FirebaseDatabase.getInstance().getReference("Zegnite");

        name = findViewById(R.id.editText1);
        enroll = findViewById(R.id.editText2);
        college = findViewById(R.id.editText5);
        branch = findViewById(R.id.editText4);
        sem = findViewById(R.id.editText3);
        contact = findViewById(R.id.editText6);
        Regbt = findViewById(R.id.register);

        //Single Choice Check Box

        EvtBt1 = findViewById(R.id.se);
        EvtBt2 = findViewById(R.id.se2);
        EvtBt3 = findViewById(R.id.se3);
        EventSelected = findViewById(R.id.EventSelected);
        EventSelected2 = findViewById(R.id.EventSelected2);
        EventSelected3 = findViewById(R.id.EventSelected3);

        listEvents =getResources().getStringArray(R.array.Event_Lists);

        EvtBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(com.example.ztest1.show.this);
                mBuilder.setTitle("Select Event");
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

        EvtBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(com.example.ztest1.show.this);
                mBuilder.setTitle("Select Event");
                mBuilder.setSingleChoiceItems(listEvents, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventSelected2.setText(listEvents[which]);

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
                        EventSelected2.setText("");
                        dialog.dismiss();
                    }
                });
                AlertDialog Dialog = mBuilder.create();
                Dialog.show();

            }
        });

        EvtBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(com.example.ztest1.show.this);
                mBuilder.setTitle("Select Event");
                mBuilder.setSingleChoiceItems(listEvents, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventSelected3.setText(listEvents[which]);

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
                        EventSelected3.setText("");
                        dialog.dismiss();
                    }
                });
                AlertDialog Dialog = mBuilder.create();
                Dialog.show();

            }
        });




        //Register Button

        Regbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Regbt) {
                    Register();
                }
            }
        });


    }

    //Registration Form

    private void Register() {
        String Name = name.getText().toString().trim();
        String Enroll = enroll.getText().toString().trim();
        String College = college.getText().toString().trim();
        String Branch = branch.getText().toString().trim();
        String Sem = sem.getText().toString().trim();
        String Contact = contact.getText().toString().trim();
        String Events1 = EventSelected.getText().toString().trim();
        String Events2 = EventSelected2.getText().toString().trim();
        String Events3 = EventSelected3.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        if (TextUtils.isEmpty(Enroll)) {
            Toast.makeText(this, "Enter EnrollNo.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Name)) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(College)) {
            Toast.makeText(this, "Enter College Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Branch)) {
            Toast.makeText(this, "Enter Branch Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Sem)) {
            Toast.makeText(this, "Enter Semester", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Contact)) {
            Toast.makeText(this, "Enter ContactNo.", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Events1) && TextUtils.isEmpty(Events2) && TextUtils.isEmpty(Events3)) {
            Toast.makeText(this, "Select Event", Toast.LENGTH_SHORT).show();
        }
        else {
            String uID = DatabaseStudent.push().getKey();
            Student student = new Student(uID, Name, Enroll, College, Branch, Sem, Contact,Events1,Events2,Events3,userId);

            if (Events1.equals("Lathe Master")) { DatabaseStudent.child("Events").child("Lathe Master").child(Enroll).setValue(student);}
            if (Events1.equals("Graphic Mania")) { DatabaseStudent.child("Events").child("Graphic Mania").child(Enroll).setValue(student);}
            if (Events1.equals("CAD War")) { DatabaseStudent.child("Events").child("CAD War").child(Enroll).setValue(student);}
            if (Events1.equals("Brain Ripple")) { DatabaseStudent.child("Events").child("Brain Ripple").child(Enroll).setValue(student);}
            if (Events1.equals("Blueprint")) { DatabaseStudent.child("Events").child("Blueprint").child(Enroll).setValue(student);}
            if (Events1.equals("Paper Wings")) { DatabaseStudent.child("Events").child("Paper Wings").child(Enroll).setValue(student);}
            if (Events1.equals("Parachute")) { DatabaseStudent.child("Events").child("Parachute").child(Enroll).setValue(student);}
            if (Events1.equals("Bill Board")) { DatabaseStudent.child("Events").child("Bill Board").child(Enroll).setValue(student);}
            if (Events1.equals("Shutter Bug")) { DatabaseStudent.child("Events").child("Shutter Bug").child(Enroll).setValue(student);}
            if (Events1.equals("Electroburst")) { DatabaseStudent.child("Events").child("Electroburst").child(Enroll).setValue(student);}
            if (Events1.equals("Web Warrior")) { DatabaseStudent.child("Events").child("Web Warrior").child(Enroll).setValue(student);}
            if (Events1.equals("DB Mania")) { DatabaseStudent.child("Events").child("DB Mania").child(Enroll).setValue(student);}
            if (Events1.equals("Clash Code")) { DatabaseStudent.child("Events").child("Clash Code").child(Enroll).setValue(student);}
            if (Events1.equals("Cryptrics")) { DatabaseStudent.child("Events").child("Cryptrics").child(Enroll).setValue(student);}
            if (Events1.equals("Cyberhunt")) { DatabaseStudent.child("Events").child("Cyberhunt").child(Enroll).setValue(student);}
            if (Events1.equals("Techno Zems")) { DatabaseStudent.child("Events").child("Techno Zems").child(Enroll).setValue(student);}

            if (Events2.equals("Lathe Master")) { DatabaseStudent.child("Events").child("Lathe Master").child(Enroll).setValue(student);}
            if (Events2.equals("Graphic Mania")) { DatabaseStudent.child("Events").child("Graphic Mania").child(Enroll).setValue(student);}
            if (Events2.equals("CAD War")) { DatabaseStudent.child("Events").child("CAD War").child(Enroll).setValue(student);}
            if (Events2.equals("Brain Ripple")) { DatabaseStudent.child("Events").child("Brain Ripple").child(Enroll).setValue(student);}
            if (Events2.equals("Blueprint")) { DatabaseStudent.child("Events").child("Blueprint").child(Enroll).setValue(student);}
            if (Events2.equals("Paper Wings")) { DatabaseStudent.child("Events").child("Paper Wings").child(Enroll).setValue(student);}
            if (Events2.equals("Parachute")) { DatabaseStudent.child("Events").child("Parachute").child(Enroll).setValue(student);}
            if (Events2.equals("Bill Board")) { DatabaseStudent.child("Events").child("Bill Board").child(Enroll).setValue(student);}
            if (Events2.equals("Shutter Bug")) { DatabaseStudent.child("Events").child("Shutter Bug").child(Enroll).setValue(student);}
            if (Events2.equals("Electroburst")) { DatabaseStudent.child("Events").child("Electroburst").child(Enroll).setValue(student);}
            if (Events2.equals("Web Warrior")) { DatabaseStudent.child("Events").child("Web Warrior").child(Enroll).setValue(student);}
            if (Events2.equals("DB Mania")) { DatabaseStudent.child("Events").child("DB Mania").child(Enroll).setValue(student);}
            if (Events2.equals("Clash Code")) { DatabaseStudent.child("Events").child("Clash Code").child(Enroll).setValue(student);}
            if (Events2.equals("Cryptrics")) { DatabaseStudent.child("Events").child("Cryptrics").child(Enroll).setValue(student);}
            if (Events2.equals("Cyberhunt")) { DatabaseStudent.child("Events").child("Cyberhunt").child(Enroll).setValue(student);}
            if (Events2.equals("Techno Zems")) { DatabaseStudent.child("Events").child("Techno Zems").child(Enroll).setValue(student);}

            if (Events3.equals("Lathe Master")) { DatabaseStudent.child("Events").child("Lathe Master").child(Enroll).setValue(student);}
            if (Events3.equals("Graphic Mania")) { DatabaseStudent.child("Events").child("Graphic Mania").child(Enroll).setValue(student);}
            if (Events3.equals("CAD War")) { DatabaseStudent.child("Events").child("CAD War").child(Enroll).setValue(student);}
            if (Events3.equals("Brain Ripple")) { DatabaseStudent.child("Events").child("Brain Ripple").child(Enroll).setValue(student);}
            if (Events3.equals("Blueprint")) { DatabaseStudent.child("Events").child("Blueprint").child(Enroll).setValue(student);}
            if (Events3.equals("Paper Wings")) { DatabaseStudent.child("Events").child("Paper Wings").child(Enroll).setValue(student);}
            if (Events3.equals("Parachute")) { DatabaseStudent.child("Events").child("Parachute").child(Enroll).setValue(student);}
            if (Events3.equals("Bill Board")) { DatabaseStudent.child("Events").child("Bill Board").child(Enroll).setValue(student);}
            if (Events3.equals("Shutter Bug")) { DatabaseStudent.child("Events").child("Shutter Bug").child(Enroll).setValue(student);}
            if (Events3.equals("Electroburst")) { DatabaseStudent.child("Events").child("Electroburst").child(Enroll).setValue(student);}
            if (Events3.equals("Web Warrior")) { DatabaseStudent.child("Events").child("Web Warrior").child(Enroll).setValue(student);}
            if (Events3.equals("DB Mania")) { DatabaseStudent.child("Events").child("DB Mania").child(Enroll).setValue(student);}
            if (Events3.equals("Clash Code")) { DatabaseStudent.child("Events").child("Clash Code").child(Enroll).setValue(student);}
            if (Events3.equals("Cryptrics")) { DatabaseStudent.child("Events").child("Cryptrics").child(Enroll).setValue(student);}
            if (Events3.equals("Cyberhunt")) { DatabaseStudent.child("Events").child("Cyberhunt").child(Enroll).setValue(student);}
            if (Events3.equals("Techno Zems")) { DatabaseStudent.child("Events").child("Techno Zems").child(Enroll).setValue(student);}

                    Toast.makeText(com.example.ztest1.show.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),IndGrp.class));


                    }


        }


}




