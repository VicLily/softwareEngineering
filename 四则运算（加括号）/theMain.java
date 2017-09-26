package work2;

import java.util.*;
import net.sf.json.JSONObject;

public class theMain {
	HashMap<Integer, String> characterList;// 操作符
	HashMap<Integer, JSONObject> DataList;// 操作数
	int num,M=6;//num为操作符的个数   M为个数范围以及操作数范围
	double scoreS, score;

	public static void main(String[] args) {
		theMain a = new theMain();
		a.inputN();
	}

	public void inputN() {// 输入题目个数
		scoreS = 0;
		System.out.println("输入题目个数：");
		Scanner scan1 = new Scanner(System.in);
		int N = scan1.nextInt();
		score = 100 / N;
		System.out.println("满分100分！每题" + score + "分！");
		for (int i = 0; i < N; i++) {
			DataList = new HashMap<Integer, JSONObject>();
			characterList = new HashMap<Integer, String>();
			System.out.println("第" + (i + 1) + "题：");
			show();
		}
		System.out.println("总共得分：" + scoreS);
	}

	public void show() {
		num = (int) (1 + Math.random() * M);
		// savekuo();//存储括号
		saveCharacotr();// 将所有操作符存到character列表里面
		saveData();// 将所有操作数存到DataList里面
		compute com=new compute();
		String result1 = com.compute(characterList,DataList,num);
		//System.out.println("正确答案：" + result1);
		Scanner scan2 = new Scanner(System.in);
		String read = scan2.nextLine();
		if (result1.equals(read)) {
			System.out.println("回答正确!" + "正确答案：" + result1);
			scoreS = scoreS + score;
		} else
			System.out.println("回答错误!" + "正确答案：" + result1);

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
			n = (int) (Math.random() * (M+1));
			// System.out.println("分子随机"+i+":"+n);
			if (n == 0)
				m = 1;
			else {
				m = (int) (n + Math.random() * (M+1 - n));
				// System.out.println("分母随机"+i+":"+m);
			}

			data.put("mu", m);
			data.put("zi", n);
			DataList.put(i, data);
		}
	}

	/*public void showT() {
		int zi, mu, zi1, mu1;
		String c1;
		int i;
		for (i = 0; i < num; i++) {
			zi = DataList.get(i).getInt("zi");
			mu = DataList.get(i).getInt("mu");
			c1 = characterList.get(i);// 获取操作符
			zi1 = DataList.get(i + 1).getInt("zi");
			if ((c1.equals("÷")) && (zi1 == 0)) {
				JSONObject o = new JSONObject();
				zi1 = (int) (1 + Math.random() * (M-2));
				mu1 = (int) (zi1 + Math.random() * (M - zi1));
				o.put("zi", zi1);
				o.put("mu", mu1);
				DataList.put(i + 1, o);
			}
			System.out.print(zi + "/" + mu + c1);
		}
		mu = DataList.get(i).getInt("mu");
		zi = DataList.get(i).getInt("zi");
		System.out.print(zi + "/" + mu + "=");
	}
*/

}
