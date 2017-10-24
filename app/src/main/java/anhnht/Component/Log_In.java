package anhnht.Component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anhnh.sliderdemo.R;

public class Log_In extends AppCompatActivity {

    private EditText txtEmail, txtPass;
    private Button btnLogin;
    private TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        init();
    }

    private void onClick(View view){
        if(view == btnLogin){
            String email = txtEmail.getText().toString().trim();
            String pass = txtPass.getText().toString().trim();
            //Login function

            //If success return to main page with code RESULT_OK
                //setResult(RESULT_OK);
                //finish();
            //Else
                // txtEmail.setError
        }else if(view == txtRegister){
            //New intent of regist page
        }
    }

    private void init(){
        txtEmail = (EditText) findViewById(R.id.txtLogEmail);
        txtPass = (EditText) findViewById(R.id.txtLogPass);
        txtRegister = (TextView) findViewById(R.id.txtRegist);
        btnLogin = (Button) findViewById(R.id.btnLogIn);
    }
}
