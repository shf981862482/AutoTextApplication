package sun.com.autotextapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟请求登陆接口
                handler.postDelayed(r, 1000);
            }
        });

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(r);
    }
}
