package work3;

import java.util.HashMap;

import net.sf.json.JSONObject;

public class judge {
	int s1,s2,m,h;
    public judge(){
    	judgeCompute();
    }
    public void judgeCompute(){
    	if(inputNum.i>theMain.N){
    		String str=dati.text.getText();
    		s1=Integer.valueOf(str).intValue();
    		//h=s1/60;
    		m=s1/60;
    		s2=s1%60;
			//String s=dati.text.getText();
    		 new resultShow2();
    		 resultShow2.jTextArea.setText(rev2());
    		 new saveScore();//将本次答题对错个数存到文件中
    	}else{
    		theMain.s=new StringBuffer();
    		theMain.s.append(rev1());
    		inputNum.i++;
			new theMain();
    	}
			
    }
    public String rev1(){
    	String s=null;
    	if(index.Q==1){
    		s="\n第" + inputNum.i + "題：\n";
		}else if(index.Q==2){
			s="\nNO" + inputNum.i + "：\n";
		}else{
			s="\n第" + inputNum.i + "题：\n";
		}
    	return s;
    }
    public String rev2(){
    	String s=null;
    	if(index.Q==1){
    		s="本次答題總分:"+Integer.toString(theMain.scoreS)+"分!\n耗時:"+m+"分，"+s2+"秒！";
		}else if(index.Q==2){
			s="The total score of this answer:"+Integer.toString(theMain.scoreS)+"!\ntimes:"+m+"m，"+s2+"s！";
		}else{
			s="本次答题总分:"+Integer.toString(theMain.scoreS)+"分!\n耗时:"+m+"m，"+s2+"秒！";
		}
    	return s;
    }
}
