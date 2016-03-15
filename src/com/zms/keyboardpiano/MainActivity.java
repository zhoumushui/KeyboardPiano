package com.zms.keyboardpiano;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP,
			btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL, btnZ, btnX,
			btnC, btnV, btnB, btnN, btnM;
	private TextView textHint;
	private Map<Integer, Integer> mapSound;
	private SoundPool soundPool;
	private Spinner spinnerSong;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initialLayout();

		initialSound();
		SpannableString word = new SpannableString(
				"The quick fox jumps over the lazy dog");
		SpannableStringBuilder multiWord = new SpannableStringBuilder();
		multiWord.append("The Quick Fox");
		multiWord.append("jumps over");
		multiWord.append("the lazy dog");

		spinnerSong.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {

				String str = parent.getItemAtPosition(position).toString();

				if (str.equals("月亮代表我的心")) {
					textHint.setText("LOQSONQS STUVTS QPOOO QPOOO PQPOMPQP LOQSONQS STUVTS QPOOO QPOOO PQPMNOPO QSQPOSN MNMNMLQ SQPOSN MNOOOPQP LOQSONQS STUVTS QPOOO QPOOO PQPMNOPO");

				} else if (str.equals("北京欢迎你")) {
					textHint.setText("POMOPQSPQTSSPO POMOPQSPQTSSQ PQPOSTQMQPPO QSVSTTS QQ SS QS TV WV SQ P S Q Q QS VS TV WV SQ SVT QP QS XW VV");
				} else if (str.equals("生日快乐")) {
					textHint.setText("EEFEHG EEFEIHC EELJHGF KKJHIC");
				} else if (str.equals("小星星")) {
					textHint.setText("");
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

	private void initialLayout() {
		btnQ = (Button) findViewById(R.id.btnQ);
		btnW = (Button) findViewById(R.id.btnW);
		btnE = (Button) findViewById(R.id.btnE);
		btnR = (Button) findViewById(R.id.btnR);
		btnT = (Button) findViewById(R.id.btnT);
		btnY = (Button) findViewById(R.id.btnY);
		btnU = (Button) findViewById(R.id.btnU);
		btnI = (Button) findViewById(R.id.btnI);
		btnO = (Button) findViewById(R.id.btnO);
		btnP = (Button) findViewById(R.id.btnP);

		btnA = (Button) findViewById(R.id.btnA);
		btnS = (Button) findViewById(R.id.btnS);
		btnD = (Button) findViewById(R.id.btnD);
		btnF = (Button) findViewById(R.id.btnF);
		btnG = (Button) findViewById(R.id.btnG);
		btnH = (Button) findViewById(R.id.btnH);
		btnJ = (Button) findViewById(R.id.btnJ);
		btnK = (Button) findViewById(R.id.btnK);
		btnL = (Button) findViewById(R.id.btnL);

		btnZ = (Button) findViewById(R.id.btnZ);
		btnX = (Button) findViewById(R.id.btnX);
		btnC = (Button) findViewById(R.id.btnC);
		btnV = (Button) findViewById(R.id.btnV);
		btnB = (Button) findViewById(R.id.btnB);
		btnN = (Button) findViewById(R.id.btnN);
		btnM = (Button) findViewById(R.id.btnM);

		spinnerSong = (Spinner) findViewById(R.id.spinnerSong);
		String[] mItems = getResources().getStringArray(R.array.songs);
		textHint = (TextView) findViewById(R.id.textHint);

		btnQ.setOnClickListener(new MyListenter());
		btnW.setOnClickListener(new MyListenter());
		btnE.setOnClickListener(new MyListenter());
		btnR.setOnClickListener(new MyListenter());
		btnT.setOnClickListener(new MyListenter());
		btnY.setOnClickListener(new MyListenter());
		btnU.setOnClickListener(new MyListenter());
		btnI.setOnClickListener(new MyListenter());
		btnO.setOnClickListener(new MyListenter());
		btnP.setOnClickListener(new MyListenter());

		btnA.setOnClickListener(new MyListenter());
		btnS.setOnClickListener(new MyListenter());
		btnD.setOnClickListener(new MyListenter());
		btnF.setOnClickListener(new MyListenter());
		btnG.setOnClickListener(new MyListenter());
		btnH.setOnClickListener(new MyListenter());
		btnJ.setOnClickListener(new MyListenter());
		btnK.setOnClickListener(new MyListenter());
		btnL.setOnClickListener(new MyListenter());

		btnZ.setOnClickListener(new MyListenter());
		btnX.setOnClickListener(new MyListenter());
		btnC.setOnClickListener(new MyListenter());
		btnV.setOnClickListener(new MyListenter());
		btnB.setOnClickListener(new MyListenter());
		btnN.setOnClickListener(new MyListenter());
		btnM.setOnClickListener(new MyListenter());

		// sp.setOnItemSelectedListener(new SpinnerListener());
	}

	/** 声音初始化 */
	private void initialSound() {
		mapSound = new HashMap<Integer, Integer>(); // 该MAP集合用来保存所有的音乐播放资源
		soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 30); // 实例化后台播放池

		// 将所有的OGG音调文件加载到soundPool中,并将加载的顺序与soundMap的KEY对应
		for (int i = 0; i < 27; i++) {
			int resId;
			if (i < 9) {
				resId = getResources().getIdentifier("sound0" + (i + 1), "raw",
						getPackageName());
			} else {
				resId = getResources().getIdentifier("sound" + (i + 1), "raw",
						getPackageName());
			}
			mapSound.put(i, soundPool.load(MainActivity.this, resId, 1));
		}

	}

	private class MyListenter implements OnClickListener {

		public void onClick(View v) {
			Button btn = (Button) v;
			String str1;
			Toast.makeText(MainActivity.this, btn.getText(), Toast.LENGTH_SHORT)
					.show();
			btn.setTextColor(Color.RED);
			int index = btn.getText().charAt(0) - 65;
			int sid = mapSound.get(index);
			soundPool.play(sid, 0.8f, 0.8f, 1, 0, 1f);
			btn.setTextColor(Color.BLACK);

			str1 = textHint.getText().toString();
			if (str1.startsWith(" ")) { // 间隔
				str1 = str1.substring(1);
			}
			// SpannableStringBuilder style = new SpannableStringBuilder(str1);
			// style.setSpan(new
			// BackgroundColorSpan(Color.RED),start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			// String str2;
			// str2 = style.toString();
			if (btn.getText().equals(str1.substring(0, 1))) {
				textHint.setText(str1.substring(1));
				if (str1.length() == 1) {
					Toast.makeText(MainActivity.this, "恭喜你完成此歌曲，请重新选择", 2000)
							.show();
				}
			}

		}

	}

}
