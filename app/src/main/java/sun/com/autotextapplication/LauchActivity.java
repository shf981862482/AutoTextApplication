package sun.com.autotextapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LauchActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);
        ////模拟初始化
        handler.postDelayed(r, 1000);

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(LauchActivity.this, LoginActivity.class));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(r);
    }
}
