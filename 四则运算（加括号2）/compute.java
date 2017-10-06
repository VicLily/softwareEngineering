package work2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import net.sf.json.JSONObject;

public class compute {
	HashMap<Integer, String> characterList;// 操作符
	HashMap<Integer, JSONObject> DataList;// 操作数
	HashMap<Integer, String> kuohaoList;
	Stack<String> stack1 = new Stack<String>(); // 操作符
	Stack<String> stack2 = new Stack<String>(); // 操作符
	Stack<Integer> stackzi1 = new Stack<Integer>(); // 操作数
	Stack<Integer> stackmu1 = new Stack<Integer>(); // 操作数
	Stack<Integer> stackzi2 = new Stack<Integer>(); // 操作数
	Stack<Integer> stackmu2 = new Stack<Integer>(); // 操作数
	int num, m;

	/***
	 * 
	 * @param characterList1
	 * @param DataList1
	 * @param nums
	 * @return
	 */
	public String compute(HashMap<Integer, String> characterList1, HashMap<Integer, JSONObject> DataList1, int nums) {
		characterList = characterList1;
		DataList = DataList1;
		num = nums;
		kuohaoList = new HashMap<Integer, String>();
		Map.Entry<Integer, String> entry1;
		Map.Entry<Integer, JSONObject> entry2;
		String c, a, result = null;
		int i, j = 0, zi1, mu1, single = 0;
		JSONObject obj, o = new JSONObject();
		Iterator iterator1 = characterList.entrySet().iterator();
		Iterator iterator2 = DataList.entrySet().iterator();
		if (num > 2)
			m = (int) (Math.random() * 2);
		if (m == 1) {
			kuohaoList.put(0, "(");
			kuohaoList.put(1, ")");
			j = (int) (Math.random() * num);
		} else if (m == 2) {
			kuohaoList.put(0, "(");
			kuohaoList.put(1, ")");
			kuohaoList.put(2, "(");
			kuohaoList.put(3, ")");
			j = (int) (Math.random() * (num - 2));
		} else if (m == 3) {
			kuohaoList.put(0, "(");
			kuohaoList.put(1, "(");
			kuohaoList.put(2, ")");
			kuohaoList.put(3, ")");
			j = (int) (Math.random() * (num - 1));
		}
		// System.out.println("m="+m+",j="+j+",num="+num);
		/*
		 * for(int k1=0;k1<kuohaoList.size();k1++)
		 * System.out.println(kuohaoList.get(k1));
		 */
		int k = 0;
		while (iterator1.hasNext()) {// **********************************将chartcterList转放到栈中
			entry1 = (Map.Entry<Integer, String>) iterator1.next();
			c = entry1.getValue();
			i = entry1.getKey();
			if ((c.equals("÷")) && (DataList.get(i + 1).getInt("zi") == 0)) {// ************判断
																				// 除数不为0
				zi1 = (int) (1 + Math.random() * (num - 1));
				mu1 = (int) ((zi1 + 1) + Math.random() * (num - zi1));
				o.put("zi", zi1);
				o.put("mu", mu1);
				DataList.put(i + 1, o);
			}
			if ((i == j) && (single == 0)) {
				if (kuohaoList.containsKey(k)) {
					a = kuohaoList.get(k);
					// System.out.println("a="+a+",k="+k);
					stack1.add(a);
					k++;
					single = 1;
				}
			}else if (single == 1) {
				if (kuohaoList.containsKey(k)) {
					stack1.add(kuohaoList.get(k));
					k++;
				}
			}
			stack1.add(c);
		}
		while (kuohaoList.containsKey(k)) {
			stack1.add(kuohaoList.get(k));
			k++;
		}

		while (iterator2.hasNext()) {// 将操作数放在栈中
			entry2 = (Map.Entry<Integer, JSONObject>) iterator2.next();
			obj = entry2.getValue();
			stackzi1.add(obj.getInt("zi"));
			stackmu1.add(obj.getInt("mu"));
		}
		showT();
		compute1();
		int z = stackzi2.pop();
		int m = stackmu2.pop();
		if (z == 0)
			result = Integer.toString(0);
		else if (z == 1 && m == 1)
			result = Integer.toString(1);
		else if(m<0){
			m=-m;
			z=-z;
		}
		else
			result = Integer.toString(z) + '/' + Integer.toString(m);
		return result;

	}

	public void showT() {
		Stack<String> stackx = new Stack<String>(); // 操作符
		Stack<Integer> stackzix = new Stack<Integer>(); // 操作数
		Stack<Integer> stackmux = new Stack<Integer>();
		String c;
		int zi, mu;
		while (!stack1.isEmpty()) {
			stackx.add(stack1.pop());
		}
		// System.out.println("stackx="+stackx.size());
		while (!stackzi1.isEmpty()) {
			stackzix.add(stackzi1.pop());
			stackmux.add(stackmu1.pop());
		}
		// System.out.println("stackzix="+stackzix.size());
		while (!stackx.isEmpty()) {
			c = stackx.pop();
			if (c.equals("(")) {
				stack1.add(c);
				System.out.print(c);
			} else if (c.equals(")")) {
				zi = stackzix.pop();
				mu = stackmux.pop();
				stack1.add(c);
				stackzi1.add(zi);
				stackmu1.add(mu);
				System.out.print(zi + "/" + mu + c);
				if (!stackx.isEmpty())
					System.out.print(stackx.pop());
			} else {
				zi = stackzix.pop();
				mu = stackmux.pop();
				stack1.add(c);
				stackzi1.add(zi);
				stackmu1.add(mu);
				System.out.print(zi + "/" + mu + c);
			}

		} // while
		if (!stackzix.isEmpty()) {
			zi = stackzix.pop();
			mu = stackmux.pop();
			stackzi1.add(zi);
			stackmu1.add(mu);
			System.out.print(zi + "/" + mu + "=");
		} else
			System.out.print("=");

	}

	public void rever() {
		int zi1, mu1, zi2, mu2;
		zi1 = stackzi1.pop();
		mu1 = stackmu1.pop();
		zi2 = stackzi1.pop();
		mu2 = stackmu1.pop();
		stackzi1.add(zi1);
		stackmu1.add(mu1);
		stackzi1.add(zi2);
		stackmu1.add(mu2);

	}

	public void compute1() {
		String c1, c2;
		int single = 0;
		if (m == 0) {// ***************************************0
			while (!stack1.isEmpty()) {
				c1 = stack1.pop();
				if (c1.equals("*")) {
					compute2(c1);
				} else if (c1.equals("÷")) {
					rever();
					compute2(c1);
				} else if (c1.equals("+") || c1.equals("-")) {
					stackzi2.add(stackzi1.pop());
					stackmu2.add(stackmu1.pop());
					stack2.add(c1);
				}
			}
			if (!stackzi1.isEmpty()) {
				stackzi2.add(stackzi1.pop());
				stackmu2.add(stackmu1.pop());
			}
			while (!stack2.isEmpty()) {
				c2 = stack2.pop();
				compute2(c2);
			}
		} else if ((m == 1) || (m == 2)) {// ***************************************1
			while (!stack1.isEmpty()) {
				c1 = stack1.pop();
				if (single == 0) {
					if (c1.equals(")")) {
						single = 1;
						continue;
					} else if (c1.equals("*") || c1.equals("÷") || c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stack2.add(c1);
					}
				} else {
					if (c1.equals("*"))
						compute2(c1);
					else if (c1.equals("÷")) {
						rever();
						compute2(c1);
					} else if (c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						compute2(c1);
						stackzi1.add(stackzi2.pop());
						stackmu1.add(stackmu2.pop());
					} else if (c1.equals("("))
						single = 0;
				} // else
			} // while
			if (!stackzi1.isEmpty()) {
				stackzi2.add(stackzi1.pop());
				stackmu2.add(stackmu1.pop());
			}
			compute3();
		} else if (m == 3) {// ***************************************3
			while (!stack1.isEmpty()) {
				c1 = stack1.pop();
				if ((single == 0)) {
					if (c1.equals(")")) {
						stack2.add(c1);
						single++;
						continue;
					} else if (c1.equals("*") || c1.equals("÷") || c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stack2.add(c1);
					}
				} else if (single == 1) {
					if (c1.equals(")")) {
						single++;
						continue;
					} else if (c1.equals("*") || c1.equals("÷") || c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stack2.add(c1);
					}
				} else if (single == 2) {
					if (c1.equals("*") )
						compute2(c1);
					else if (c1.equals("÷")) {
						rever();
						compute2(c1);
					} else if (c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						compute2(c1);
						stackzi1.add(stackzi2.pop());
						stackmu1.add(stackmu2.pop());
					} else if (c1.equals("("))
						single++;
				} else if (single == 3) {
					if (c1.equals("*"))
						compute2(c1);
					else if (c1.equals("÷")) {
						rever();
						compute2(c1);
					}else if (c1.equals("+") || c1.equals("-")) {
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						stackzi2.add(stackzi1.pop());
						stackmu2.add(stackmu1.pop());
						compute2(c1);
						stackzi1.add(stackzi2.pop());
						stackmu1.add(stackmu2.pop());
					} else if (c1.equals("(")) {
						while (!stack2.empty()) {
							c2 = stack2.peek();
							if (c2.equals(")")) {
								c2 = stack2.pop();
								break;
							} else if (c1.equals("*") || c1.equals("÷")) {
								c2 = stack2.pop();
								stackzi1.add(stackzi2.pop());
								stackmu1.add(stackmu2.pop());
								rever();
								compute2(c2);
								stackzi2.add(stackzi1.pop());
								stackmu2.add(stackmu1.pop());
							} else if (c2.equals("-") || c2.equals("+")) {
								c2 = stack2.pop();
								stackzi2.add(stackzi1.pop());
								stackmu2.add(stackmu1.pop());
								compute2(c2);
							}
							single = 0;
						} // while
					}
				} // if s=3
			} // while
			compute3();
		} // else
	}

	public void compute3() {// stack2 去掉了括号只剩下加减乘除
		String c1;
		while (!stack2.isEmpty()) {
			c1 = stack2.pop();
			if (c1.equals("*") || c1.equals("÷")) {
				stackzi1.add(stackzi2.pop());
				stackmu1.add(stackmu2.pop());
				stackzi1.add(stackzi2.pop());
				stackmu1.add(stackmu2.pop());
				compute2(c1);
				stackzi2.add(stackzi1.pop());
				stackmu2.add(stackmu1.pop());
			} else if (c1.equals("+") || c1.equals("-")) {
				compute2(c1);
			}
		}
	}

	public void compute2(String c) {
		String c1 = c;
		int zi1, mu1, zi2, mu2;
		if (c1.equals("*")) {
			zi1 = stackzi1.pop();
			zi2 = stackzi1.pop();
			mu1 = stackmu1.pop();
			mu2 = stackmu1.pop();
			cheng(zi1, mu1, zi2, mu2);
		} else if (c1.equals("÷")) {
			zi1 = stackzi1.pop();
			zi2 = stackzi1.pop();
			mu1 = stackmu1.pop();
			mu2 = stackmu1.pop();
			chu(zi1, mu1, zi2, mu2);
		} else if (c1.equals("+")) {
			zi1 = stackzi2.pop();
			zi2 = stackzi2.pop();
			mu1 = stackmu2.pop();
			mu2 = stackmu2.pop();
			jia(zi1, mu1, zi2, mu2);
		} else if (c1.equals("-")) {
			zi1 = stackzi2.pop();
			zi2 = stackzi2.pop();
			mu1 = stackmu2.pop();
			mu2 = stackmu2.pop();
			jian(zi1, mu1, zi2, mu2);
		}
	}

	private void cheng(int zi1s, int mu1s, int zi2s, int mu2s) {// *
		int zi1, mu1, zi2, mu2, zi, mu;
		JSONObject obj;
		zi1 = zi1s;
		mu1 = mu1s;
		zi2 = zi2s;
		mu2 = mu2s;
		if ((zi1 == 0) || (zi2 == 0)) {
			stackzi1.add(0);
			stackmu1.add(1);
		} else {
			zi = zi1 * zi2;
			mu = mu1 * mu2;
			yuefen yue = new yuefen();
			obj = yue.yuefen(zi, mu);
			zi = obj.getInt("zi");
			mu = obj.getInt("mu");
			stackzi1.add(zi);
			stackmu1.add(mu);
		}
	}

	private void chu(int zi1s, int mu1s, int zi2s, int mu2s) {// ÷
		int zi1, mu1, zi2, mu2, zi, mu;
		JSONObject obj;
		zi1 = zi1s;
		mu1 = mu1s;
		zi2 = zi2s;
		mu2 = mu2s;
		zi = zi1 * mu2;
		mu = mu1 * zi2;
		yuefen yue = new yuefen();
		obj = yue.yuefen(zi, mu);
		zi = obj.getInt("zi");
		mu = obj.getInt("mu");
		stackzi1.add(zi);
		stackmu1.add(mu);
	}

	private void jia(int zi1s, int mu1s, int zi2s, int mu2s) {// +
		int zi1, mu1, zi2, mu2, zi, mu;
		JSONObject obj;
		zi1 = zi1s;
		mu1 = mu1s;
		zi2 = zi2s;
		mu2 = mu2s;
		mu = mu1 * mu2;
		zi = (mu1 * zi2) + (mu2 * zi1);
		yuefen yue = new yuefen();
		obj = yue.yuefen(zi, mu);
		zi = obj.getInt("zi");
		mu = obj.getInt("mu");
		stackzi2.add(zi);
		stackmu2.add(mu);
	}

	private void jian(int zi1s, int mu1s, int zi2s, int mu2s) {// -
		int zi1, mu1, zi2, mu2, zi, mu;
		JSONObject obj;
		zi1 = zi1s;
		mu1 = mu1s;
		zi2 = zi2s;
		mu2 = mu2s;
		mu = mu1 * mu2;
		zi = (mu2 * zi1) - (mu1 * zi2);
		yuefen yue = new yuefen();
		obj = yue.yuefen(zi, mu);
		zi = obj.getInt("zi");
		mu = obj.getInt("mu");
		stackzi2.add(zi);
		stackmu2.add(mu);
	}

}
