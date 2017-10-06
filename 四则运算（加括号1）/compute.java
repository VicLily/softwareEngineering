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
	HashMap<Integer,String> kuohaoList;
	Stack<String> stack1 = new Stack<String>(); // 操作符
	Stack<String> stack2 = new Stack<String>(); // 操作符
	Stack<Integer> stackzi = new Stack<Integer>(); // 操作数
	Stack<Integer> stackmu = new Stack<Integer>(); // 操作数
	Stack<Integer> stackzi2 = new Stack<Integer>(); // 操作数
	Stack<Integer> stackmu2 = new Stack<Integer>(); // 操作数
	int num, m,M=6;

	public String compute(HashMap<Integer, String> characterList1, HashMap<Integer, JSONObject> DataList1, int nums) {
		characterList = characterList1;
		DataList = DataList1;
		num = nums;
		kuohaoList = new HashMap<Integer,String>();
		Map.Entry<Integer, String> entry1;
		Map.Entry<Integer, JSONObject> entry2;
		String c,a,result=null;
		int i, j = 0,zi1,mu1,single=0;
		JSONObject obj,o = new JSONObject();
		Iterator iterator1 = characterList.entrySet().iterator();
		Iterator iterator2 = DataList.entrySet().iterator();
		if (num > 2)
			m = (int) (Math.random() * 2);
		else if (num > 3)
			m = (int) (Math.random() * 4);
		if (m == 1) {
			kuohaoList.put(0,"(");
			kuohaoList.put(1,")");
			j = (int) (Math.random() * num);
		} else if (m == 2) {
			kuohaoList.put(0,"(");
			kuohaoList.put(1,")");
			kuohaoList.put(2,"(");
			kuohaoList.put(3,")");
			j = (int) (Math.random() * (num - 1));
		} else if (m == 3) {
			kuohaoList.put(0,"(");
			kuohaoList.put(1,"(");
			kuohaoList.put(2,")");
			kuohaoList.put(3,")");
			j = (int) (Math.random() * num);
		}
		//System.out.println("m="+m+",j="+j+",num="+num);
		/*for(int k1=0;k1<kuohaoList.size();k1++)
			System.out.println(kuohaoList.get(k1));*/
		int k=0;
		while (iterator1.hasNext()) {// **********************************将chartcterList转放到栈中
			entry1 = (Map.Entry<Integer, String>) iterator1.next();
			c = entry1.getValue();
			i = entry1.getKey();
			if((c.equals("÷"))&&(DataList.get(i+1).getInt("zi")==0)){//************判断 除数不为0
				zi1 = (int) (1 + Math.random() * (M-2));
				mu1 = (int) (zi1 + Math.random() * (M - zi1));
				o.put("zi", zi1);
				o.put("mu", mu1);
				DataList.put(i + 1, o);
			}
			if ((i==j)&&(single==0)){
				if (kuohaoList.containsKey(k)){
					a=kuohaoList.get(k);
				//	System.out.println("a="+a+",k="+k);
					stack1.add(a);
					k++;
					single=1;
				}
			}	
			stack1.add(c);
			if(single==1){
				if (kuohaoList.containsKey(k)){
					stack1.add(kuohaoList.get(k));
					k++;
				}
			}
			
				
		}
		if (kuohaoList.containsKey(k))
			stack1.add(kuohaoList.get(k));
		while (iterator2.hasNext()) {//将操作数放在栈中
			entry2 = (Map.Entry<Integer, JSONObject>) iterator2.next();
			obj = entry2.getValue();
			stackzi.add(obj.getInt("zi"));
			stackmu.add(obj.getInt("mu"));
		}
		showT();
		compute1();
		int z=stackzi2.pop();
		int m=stackmu2.pop();
		result=Integer.toString(z)+'/'+Integer.toString(m);
		return result;

	}
	public void showT(){
		Stack<String> stackx = new Stack<String>(); // 操作符
		Stack<Integer> stackzix = new Stack<Integer>(); // 操作数
		Stack<Integer> stackmux = new Stack<Integer>();
		String c;
		int zi,mu;
		while(!stack1.isEmpty()){
			stackx.add(stack1.pop());
		}
		//System.out.println("stackx="+stackx.size());
		while(!stackzi.isEmpty()){
			stackzix.add(stackzi.pop());
			stackmux.add(stackmu.pop());
		}
		//System.out.println("stackzix="+stackzix.size());
		while(!stackx.isEmpty()){
			c=stackx.pop();
			if(c.equals("(")){
				stack1.add(c);
				System.out.print(c);
			}else if(c.equals(")")){
				zi=stackzix.pop();
				mu=stackmux.pop();
				stack1.add(c);
				stackzi.add(zi);
				stackmu.add(mu);
				System.out.print(zi+"/"+mu+c);
				if(!stackx.isEmpty())
					System.out.print(stackx.pop());
			}else{
				zi=stackzix.pop();
				mu=stackmux.pop();
				stack1.add(c);
				stackzi.add(zi);
				stackmu.add(mu);
				System.out.print(zi+"/"+mu+c);
			}
			
		}
		if(!stackzix.isEmpty()){
			zi=stackzix.pop();
			mu=stackmux.pop();
			stackzi.add(zi);
			stackmu.add(mu);
			System.out.print(zi+"/"+mu+"=");
		}else System.out.print("=");
			
		
	}
	public void compute1() {
		String c1, c2 = null,c;
		int single1=0,zi1,zi2,mu1,mu2;
		while (!stack1.isEmpty()) {
			c1 = stack1.pop();
			if (c1.equals(")")){
				stackzi2.add(stackzi.pop());
				stackmu2.add(stackmu.pop());
				stack2.add(c1);
			}else if(c1.equals("+")||c1.equals("-")){
				stack2.add(c1);	
				int s=stackzi.pop();
				//System.out.println();
				//System.out.println("-,zi="+s);
				stackzi2.add(s);
				stackmu2.add(stackmu.pop());
			}else if(c1.equals("*")||c1.equals("÷")){
				if (!stack1.isEmpty()){
					if(stack1.peek().equals(")"))
						single1=1;
				}
				
				if(single1==0){
					stackzi2.add(stackzi.pop());
					stackmu2.add(stackmu.pop());
					stackzi2.add(stackzi.pop());
					stackmu2.add(stackmu.pop());
					compute2(c1);
					single1=1;
				}else{
					stackzi2.add(stackzi.pop());
					stackmu2.add(stackmu.pop());
					compute2(c1);	
				}
				
			}
			if (!stack1.isEmpty()){
				c2 = stack1.peek();
				if(c2.equals("(")){
					c2 = stack1.pop();
					single1=1;
					compute3();	
				}
					
			}
				
		}
		while(!stackzi.isEmpty()){
			stackzi2.add(stackzi.pop());
			stackmu2.add(stackmu.pop());
		}
		while (!stack2.isEmpty()) {// 计算剩下的加减
			c=stack2.pop();
			compute2(c);
		}
	}
	public void compute2(String c){
		String c1=c;
		int zi1, mu1, zi2, mu2;
		if (c1.equals("*")) {
			zi1 = stackzi2.pop();
			zi2 = stackzi2.pop();
			mu1 = stackmu2.pop();
			mu2 = stackmu2.pop();
			cheng(zi1, mu1, zi2, mu2);
		} else if (c1.equals("÷")) {
			zi1 = stackzi2.pop();
			zi2 = stackzi2.pop();
			mu1 = stackmu2.pop();
			mu2 = stackmu2.pop();
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
	public void compute3(){
		String c;
		while(!stack2.isEmpty()){
			c=stack2.pop();
			if(!c.equals(")"))
			  compute2(c);
			else break;
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
			stackzi2.add(0);
			stackmu2.add(1);
		} else {
			zi = zi1 * zi2;
			mu = mu1 * mu2;
			yuefen yue = new yuefen();
			obj = yue.yuefen(zi, mu);
			zi = obj.getInt("zi");
			mu = obj.getInt("mu");
			stackzi2.add(zi);
			stackmu2.add(mu);
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
		stackzi2.add(zi);
		stackmu2.add(mu);
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
