package work3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileIO {
	File file;
	String s1,s2,s3,s;
	int i;
	FileIO(){
	}

	public String FileIn() {//从文件读取答案
		file = new File("score/score.txt");
         byte byt[]=new byte[1024];
         int len;
		try {
			 FileInputStream in=new FileInputStream(file);
			len = in.read(byt);
			if(len<0)
				s="0,0";
			else
				s=new String(byt,0,len);
			 in.close();
			 i=s.indexOf(',');
				s2=s.substring(0,i);//正确	
				s3=s.substring(i+1,s.length());	//错误
				if(index.Q==1){
					s="正確:"+s2+",錯誤:"+s3;
				}else if(index.Q==2){
					s="correct:"+s2+",error:"+s3;
				}else{
					s="正确:"+s2+",错误:"+s3;
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s;
        
	}
	
	
	public void FileOut(String st) throws IOException {//将数据写入文件
		s1=st;
		file = new File("score/score.txt");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			byte buy[]=s1.getBytes();//将一个字符串转化为一个字节数组byte[]的方法
			out.write(buy);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String FileInN() {//从文件读取答案
		file = new File("score/score.txt");
        byte byt[]=new byte[1024];
        int len;
		try {
			FileInputStream in=new FileInputStream(file);
			len = in.read(byt);
			if(len<0)
				s="0,0";
			else
				s=new String(byt,0,len);
			 in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s;
        
	}
}
