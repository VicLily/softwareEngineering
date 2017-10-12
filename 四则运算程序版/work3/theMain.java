package work3;

import java.util.*;
import net.sf.json.JSONObject;

public class theMain {
	HashMap<Integer, String> characterList;// 操作符
	HashMap<Integer, JSONObject> DataList;// 操作数
	public static int N,scoreS,score;
	int num, M = 5;// num为操作符的个数 M为个数范围以及操作数范围
	public static StringBuffer s;
	 public static String result1;
	String result2;
	public theMain() {
		inputN();
	}

	public void inputN() {
		new outputResult();
		DataList = new HashMap<Integer, JSONObject>();
		characterList = new HashMap<Integer, String>();
		showT();
	}

	public void showT() {
		num = (int) (1 + Math.random() * M);
		saveCharacotr();// 将所有操作符存到character列表里面
		saveData();// 将所有操作数存到DataList里面
		compute com = new compute();
		result1 = com.compute(characterList, DataList, num);
		String str=s.toString();
		outputResult.jTextArea.setText(str);//将题目显示出来
	}

	private void saveCharacotr() {
		int m;// m 随机生成数 表示操作符的类型； p为括号对数
		String c = null;
		for (int i = 0; i < num; i++) {
			m = (int) (1 + Math.random() * 4);
			// System.out.println("操作符随机数"+i+":"+m);
			switch (m) {
			case 1:
				c = "+";
				break;
			case 2:
				c = "-";
				break;
			case 3:
				c = "*";
				break;
			case 4:
				c = "÷";
				break;
			}
			// System.out.println("操作符"+i+":"+c);
			characterList.put(i, c);
		}
	}

	public void saveData() {
		int n, m;// n为分子，m为分母
		JSONObject data;
		for (int i = 0; i < num + 1; i++) {// 将所有操作数存到DataList里面
			data = new JSONObject();
			n = (int) (Math.random() * M);
			// 0~ M-1
			if (n == 0)
				m = 1;
			else {
				m = (int) ((n + 1) + Math.random() * (M - n));
				// n+1 ~m
			}

			data.put("mu", m);
			data.put("zi", n);
			DataList.put(i, data);
		}
	}

}
