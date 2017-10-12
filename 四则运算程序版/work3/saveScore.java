package work3;

import java.io.IOException;

public class saveScore {
	int n1,n2,i;//n1为正确个数，n2为错误个数。
	String s1,s2,s3,s;
	FileIO f;
	saveScore(){
		comput();
	}
	public void comput(){
		f=new FileIO();
		s1=f.FileInN();
		i=s1.indexOf(',');
		s2=s1.substring(0,i).trim();//正确	
		s3=s1.substring(i+1,s1.length()).trim();	//错误
		n1= Integer.valueOf(s2);
		n2= Integer.valueOf(s3);

			n1=n1+inputNum.m1;
			n2=n2+inputNum.m2;
			s=String.valueOf(n1)+","+String.valueOf(n2);
			//System.out.println("n1="+n1+",n2="+n2+",s="+s);
		try {
			f.FileOut(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
