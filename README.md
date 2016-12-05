# Cookie Click Game 餅乾點擊遊戲
這是一份 Android 系列課程的專案實作 範例程式碼<br />
詳細解說(投影片 PPT)請至 : https://github.com/Kantai235/Android-Tutorial<br />
對課堂有興趣？寄信找乾太。

![Main](/images/image1.PNG "Main")

# Tosat 方法
```Java
// Context context = 請定義對話視窗出現的畫面 ( Activity )
// CharSequence text = 要輸出的文字
// int duration = 吐司訊息顯示的時間
Toast.makeText(Context context, CharSequence text, int duration).show();
```

# Button Click 點擊事件
```Java
Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Code ...
    }
});
```

# Button Long Click 點擊事件
```Java
Button button = (Button) findViewById(R.id.button);
button.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        // Code ...
        // return false 的原因可參考 https://read01.com/7Reyn.html
        return false;
    }
});
```

# onClick 透過 view.getId() 來判斷按鈕的方法
```Java
public void buttonClick(View view) {
    switch (view.getId()) {
        case R.id.button1:
            Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            break;
        case R.id.button2:
            Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show(); 
            break;
        case R.id.button3:
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
            break;
    }
}
```

# Handler 多執行緒
```Java
Handler handler = new Handler();
handler.postDelayed(Runnable runnable, int Time);

// ...

private Runnable runTimerStop = new Runnable() {
    @Override
    public void run() {
        // Code ...
    }
};
```