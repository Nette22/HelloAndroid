package com.example.helloandroid;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloAndroid extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);  
        
        Button btn1 = (Button)findViewById(R.id.btnHello);
        btn1.setOnClickListener(this);        
    }
    
    public void onClick(View v) {
    	String ns = Context.NOTIFICATION_SERVICE;
    	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
    	
    	int icon = R.drawable.icon;
    	CharSequence tickerText = "Hello";
    	long when = System.currentTimeMillis();

    	Notification notification = new Notification(icon, tickerText, when);
    	
    	Context context = getApplicationContext();
    	CharSequence contentTitle = "My notification";
    	CharSequence contentText = "Hello World!";
    	Intent notificationIntent = new Intent(this, HelloAndroid.class);
    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent); 
    	mNotificationManager.notify(1, notification);
    }
}