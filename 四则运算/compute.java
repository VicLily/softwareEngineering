package work1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

public class compute {
	HashMap<Integer, String> characterList;// 操作符
	HashMap<Integer, JSONObject> DataList;// 操作数
	ArrayList<Integer> removeKey1;// 符号
	ArrayList<Integer> removeKey2;// data
	public String compute(HashMap<Integer, String> characterList1,HashMap<Integer, JSONObject> DataList1) {
		characterList=characterList1;
		DataList=DataList1;
		removeKey1 = new ArrayList<>();// 符合
		removeKey2 = new ArrayList<>();// data
		Map.Entry<Integer, String> entry1;
		Map.Entry<Integer, JSONObject> entry3;
		JSONObject obj, ob = new JSONObject();
		String c, result = null;
		yuefen yue=new yuefen();
		int zi1, mu1, zi2, mu2, zi, mu, i, j = 0;
		ob.put("zi", 0);
		ob.put("mu", 1);
		Iterator iterator = characterList.entrySet().iterator();
		while (iterator.hasNext()) {// 处理 乘除
			entry1 = (Map.Entry<Integer, String>) iterator.next();
			c = entry1.getValue();
			i = entry1.getKey();
			if (c.equals("*")) {
				// System.out.println("循环1:" + c + "," + i);
				zi1 = DataList.get(i).getInt("zi");
				zi2 = DataList.get(i + 1).getInt("zi");
				if ((zi1 == 0) || (zi2 == 0)) {
					DataList.put(i + 1, ob);
					removeKey2.add(i);
					removeKey1.add(i);

				} else {
					mu1 = DataList.get(i).getInt("mu");
					mu2 = DataList.get(i + 1).getInt("mu");
					zi = zi1 * zi2;
					mu = mu1 * mu2;
					obj = yue.yuefen(zi, mu);
					DataList.put(i + 1, obj);
					removeKey2.add(i);
					removeKey1.add(i);
					// System.out.println("*：" + obj.getString("zi") + '/'+
					// obj.getString("mu"));
				}

			} else if (c.equals("÷")) {
				zi1 = DataList.get(i).getInt("zi");
				zi2 = DataList.get(i + 1).getInt("zi");
				mu1 = DataList.get(i).getInt("mu");
				mu2 = DataList.get(i + 1).getInt("mu");
				zi = zi1 * mu2;
				mu = mu1 * zi2;
				obj = yue.yuefen(zi, mu);
				DataList.put(i + 1, obj);
				removeKey2.add(i);
				removeKey1.add(i);
				// System.out.println("÷：" + obj.getString("zi") + '/'+
				// obj.getString("mu"));
			} else
				continue;
		}
		Delete();
		Iterator iterator1 = characterList.entrySet().iterator();
		Iterator iterator2 = DataList.entrySet().iterator();
		Map.Entry<Integer, JSONObject> entry2;
		removeKey1 = new ArrayList<>();// 符号
		removeKey2 = new ArrayList<>();// data
		int k = 0;
		while (iterator1.hasNext()) {// 处理 加减
			entry1 = (Map.Entry<Integer, String>) iterator1.next();// characterList
			c = entry1.getValue();
			i = entry1.getKey(); // 符号
			//System.out.println("j=" + j);
			if (j == 0) {
				while (iterator2.hasNext()) {
					entry2 = (Map.Entry<Integer, JSONObject>) iterator2.next();// DataList
					j = entry2.getKey();// j 记录减数
					for (int a = j + 1;; a++) {
						if (DataList.containsKey(a)) {
							k = a;// k 记录被减数
							//System.out.println("k=" + k);
							break;
						}
					}
					break;
				} // while
			} else {
				for (int a = j + 1;; a++) {
					if (DataList.containsKey(a)) {
						k = a;// k 记录被减数
					//	System.out.println("k=" + k);
						break;
					}
				}
			}
			if (c.equals("+")) {
				zi1 = DataList.get(j).getInt("zi");
				zi2 = DataList.get(k).getInt("zi");
				mu1 = DataList.get(j).getInt("mu");
				mu2 = DataList.get(k).getInt("mu");
				//System.out.println("j=" + j + ",i=" + i + ",zi1:" + zi1+ ",zi2:" + zi2 + ",mu1:" + mu1 + ",mu2:" + mu2);
				mu = mu1 * mu2;
				zi = (mu1 * zi2) + (mu2 * zi1);
				obj = yue.yuefen(zi, mu);
				DataList.put(k, obj);
				removeKey2.add(j);
				removeKey1.add(i);
			//.out.println("+：" + obj.getString("zi") + '/'	+ obj.getString("mu"));

			} else if (c.equals("-")) {
				zi1 = DataList.get(j).getInt("zi");
				zi2 = DataList.get(k).getInt("zi");
				mu1 = DataList.get(j).getInt("mu");
				mu2 = DataList.get(k).getInt("mu");
				//System.out.println("j=" + j + ",i=" + i + ",zi1:" + zi1	+ ",zi2:" + zi2 + ",mu1:" + mu1 + ",mu2:" + mu2);
				mu = mu1 * mu2;
				zi = (mu2 * zi1) - (mu1 * zi2);
				obj = yue.yuefen(zi, mu);
				DataList.put(k, obj);
				removeKey2.add(j);
				removeKey1.add(i);
				//System.out.println("-：" + obj.getString("zi") + '/'	+ obj.getString("mu"));
			}
			j = k;
		} // while
		Delete();
		iterator2 = DataList.entrySet().iterator();
		while (iterator2.hasNext()) {
			entry2 = (Map.Entry<Integer, JSONObject>) iterator2.next();// DataList
			j = entry2.getKey();
			zi = entry2.getValue().getInt("zi");
			mu = entry2.getValue().getInt("mu");
			String z = Integer.toString(zi);
			String m = Integer.toString(mu);
			result = z + '/' + m;
		}
		return result;
	}
	public void Delete() {
		for (int i = 0; i < removeKey1.size(); i++) {
			characterList.remove(removeKey1.get(i));
		}
		for (int i = 0; i < removeKey2.size(); i++) {
			DataList.remove(removeKey2.get(i));
		}
	}
}
