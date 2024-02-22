package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //android:id="@+id/ "로 지정한 id에 내용 가져오는 방법
    EditText editTextNum1;
    EditText editTextNum2;
    TextView textViewRs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1=findViewById(R.id.activity_main__editTextNum1);
        editTextNum2=findViewById(R.id.activity_main__editTextNum2);
        textViewRs=findViewById(R.id.activity_main__textViewRs);
    }

    public void btnAddClicked(View view) {
        if(checkNumberInputs() == false) {
            return;
        }



        //형변환
        int num1=Integer.parseInt(editTextNum1.getText().toString());
        int num2=Integer.parseInt(editTextNum2.getText().toString());



        int rs=num1+num2;
        //toastMsg("결과: " + rs);
        textViewRs.setText("결과: " + rs);

    }

    public boolean checkNumberInputs() {
        //양옆의 공백제거
        editTextNum1.setText(editTextNum1.getText().toString().trim());

        //입력 안될경우
        if(editTextNum1.getText().toString().length() == 0) {
            toastMsg("숫자1을 입력해주세요");
            //텍스트 입력 포커스
            editTextNum1.requestFocus();
            return false;
        }

        editTextNum2.setText(editTextNum2.getText().toString().trim());

        //입력 안될경우
        if(editTextNum2.getText().toString().length() == 0) {
            toastMsg("숫자2를 입력해주세요");
            //텍스트 입력 포커스
            editTextNum2.requestFocus();
            return false;
        }
        return true;
    }

    public void toastMsg(String msg) {//메시지 출력 잠깐 뜨고 사라짐
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }


    public void btnCrearClicked(View view) { //지우기 실행 메소드


        editTextNum1.setText("");
        editTextNum2.setText("");
        toastMsg("결과 초기화");
        textViewRs.setText("");

    }

    public void btnMinusClicked(View view) {
        if(checkNumberInputs() == false) {
            return;
        }

        //형변환
        int num1=Integer.parseInt(editTextNum1.getText().toString());
        int num2=Integer.parseInt(editTextNum2.getText().toString());



        int rs=num1-num2;
        //toastMsg("결과: " + rs);
        textViewRs.setText("결과: " + rs);

    }
}