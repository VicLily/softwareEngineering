package work3;

import net.sf.json.JSONObject;

public class yuefen {

	public JSONObject yuefen(int zis, int mus) {// 一个真分数约分后返回 JSONObject
		int zi = zis, mu = mus;
		JSONObject re = new JSONObject();
		int a = GCD(zi, mu);

		zi = zi / a;
		mu = mu / a;
		re.put("zi", zi);
		re.put("mu", mu);
		return re;
	}
	public int GCD(int a, int b) {// 求最大公约数
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

}
