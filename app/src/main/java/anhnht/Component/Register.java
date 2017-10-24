package anhnht.Component;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.anhnh.sliderdemo.R;

import java.util.Calendar;
import java.util.Locale;

public class Register extends AppCompatActivity {

    private DatePickerDialog birthdayDialog;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    private EditText txtEmail, txtPass, txtDOB, txtCitizen;
    private Calendar dobCalendar;
    private Button btnRegist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Set click out side of activity to hide soft keyboard
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        };
        findViewById(R.id.activity_Regist).setOnClickListener(listener);
        //Init component
        initData();


    }

    private void initData() {
        txtCitizen = (EditText) findViewById(R.id.txtRegisCitizen);
        txtDOB = (EditText) findViewById(R.id.txtRegisDOB);
        txtEmail = (EditText) findViewById(R.id.txtRegisEmail);
        txtPass = (EditText) findViewById(R.id.txtRegisPass);
        btnRegist = (Button) findViewById(R.id.btnRegister);
        dobCalendar = Calendar.getInstance();
        txtDOB.setText(sdf.format(dobCalendar.getTime()));
        txtEmail.requestFocus();
        setDateDialog();
    }

    private void setDateDialog() {
        Calendar myCal = Calendar.getInstance();
        birthdayDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dobCalendar.set(year, month, dayOfMonth);
                txtDOB.setText(sdf.format(dobCalendar.getTime()));
            }
        }, myCal.get(Calendar.YEAR), myCal.get(Calendar.MONTH), myCal.get(Calendar.DAY_OF_MONTH));
    }

    public void myOnClick(View view) {
        if (view == txtDOB) {
            birthdayDialog.show();
        } else if (view == btnRegist) {
            String email = txtEmail.getText().toString().trim();
            String pass = txtPass.getText().toString().trim();
            String tmpCID = txtCitizen.getText().toString();
            if(email.isEmpty()){
                setErrorText(txtEmail);
                return;
            }else if(pass.isEmpty()){
                setErrorText(txtPass);
                return;
            }else if(tmpCID.isEmpty()){
                setErrorText(txtCitizen);
                return;
            }
            int CitizenID = Integer.parseInt(tmpCID);
            Long dob = dobCalendar.getTimeInMillis();
            //code of register
            //return to main activity
        }
    }

    private void setErrorText(EditText text){
        text.setError("This field can't be empty");
        text.requestFocus();
    }
}
