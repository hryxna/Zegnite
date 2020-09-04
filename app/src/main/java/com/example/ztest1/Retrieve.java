package com.example.ztest1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Retrieve extends AppCompatActivity {

    private Button showbt,evebt;
    private RadioButton radioButton;
    private TextView dname;
    private EditText stenroll;
    RadioGroup radioGroup;
    TextView eveView;
    String showEvents [];
    String showGEvents [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        evebt = findViewById(R.id.eventBT);
        showbt = findViewById(R.id.showbutton);
        stenroll= findViewById(R.id.editTextNO);
        dname = findViewById(R.id.displaytextView);
        eveView=findViewById(R.id.eventview);
        radioGroup=findViewById(R.id.Rgroup);

        showEvents = getResources().getStringArray(R.array.Event_Lists);
        showGEvents = getResources().getStringArray(R.array.Group_Events);


        evebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioID);
                if(radioButton.equals(findViewById(R.id.radioStudent))){
                AlertDialog.Builder Builder = new AlertDialog.Builder(Retrieve.this);

                Builder.setTitle("Select Event");
                Builder.setSingleChoiceItems(showEvents, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eveView.setText(showEvents[which]);
                    }
                });
                Builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                Builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eveView.setText("");
                        dialog.dismiss();
                    }
                });

                AlertDialog Dialog = Builder.create();
                Dialog.show(); }

                if(radioButton.equals(findViewById(R.id.radioGroup))){
                    AlertDialog.Builder Builder = new AlertDialog.Builder(Retrieve.this);
                    Builder.setTitle("Select Group Event");
                    Builder.setSingleChoiceItems(showGEvents, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            eveView.setText(showGEvents[which]);
                        }
                    });
                    Builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    Builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            eveView.setText("");
                            dialog.dismiss();
                        }
                    });

                    AlertDialog Dialog = Builder.create();
                    Dialog.show(); }
            }
        });

        showbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==showbt) {

                    final String STNO = stenroll.getText().toString().trim();
                    String EVE = eveView.getText().toString().trim();

                    if (TextUtils.isEmpty(STNO))
                    { Toast.makeText(Retrieve.this, "Please Enter the Enroll NO", Toast.LENGTH_LONG).show(); }

                    else if (findViewById(R.id.radioStudent) == null && findViewById(R.id.radioGroup) == null)
                    {Toast.makeText(Retrieve.this,"Please Select Individual or Group",Toast.LENGTH_LONG).show();}

                    else if(TextUtils.isEmpty(EVE))
                    {Toast.makeText(Retrieve.this,"Please Select Event",Toast.LENGTH_LONG).show();}

                    else{

                        if (radioButton.equals(findViewById(R.id.radioStudent))) {

                            final String Events = eveView.getText().toString().trim();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference ref = database.getReference("Zegnite/Events").child(Events).child(STNO);

                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                                    // testshow ts = dataSnapshot.getValue(testshow.class);
                                    //dname.setText(ts.getName());
                                    //final testshow ts = new testshow();

                                    if (dataSnapshot.exists()){

                                        final String Name = dataSnapshot.getValue(testshow.class).getName();

                                    dname.setText(Name);
                                }
                                    else {
                                        Toast.makeText(Retrieve.this,"Data Not Found",Toast.LENGTH_LONG).show();
                                    }


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }

                        if (radioButton.equals(findViewById(R.id.radioGroup))) {

                            final String GID = stenroll.getText().toString().trim();
                            final String GEvents = eveView.getText().toString().trim();
                            final FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference ref = database.getReference("Zegnite/Group Events").child(GEvents).child(GID);

                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                                    // testshow ts = dataSnapshot.getValue(testshow.class);
                                    //dname.setText(ts.getName());
                                    //final testshow ts = new testshow();
                                    if(dataSnapshot.exists()) {

                                        final String Name = dataSnapshot.getValue(Gtestshow.class).getGname();

                                        dname.setText(Name);
                                  }
                                    else {
                                        Toast.makeText(Retrieve.this,"Data Not Found",Toast.LENGTH_LONG).show();
                                    }

                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }

                    }
                }

                }

        });

    }
}
