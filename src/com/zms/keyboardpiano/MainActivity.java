package com.zms.keyboardpiano;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;

import com.my.entity.Songs;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP,
			btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL, btnZ, btnX,
			btnC, btnV, btnB, btnN, btnM;
	private TextView tv;
	private int wordcount;
	private Map<Integer, Integer> souMap;
	private SoundPool spool;
	private Spinner sp;
	private AlertDialog ad;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		findID();// 绑定控件。
		music();// 声音初始化
		setListenter();// 绑定事件源。
		SpannableString word = new SpannableString(
				"The quick fox jumps over the lazy dog");
		SpannableStringBuilder multiWord = new SpannableStringBuilder();
		multiWord.append("The Quick Fox");
		multiWord.append("jumps over");
		multiWord.append("the lazy dog");

		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View arg1,
					int position, long arg3) {

				String str = parent.getItemAtPosition(position).toString();

				if (str.equals("月亮代表我的心")) {
					tv.setText("LOQSONQS STUVTS QPOOO QPOOO PQPOMPQP LOQSONQS STUVTS QPOOO QPOOO PQPMNOPO QSQPOSN MNMNMLQ SQPOSN MNOOOPQP LOQSONQS STUVTS QPOOO QPOOO PQPMNOPO");

				} else if (str.equals("北京欢迎你")) {
					tv.setText("POMOPQSPQTSSPO POMOPQSPQTSSQ PQPOSTQMQPPO QSVSTTS QQ SS QS TV WV SQ P S Q Q QS VS TV WV SQ SVT QP QS XW VV");
				} else if (str.equals("生日快乐")) {
					tv.setText("EEFEHG EEFEIHC EELJHGF KKJHIC");
				} else if (str.equals("小星星")) {
					tv.setText("");
				}
				Toast.makeText(MainActivity.this, "你点击的是:" + str, 2000).show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

	private void music() {

		// 该MAP集合用来保存所有的音乐播放资源
		souMap = new HashMap<Integer, Integer>();
		// 实例化后台播放池
		spool = new SoundPool(7, AudioManager.STREAM_MUSIC, 100);

		// 将所有的OGG音调文件加载到spool中,并将加载的顺序与soundMap的KEY对应

		souMap.put(0, spool.load(MainActivity.this, R.raw.sound01, 1));
		souMap.put(1, spool.load(MainActivity.this, R.raw.sound02, 1));
		souMap.put(2, spool.load(MainActivity.this, R.raw.sound03, 1));
		souMap.put(3, spool.load(MainActivity.this, R.raw.sound04, 1));
		souMap.put(4, spool.load(MainActivity.this, R.raw.sound05, 1));
		souMap.put(5, spool.load(MainActivity.this, R.raw.sound06, 1));
		souMap.put(6, spool.load(MainActivity.this, R.raw.sound07, 1));
		souMap.put(7, spool.load(MainActivity.this, R.raw.sound08, 1));
		souMap.put(8, spool.load(MainActivity.this, R.raw.sound09, 1));
		souMap.put(9, spool.load(MainActivity.this, R.raw.sound10, 1));
		souMap.put(10, spool.load(MainActivity.this, R.raw.sound11, 1));
		souMap.put(11, spool.load(MainActivity.this, R.raw.sound12, 1));
		souMap.put(12, spool.load(MainActivity.this, R.raw.sound13, 1));
		souMap.put(13, spool.load(MainActivity.this, R.raw.sound14, 1));
		souMap.put(14, spool.load(MainActivity.this, R.raw.sound15, 1));
		souMap.put(15, spool.load(MainActivity.this, R.raw.sound16, 1));
		souMap.put(16, spool.load(MainActivity.this, R.raw.sound17, 1));
		souMap.put(17, spool.load(MainActivity.this, R.raw.sound18, 1));
		souMap.put(18, spool.load(MainActivity.this, R.raw.sound19, 1));
		souMap.put(19, spool.load(MainActivity.this, R.raw.sound20, 1));
		souMap.put(20, spool.load(MainActivity.this, R.raw.sound21, 1));
		souMap.put(21, spool.load(MainActivity.this, R.raw.sound22, 1));
		souMap.put(22, spool.load(MainActivity.this, R.raw.sound23, 1));
		souMap.put(23, spool.load(MainActivity.this, R.raw.sound24, 1));
		souMap.put(24, spool.load(MainActivity.this, R.raw.sound25, 1));
		souMap.put(25, spool.load(MainActivity.this, R.raw.sound26, 1));
		souMap.put(26, spool.load(MainActivity.this, R.raw.sound27, 1));

	}

	private void findID() {

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

		sp = (Spinner) findViewById(R.id.song);
		String[] mItems = getResources().getStringArray(R.array.songs);
		tv = (TextView) findViewById(R.id.tv);
	}

	private void setListenter() {

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

	private class MyListenter implements OnClickListener {

		public void onClick(View v) {
			Button btn = (Button) v;
			String str1;
			int start = 0, end = 1;

			Toast.makeText(MainActivity.this, btn.getText(), Toast.LENGTH_SHORT)
					.show();
			btn.setTextColor(Color.RED);
			int index = btn.getText().charAt(0) - 65;
			int sid = souMap.get(index);
			spool.play(sid, 0.8f, 0.8f, 1, 0, 1f);
			btn.setTextColor(Color.BLACK);

			str1 = tv.getText().toString();
			if (str1.startsWith(" ")) {
				str1 = str1.substring(1);
			}
			// SpannableStringBuilder style = new SpannableStringBuilder(str1);
			// style.setSpan(new
			// BackgroundColorSpan(Color.RED),start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			// String str2;
			// str2 = style.toString();
			if (btn.getText().equals(str1.substring(0, 1))) {
				tv.setText(str1.substring(1));
				if (str1.length() == 1) {
					Toast.makeText(MainActivity.this, "恭喜你完成此歌曲，请重新选择", 2000)
							.show();
				}
				System.out.println(str1);
			}

		}

	}

}
