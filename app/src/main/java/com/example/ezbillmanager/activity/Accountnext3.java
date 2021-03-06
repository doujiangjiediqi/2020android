package com.example.ezbillmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezbillmanager.R;
import com.example.ezbillmanager.utils.BillInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Accountnext3 extends AppCompatActivity{

    private Button btn_return;
    private Button btn_save;
    private Button btn_account_expend;
    private Button btn_account_income;
    private EditText et_money;
    private TextView textview_classify;
    private TextView textView_class;
    private boolean inorout = true;//true为支出栏，false为收入栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountnext3);

        btn_return = findViewById(R.id.btn_return);
        //textView_class = findViewById(R.id.btn_class);
        textview_classify=findViewById(R.id.textview_classify);
        btn_save = findViewById(R.id.btn_save);
        et_money = findViewById(R.id.et_money);
        btn_account_expend = findViewById(R.id.btn_account_expend);
        btn_account_income = findViewById(R.id.btn_account_income);

        /*Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("int");
        if(data=="1") textView_class.setText("衣");*/

        /*Intent data = getIntent();
        String string1 = (String) data.getSerializableExtra("int");
        if(string1=="1")textView_class.setText("YI");
        if(string1=="1")textview_classify.setText("yi");*/
        //返回键：返回主页
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accountnext3.this, home_page.class);
                startActivity(intent);
            }
        });





        //分类栏进入项目分类页面label
        /*btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this, newlabel.class);
                startActivity(intent);
                *//*Intent intent1 = getIntent();
                String string = (String) intent1.getSerializableExtra("int");
                if(string=="1")
                    textview_classify.setText("衣");*//*


            }
        });*/

        //收入栏
        btn_account_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inorout = false;
                btn_account_income.setBackgroundColor(Color.parseColor("#ffffff"));
                btn_account_expend.setBackgroundColor(Color.parseColor("#ececec"));
            }
        });

        //支出栏
        btn_account_expend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inorout = true;
                btn_account_expend.setBackgroundColor(Color.parseColor("#ffffff"));
                btn_account_income.setBackgroundColor(Color.parseColor("#ececec"));
            }
        });

        //保存键：数据存储；并返回主页home_page
        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                BillInfo billInfo = null;
                String string = et_money.getText().toString();
                int t = Integer.parseInt(string);

                SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String str = formatter.format(curDate);


                int back = NetManager.getInstance().addBill(82374832,"str","住",t);
                if(back==1){
                    Intent intent = new Intent(Accountnext3.this, home_page.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Accountnext3.this, home_page.class);
                    startActivity(intent);
                }
            }
        });
    }
}
