package anhnht.Component;

import android.content.Intent;
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

    public void onClickAction(View view){
        if(view == btnLogin){
            String email = txtEmail.getText().toString().trim();
            String pass = txtPass.getText().toString().trim();
            if(email.isEmpty()){
                setErrorText(txtEmail);
                return;
            }else if(pass.isEmpty()){
                setErrorText(txtPass);
                return;
            }
            //Login function

            //If success return to main page with code RESULT_OK
                //setResult(RESULT_OK);
                // set bundle to return username
                //Bundle bundle = new Bundle();
                // bundle.putString("USERNAME", USERNAME_OF_DB);
    //            Intent intent = new Intent();
    //            intent.putExtras(bundle);
    //            setResult(Activity.RESULT_OK, intent);
    //            finish();
            //Else
                // txtEmail.setError
        }else if(view == txtRegister){
            Intent regist = new Intent(this, Register.class);
            startActivity(regist);
        }
    }

    private void init(){
        txtEmail = (EditText) findViewById(R.id.txtLogEmail);
        txtPass = (EditText) findViewById(R.id.txtLogPass);
        txtRegister = (TextView) findViewById(R.id.txtRegist);
        btnLogin = (Button) findViewById(R.id.btnLogIn);
        txtEmail.requestFocus();
    }

    private void setErrorText(EditText text){
        text.setError("This field can't be empty");
        text.requestFocus();
    }
}
