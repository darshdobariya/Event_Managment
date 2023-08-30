package com.example.javafinal.navigation.events;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javafinal.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Reminder extends AppCompatActivity {

    private Calendar calendar;
    ImageView btnTitle, btnDescription, btnNotification, btnUser, btnBack;
    TextView btnDate, btnOnce, btnYearly, btnInc, btnDec, btnTeam, btnContact, calcDate, textView14;
    String datas, enddates;
    EditText edtText, edtDescription;
    Date startDate;
    Date endDate;
    SwitchCompat repeatEvent;
    Context context;
    LinearLayout linearLayout10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        btnTitle = findViewById(R.id.ivTitle);
        btnDescription = findViewById(R.id.ivDiscription);
        btnNotification = findViewById(R.id.ivNotification);
        btnUser = findViewById(R.id.ivNewUser);
        btnDate = findViewById(R.id.tvDateSelect);
        btnOnce = findViewById(R.id.btnOnce);
        btnYearly = findViewById(R.id.btnYearly);
        btnInc = findViewById(R.id.btnIncrease);
        btnDec = findViewById(R.id.btnDecrease);
        btnTeam = findViewById(R.id.btnTeam);
        btnContact = findViewById(R.id.btnContact);
        calcDate = findViewById(R.id.calcDate);
        repeatEvent = findViewById(R.id.repetEvent);
        linearLayout10 = findViewById(R.id.linearLayout10);
        btnBack = findViewById(R.id.btnBack);
        textView14 = findViewById(R.id.textView14);

        btnBack.setOnClickListener(v->{
            finish();
        });

        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String formattedDate = dateFormat.format(calendar.getTime());

        btnTeam.setBackgroundResource(R.drawable.back_for_all);
        btnContact.setBackgroundResource(0);

        linearLayout10.setVisibility(View.GONE);
        textView14.setVisibility(View.GONE);
        btnOnce.setBackgroundResource(R.drawable.back_for_all);
        btnYearly.setBackgroundResource(0);

        // Set the date in the TextView
        btnDate.setText(formattedDate);
        enddates = formattedDate;

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        btnTeam.setOnClickListener(v->{
            btnTeam.setBackgroundResource(R.drawable.back_for_all);
            btnContact.setBackgroundResource(0);
        });

        btnContact.setOnClickListener(v->{
            btnContact.setBackgroundResource(R.drawable.back_for_all);
            btnTeam.setBackgroundResource(0);
        });

        btnUser.setOnClickListener(v->{
            Intent intent = new Intent(this, UserSelect.class);
            intent.putExtra("Title", "User");
            startActivity(intent);
        });

        btnDec.setOnClickListener(v->{
            try {
                decreaseDate();

                startDate = dateFormat1.parse(btnDate.getText().toString());  // Replace with your start date
                endDate = dateFormat1.parse(enddates.toString());    // Replace with your end date

                long diffInMillis = endDate.getTime() - startDate.getTime();
                long daysBetween = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

                calcDate.setText(daysBetween + " Days in Advance");
            }catch (ParseException e) {
                e.printStackTrace();}
        });

        btnInc.setOnClickListener(v->{
            try {
                increaseDate();

                startDate = dateFormat1.parse(btnDate.getText().toString());  // Replace with your start date
                endDate = dateFormat1.parse(enddates.toString());    // Replace with your end date

                long diffInMillis = endDate.getTime() - startDate.getTime();
                long daysBetween = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

                calcDate.setText(daysBetween + " Days in Advance");
            }catch (ParseException e) {
                e.printStackTrace();}

        });

        btnTitle.setOnClickListener(v->{
            SelectTitleDiscription("Edit Title");
        });

        btnDescription.setOnClickListener(v->{
            SelectTitleDiscription("Edit Description");
        });

        btnDate.setOnClickListener(v->{
            showDatePickerDialog();
        });

        btnYearly.setOnClickListener(v->{
            linearLayout10.setVisibility(v.VISIBLE);
            textView14.setVisibility(v.VISIBLE);
            btnYearly.setBackgroundResource(R.drawable.back_for_all);
            btnOnce.setBackgroundResource(0);
        });

        btnOnce.setOnClickListener(v->{
            linearLayout10.setVisibility(v.GONE);
            textView14.setVisibility(v.GONE);
            btnOnce.setBackgroundResource(R.drawable.back_for_all);
            btnYearly.setBackgroundResource(0);
        });

        repeatEvent.setOnClickListener(v->{
            if(repeatEvent.isChecked() == true){
                //
            }else{

            }
        });
    }

    public void SelectTitleDiscription(String input){
        Intent intent = new Intent(this, BottomSheet.class);
        intent.putExtra("Title", input);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                if (data != null){
                   datas =  data.getStringExtra("Edit Title");
                   if (datas.equals("Title")){
                       edtText.setText(data.getStringExtra("Text"));
                   }
                }
            }
        }
    }

    public void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                        String formattedDate = dateFormat.format(calendar.getTime());

                        btnDate.setText(formattedDate);
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }

    public void decreaseDate() {
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        updateDateTextView();
    }

    public void increaseDate() {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        updateDateTextView();
    }

    private void updateDateTextView() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String formattedDate = dateFormat.format(calendar.getTime());

        enddates = formattedDate;
    }
}