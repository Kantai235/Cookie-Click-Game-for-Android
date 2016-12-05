package cca.ksu.edu.tw.cookie_click_game_for_android;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;

public class MainActivity extends AppCompatActivity {

    int coinCount = 1;
    int autoLevel = 1;
    int clickLevel = 1;

    final double autoMul = 3.3;
    final double clickMul = 2.2;

    final int resetCoinTime = 1000;
    final int resetViewTime = 10;

    Handler handler;
    TextView coinCountTextView;
    BootstrapButton autoUpClickButton, defuUpClickButton, coinClickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();

        handler.postDelayed(resetCoin, resetCoinTime);
        handler.postDelayed(resetView, resetViewTime);
    }

    private void init() {
        this.coinCountTextView = (TextView) findViewById(R.id.textView);
        this.autoUpClickButton = (BootstrapButton) findViewById(R.id.autoUpClick);
        this.defuUpClickButton = (BootstrapButton) findViewById(R.id.defuUpClick);
        this.coinClickButton = (BootstrapButton) findViewById(R.id.coinClick);
        this.handler = new Handler();
    }

    private Runnable resetCoin = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(resetCoin, resetCoinTime);
            coinCount += autoLevel;
        }
    };

    private Runnable resetView = new Runnable() {
        @Override
        public void run() {
            coinCountTextView.setText("Coin = " + coinCount);
            autoUpClickButton.setText("升級自動點擊\n目前等級 " + autoLevel + "\n耗費 " + (int) (autoLevel * autoMul));
            defuUpClickButton.setText("升級手動點擊\n目前等級 " + clickLevel + "\n耗費 " + (int) (clickLevel * clickMul));
            coinClickButton.setText("點我 + " + clickLevel);

            if ((autoLevel * autoMul) <= coinCount)
                autoUpClickButton.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
            else
                autoUpClickButton.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);

            if ((clickLevel * clickMul) <= coinCount)
                defuUpClickButton.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
            else
                defuUpClickButton.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);

            handler.postDelayed(resetView, resetViewTime);
        }
    };

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.autoUpClick:
                if ((autoLevel * autoMul) <= coinCount)
                    coinCount -= (++autoLevel * autoMul);
                else
                    Toast.makeText(MainActivity.this, "你的 Coin 不夠啊！", Toast.LENGTH_LONG).show();
                break;
            case R.id.defuUpClick:
                if ((clickLevel * clickMul) <= coinCount)
                    coinCount -= (++clickLevel * clickMul);
                else
                    Toast.makeText(MainActivity.this, "你的 Coin 不夠啊！", Toast.LENGTH_LONG).show();
                break;
            case R.id.coinClick:
                coinCount += clickLevel;
                break;
        }
    }
}