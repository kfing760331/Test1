package com.huang.faceguess;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FaceGuessActivity extends Activity {
	private Button start;
	private ImageView iv;
	private int randnum;
	private int imgR[];
	private int randimg[];
	private Activity main;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_guess);
        main = this;
        setTitle("esd");
        setTitle("");
        setTitle("123");
        setTitle("4565");
        setTitle("4565");
        setTitle("4565");
        setTitle("4565");
        setTitle("4565");
        

        setTitle("123");
        //imageview Resources
        imgR = new int[]{R.id.imageView1,R.id.imageView2,R.id.imageView3};
        
        //start Button 取得Resources實體
        start = (Button) this.findViewById(R.id.button1);
        
        //start Button 監聽----------------------------------------
        start.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				start.setVisibility(View.INVISIBLE);//按下設定看不見
				start.setText(R.string.guess_again);//設定文字[重新開始]
				//初始化imageview-----------------------------
				for(int i = 0;i < imgR.length;i++){
					iv = (ImageView) findViewById(imgR[i]);
					iv.setImageResource(R.drawable.face);
				}
				//初始化imageview-----------------------------
				startinit();
			}
		});
        //start Button 監聽----------------------------------------
    }
    private void startinit(){
    	//初始化使用的數值-------------------------
    	randimg = new int[imgR.length];
        Arrays.fill(randimg,R.drawable.joker);
        randnum = new Random().nextInt(3);
		randimg[randnum] = R.drawable.ace2;
		//初始化使用的數值--------------------------
		
		//取得imageview 實體 以及 監聽事件
    	for(int i = 0;i < imgR.length;i++){
    		final int j = i;
	    	iv = (ImageView) findViewById(imgR[i]);
	        
	        iv.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					
					//按到的View轉型成ImageView 設定圖片
					((ImageView)v).setImageResource(randimg[j]);
					//判斷按到的是不是剛剛亂數的圖
					if(randimg[j] == randimg[randnum]){
						//建立一個警示訊息視窗--------------------------------------------------
						Builder builder = new Builder(main);
						builder.setMessage(getResources().getString(R.string.guess_yes));
						builder.setCancelable(false);//是否可以關掉按下[返回鍵]取消視窗功能
						AlertDialog ad= builder.create();
						ad.setCanceledOnTouchOutside(true);//設定警示視窗是否可以按下外面視窗
						ad.show();
						//建立一個警示訊息視窗--------------------------------------------------
						
						start.setText(R.string.guess_again);
						start.setVisibility(View.VISIBLE);
					}
					else
					{
						
						Toast.makeText(main, getResources().getString(R.string.guess_no), Toast.LENGTH_SHORT).show();
					}
						
				}
			});
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_face_guess, menu);
        return true;
    }
}
