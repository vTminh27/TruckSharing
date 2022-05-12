package com.example.trucksharing.activity;

import static com.example.trucksharing.util.Util.USER_ID;

import com.example.trucksharing.data.DatabaseHelper;
import com.example.trucksharing.model.Order;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.trucksharing.R;
import com.example.trucksharing.fragment.CreateOrderFragment;
import com.example.trucksharing.util.Util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class NewOrderActivity extends AppCompatActivity {

    int userId = 0;
    DatabaseHelper database;
    private int mYear, mMonth, mDay, mHour, mMinute;

    EditText editTextReceiverName;
    EditText editTextPickupLocation;
    EditText editTextPickupDate;
    EditText editTextPickupTime;

    AppCompatButton buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        Intent intent = getIntent();
        userId = intent.getExtras().getInt(USER_ID);

        database = new DatabaseHelper(this);

        editTextReceiverName = findViewById(R.id.editTextNewOrderReceiverName);
        editTextPickupLocation = findViewById(R.id.editTextNewOrderPickupLocation);

        editTextPickupDate = findViewById(R.id.editTextNewOrderPickupDate);
        editTextPickupDate.setInputType(InputType.TYPE_NULL);
        editTextPickupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 showDateDialog();
            }
        });
        editTextPickupDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDateDialog();
                }
            }
        });

        editTextPickupTime = findViewById(R.id.editTextNewOrderPickupTime);
        editTextPickupTime.setInputType(InputType.TYPE_NULL);
        editTextPickupTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
        editTextPickupTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showTimeDialog();
                }
            }
        });

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        buttonNext = findViewById(R.id.buttonNewOrderNext);
        buttonNext.setVisibility(View.VISIBLE);
    }

    public void showDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        editTextPickupDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void showTimeDialog() {
        final Calendar calendar = Calendar.getInstance();
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        editTextPickupTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void nextClick(View view) {

        String name = editTextReceiverName.getText().toString().trim();
        String date = editTextPickupDate.getText().toString().trim();
        String time = editTextPickupTime.getText().toString().trim();
        String location = editTextPickupLocation.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(date) || TextUtils.isEmpty(time) || TextUtils.isEmpty(location)) {
            AlertDialog alertDialog = new AlertDialog.Builder(NewOrderActivity.this).create();
            alertDialog.setTitle("");
            alertDialog.setMessage("Please enter enough information!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        } else {

            buttonNext.setVisibility(View.GONE);

            Fragment fragment = CreateOrderFragment.newInstance(userId, name, date, time, location);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, fragment).addToBackStack(null).commit();
        }
    }

    public void showOrderListScreen() {
        Intent orderIntent = new Intent(NewOrderActivity.this, OrdersActivity.class);
        orderIntent.putExtra(USER_ID, userId);
        startActivity(orderIntent);
    }

    public void createNewOrder(Order order) {
        long orderId = database.insertOrder(order);
        if (orderId >= 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Congratulations!");
            builder.setMessage("You have created a new order successfully");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent ordersIntent = new Intent(NewOrderActivity.this, OrdersActivity.class);
                    ordersIntent.putExtra(Util.USER_ID, userId);
                    startActivity(ordersIntent);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(NewOrderActivity.this).create();
            alertDialog.setTitle("Oops!");
            alertDialog.setMessage("Order is not created. Please try later.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}