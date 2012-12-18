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
        
        //start Button ���oResources����
        start = (Button) this.findViewById(R.id.button1);
        
        //start Button ��ť----------------------------------------
        start.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				start.setVisibility(View.INVISIBLE);//���U�]�w�ݤ���
				start.setText(R.string.guess_again);//�]�w��r[���s�}�l]
				//��l��imageview-----------------------------
				for(int i = 0;i < imgR.length;i++){
					iv = (ImageView) findViewById(imgR[i]);
					iv.setImageResource(R.drawable.face);
				}
				//��l��imageview-----------------------------
				startinit();
			}
		});
        //start Button ��ť----------------------------------------
    }
    private void startinit(){
    	//��l�ƨϥΪ��ƭ�-------------------------
    	randimg = new int[imgR.length];
        Arrays.fill(randimg,R.drawable.joker);
        randnum = new Random().nextInt(3);
		randimg[randnum] = R.drawable.ace2;
		//��l�ƨϥΪ��ƭ�--------------------------
		
		//���oimageview ���� �H�� ��ť�ƥ�
    	for(int i = 0;i < imgR.length;i++){
    		final int j = i;
	    	iv = (ImageView) findViewById(imgR[i]);
	        
	        iv.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					
					//���쪺View�૬��ImageView �]�w�Ϥ�
					((ImageView)v).setImageResource(randimg[j]);
					//�P�_���쪺�O���O���üƪ���
					if(randimg[j] == randimg[randnum]){
						//�إߤ@��ĵ�ܰT������--------------------------------------------------
						Builder builder = new Builder(main);
						builder.setMessage(getResources().getString(R.string.guess_yes));
						builder.setCancelable(false);//�O�_�i�H�������U[��^��]���������\��
						AlertDialog ad= builder.create();
						ad.setCanceledOnTouchOutside(true);//�]�wĵ�ܵ����O�_�i�H���U�~������
						ad.show();
						//�إߤ@��ĵ�ܰT������--------------------------------------------------
						
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
