package com.example.ztest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IndGrp extends AppCompatActivity {

    private EditText Enopay,Tpay,Apay;
    private RadioButton radioButton;
    private Button NextBt;
    RadioGroup radioGroup;
    DatabaseReference payref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ind_grp);

        payref = FirebaseDatabase.getInstance().getReference("Zegnite");

        Enopay=findViewById(R.id.Epay);
        Tpay=findViewById(R.id.AMT);
        Apay=findViewById(R.id.PAID);

        radioGroup=findViewById(R.id.Rgroup);



        NextBt=findViewById(R.id.nextbutton);
        NextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==NextBt){

                    stPayment();

                }
            }
        });
    }

private void stPayment(){

        String Enroll = Enopay.getText().toString().trim();
        String Totalpay = Tpay.getText().toString().trim();
        String Amount = Apay.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        if(TextUtils.isEmpty(Enroll)){ Toast.makeText(this,"Please Enter Enroll No.",Toast.LENGTH_SHORT).show();}
        else if(TextUtils.isEmpty(Totalpay)){ Toast.makeText(this,"Enter Total Amount",Toast.LENGTH_SHORT).show();}
        else if(TextUtils.isEmpty(Amount)){ Toast.makeText(this,"Enter Amount Paid",Toast.LENGTH_SHORT).show();}

        else {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioID);

                if(radioButton!=findViewById(R.id.radioStudent) && radioButton !=findViewById(R.id.radioGroup)){Toast.makeText(this,"Select Individual or Group",Toast.LENGTH_SHORT).show();}

                 else {
                         Payment payment = new Payment(Enroll,Totalpay,Amount,userId);

                         if(radioButton.equals(findViewById(R.id.radioStudent))){
                             payref.child("Payment").child("Individual").child(Enroll).setValue(payment);
                             finish();
                             startActivity(new Intent(getApplicationContext(),show.class));
                            }
                         if (radioButton.equals(findViewById(R.id.radioGroup))){
                             payref.child("Payment").child("Group").child(Enroll).setValue(payment);
                             finish();
                             startActivity(new Intent(getApplicationContext(),group.class));
                             }

                 }

        }
    }

}
