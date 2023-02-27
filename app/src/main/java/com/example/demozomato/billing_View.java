package com.example.demozomato;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class billing_View extends AppCompatActivity {


    Button btnCart;
    TextView  txtOriginalSelectedDishName,txtOriginalSelectedPrice,txtOriginalSelectedQuantity,txtCalculatedSelectedPrize;
    TextView txtBillingPrize,txtBillingTaxPrize,txtFinalBillingPrice,txtxDetailName,txtxDetailNumber,txtAddres,txtChange,payTotalAmount;
    CardView txtxDetails;
    RelativeLayout btnFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_view);

        txtOriginalSelectedDishName=findViewById(R.id.txtOriginalSelectedDishName);
        txtOriginalSelectedPrice=findViewById(R.id.txtOriginalSelectedPrice);
        txtCalculatedSelectedPrize=findViewById(R.id.txtCalculatedSelectedPrize);
        txtOriginalSelectedQuantity=findViewById(R.id.txtOriginalSelectedQuantity);
        txtBillingPrize=findViewById(R.id.txtBillingPrize);
        txtBillingTaxPrize=findViewById(R.id.txtBillingTaxPrize);
        txtFinalBillingPrice=findViewById(R.id.txtFinalBillingPrice);
        txtxDetails=findViewById(R.id.txtxDetails);
        txtxDetailNumber=findViewById(R.id.txtxDetailNumber);
        txtxDetailName=findViewById(R.id.txtxDetailName);
        txtAddres=findViewById(R.id.txtAddres);
        txtChange=findViewById(R.id.txtChange);
        payTotalAmount=findViewById(R.id.payTotalAmount);
        btnFinal=findViewById(R.id.btnFinal);






        String heading= getIntent().getStringExtra("heading");
        int pricee= getIntent().getIntExtra("pricee",0);
        int count= getIntent().getIntExtra("count",0);
        int total=getIntent().getIntExtra("total",0);

        txtOriginalSelectedDishName.setText(heading);
        txtOriginalSelectedPrice.setText(Integer.toString(pricee));
        txtOriginalSelectedQuantity.setText(Integer.toString(count));
        txtCalculatedSelectedPrize.setText(Integer.toString(total));

        double tax= total*0.05;
        int subtotal= total;
        double grandtotal=total+tax;

        txtFinalBillingPrice.setText(Double.toString(grandtotal));
        txtBillingTaxPrize.setText(Double.toString(tax));
        txtBillingPrize.setText(Integer.toString(subtotal));
        payTotalAmount.setText(Double.toString(grandtotal));


        ActivityResultLauncher<Intent>activityResultLauncher= registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        Intent data = result.getData();
                        int Result = result.getResultCode();


                            if (Result==RESULT_OK){
                                String Name = data.getStringExtra("name");
                                String No = data.getStringExtra("no");
                                String addres= data.getStringExtra("add");

                                txtxDetailName.setText(Name);
                                txtxDetailNumber.setText(No);
                                txtAddres.setText(addres);

                            }

                    }
                }
                );
        txtxDetails.setOnClickListener(new View.OnClickListener() {

            Intent intent= new Intent(billing_View.this, person_about.class);
            @Override
            public void onClick(View v) {

                activityResultLauncher.launch(intent);

            }
        });

        txtChange.setOnClickListener(new View.OnClickListener() {

            Intent intent= new Intent(billing_View.this, person_about.class);
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch(intent);

            }
        });

        btnFinal.setOnClickListener(new View.OnClickListener() {
            Intent intent= new Intent(billing_View.this,delivery_page.class);
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });

    }



}