package work3;

public class judge2 {
	String result2,result1;
	String st;
	judge2(String re){
		this.result2=re;
		judgex();
	}
	public void judgex(){
		result1=theMain.result1;
		if(result1.equals(result2)){
			st=rev1();
			theMain.scoreS=theMain.scoreS+theMain.score;
			inputNum.m1++;
		}else{
			inputNum.m2++;
			st=rev2();
		}	
		//System.out.println("判断自加时："+inputNum.m1+inputNum.m2);
		new resultShow1();
		  resultShow1.jTextArea.setText(st);
	}
	 public String rev1(){
	    	String s=null;
	    	if(index.Q==1){
	    		s="  √  正確！ 正確答案："+result1+"，你的答案："+result2;
			}else if(index.Q==2){
				s="  √  correct！ correct answer："+result1+"，your answer："+result2;
			}else{
				s="  √  正确！ 正确答案："+result1+"，你的答案："+result2;
			}
	    	return s;
	    }
	 public String rev2(){
	    	String s=null;
	    	if(index.Q==1){
	    		s="  ×  錯誤！ 正確答案："+result1+"，你的答案："+result2;
			}else if(index.Q==2){
				s="  ×  error！ correct answer："+result1+"，your answer："+result2;
			}else{
				s="  ×  错误！ 正确答案："+result1+"，你的答案："+result2;
			}
	    	return s;
	    }
}
