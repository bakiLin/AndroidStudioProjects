package ru.mirea.bakiev.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread {
    public Handler mHandler;
    private Handler mainHandler;
    public MyLooper(Handler mainThreadHandler) {
        mainHandler = mainThreadHandler;
    }

    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();   //Создание цикла
        mHandler = new Handler(Looper.myLooper()) { //Получение и отправка данных
            public void handleMessage(Message msg) {
                String data = msg.getData().getString("KEY");
                Integer age = msg.getData().getInt("AGE");
                Log.d("MyLooper get message: ", data);

                int count = data.length();
                Message	message	= new Message();
                Bundle bundle = new	Bundle();

                bundle.putString("result", String.format("The number of	letters	in the word	%s is %d ", data, count));
                message.setData(bundle);

                mainHandler.postDelayed(() -> {
                    mainHandler.sendMessage(message);
                    }, age);
            }
        };

        Looper.loop(); //Запуск цикла
    }
}
