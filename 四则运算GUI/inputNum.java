package work3;

public class inputNum{
	public static int i,m1,m2;
	//m1为本次答题正确个数，m2为本次答题错误个数
	   public inputNum(){
		   outOnescore();
	   }
	   public void outOnescore(){
		   String str=null;
		   i=1;
		   m1=0;
		   m2=0;
		   theMain.scoreS=0;
		   theMain.score = 100 / theMain.N;
		   if(index.Q==1){
			   str = "滿分100分!   每題" + theMain.score + "分!\n";
			}else if(index.Q==2){
				str = "Full scores:100 !   Each question:" + theMain.score + " !\n";
			}else{
				str = "满分100分!   每题" + theMain.score + "分!\n";
			}
			new resultShow1();
			resultShow1.jTextArea.setText(str);
	   }
}
