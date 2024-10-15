package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0,btn1,btn2,btn3,btn4,
            btn5,btn6,btn7,btn8,btn9,btnCE,btnC,btnplus,btnminus
            ,btnequal,btndiv,btnx,btnBS,btnidk,btndot;
    TextView textView,textAnswer;
    String str,idl;
    private int wah,hah;
    private String check = "OK";
    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.main);
        connectView();
    }

    private void connectView() {
        textView = (TextView)findViewById(R.id.Textmain);
        textAnswer = (TextView)findViewById(R.id.textAnswer);
        textAnswer.setText("");
        textView.setText("");
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);

        btndot = (Button)findViewById(R.id.btndot);
        btndiv = (Button)findViewById(R.id.btndiv);
        btnminus = (Button)findViewById(R.id.btnminus);
        btnx = (Button)findViewById(R.id.btnx);
        btnplus = (Button)findViewById(R.id.btnplus);
        btnC = (Button)findViewById(R.id.btnC);
        btnCE = (Button)findViewById(R.id.btnCE);
        btnBS = (Button)findViewById(R.id.btnBS);
        btnidk = (Button)findViewById(R.id.btn_idk);
        btnequal = (Button)findViewById(R.id.btnequal);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnx.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnidk.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btnequal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        idl = textAnswer.getText().toString();
        if(idl.length() > 0 && wah == 1) wah = 2;
        if(wah == 2 ){
            wah = 0;
            textView.setText("");
        }

        str = textView.getText().toString();
        int id = v.getId();
        if (id == R.id.btn0){
            str = str + "0";
            textView.setText(str);
        }else if (id == R.id.btn1) {
            str = str + "1";
            textView.setText(str);
        }else if (id == R.id.btn2) {
            str = str + "2";
            textView.setText(str);
        }else if (id == R.id.btn3) {
            str = str + "3";
            textView.setText(str);
        }else if (id == R.id.btn4) {
            str = str + "4";
            textView.setText(str);
        }else if (id == R.id.btn5) {
            str = str + "5";
            textView.setText(str);
        }else if (id == R.id.btn6) {
            str = str + "6";
            textView.setText(str);
        }else if (id == R.id.btn7) {
            str = str + "7";
            textView.setText(str);
        }else if (id == R.id.btn8) {
            str = str + "8";
            textView.setText(str);
        }else if (id == R.id.btn9) {
            str = str + "9";
            textView.setText(str);
        }else if (id == R.id.btnCE) {
            textView.setText("0");
            textAnswer.setText("");
        }else if (id == R.id.btnC) {
            if (str.length() > 1) {
                idl = str.substring(0, str.length()-1);
            } else {idl = "0";}
            textView.setText(idl);
        }else if(id == R.id.btnplus){
            str = str + "+";
            textView.setText(str);
        }else if(id == R.id.btnminus){
            str = str + "-";
            textView.setText(str);
        }else if(id == R.id.btnx){
            str = str + "*";
            textView.setText(str);
        }else if(id == R.id.btndiv){
            str = str+ "/";
            textView.setText(str);
        }else if(id == R.id.btndot){
            str = str + ".";
            textView.setText(str);
        }else if(id == R.id.btnequal){
            double answer = evaluateExpression(str);
            String av = String.valueOf(answer);
            if (check.equals("OK")) {
                if (av.length() > 13) {
                    textAnswer.setText(av.substring(0, 13));  // Lấy tối đa 13 ký tự nếu có đủ
                } else {
                    textAnswer.setText(av);  // Hiển thị toàn bộ kết quả nếu ít hơn 13 ký tự
                }
            }
            wah = 1;
        } else if(id == R.id.btn_idk){
                if(idl.length()>0) {
                    String newidl = "-"+idl;
                    textView.setText(newidl);
                    double ids = -Double.parseDouble(idl);
                    textAnswer.setText(String.valueOf(ids));
                }
        }else{

        }
    }


    public double evaluateExpression(String expression) {
        if(!expression.isEmpty() && !check.equals("ERROR")){
            expression = expression.replaceAll("\\s","");
            // Kiểm tra và xử lý cộng, trừ, nhân, chia
            if (expression.contains("+")) {
                String[] parts = expression.split("\\+");
                return evaluateExpression(parts[0]) + evaluateExpression(parts[1]);
            } else if (expression.contains("-")) {
                String[] parts = expression.split("-");
                return evaluateExpression(parts[0]) - evaluateExpression(parts[1]);
            } else if (expression.contains("*")) {
                String[] parts = expression.split("\\*");
                return evaluateExpression(parts[0]) * evaluateExpression(parts[1]);
            } else if (expression.contains("/")) {
                String[] parts = expression.split("/");
                return evaluateExpression(parts[0]) / evaluateExpression(parts[1]);
            } else {
                // Trả về số thực khi không còn toán tử
                return Double.parseDouble(expression);
            }
        }else {
            textAnswer.setText("ERROR");
            return 0;
        }

    }

}
