/*package work2;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import net.sf.json.JSONObject;

public class computeTest {
	HashMap<Integer, String> characterList1=new HashMap<Integer, String>();
	HashMap<Integer, JSONObject> DataList1=new HashMap<Integer, JSONObject>();
	JSONObject obj1=new JSONObject();
	JSONObject obj2=new JSONObject();
	JSONObject obj3=new JSONObject();
	JSONObject obj4=new JSONObject();
	int num=3;
	String result;
	@Test
	public void testCompute() {//  1/2+1/2-1/2-1/4= 1/4
		characterList1.put(0,"+");
		characterList1.put(1, "-");
		characterList1.put(2, "-");
		obj1.put("zi",1);obj1.put("mu",2);DataList1.put(0, obj1);
		obj2.put("zi",1);obj2.put("mu",2);DataList1.put(1, obj2);
		obj3.put("zi",1);obj3.put("mu",2);DataList1.put(2, obj3);
		obj4.put("zi",1);obj4.put("mu",4);DataList1.put(3, obj4);
		compute c=new compute();
		result=c.compute(characterList1,DataList1,num);
		  assertEquals("1/4",result);
		
	}

}


*/