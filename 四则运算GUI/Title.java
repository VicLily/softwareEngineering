package work3;

public class Title {
	String s;
	Title(){
		SetTitle();
	}
	public String SetTitle(){
		if(index.Q==1){
			s="答題中..";
		}else if(index.Q==2){
			s="Answer..";
		}else{
			s="答题中..";
		}
		return s;
	}
	public String SetNext(){
		if(index.Q==1){
			s="下題";
		}else if(index.Q==2){
			s="Next";
		}else{
			s="下题";
		}
		return s;
	}
	public String SetBack(){
		if(index.Q==1){
			s="返回";
		}else if(index.Q==2){
			s="Back";
		}else{
			s="返回";
		}
		return s;
	}
	public String SetCommit(){
		if(index.Q==1){
			s="提交";
		}else if(index.Q==2){
			s="commit";
		}else{
			s="提交";
		}
		return s;
	}
	public String SetRecordTitle(){
		if(index.Q==1){
			s="曆史記錄";
		}else if(index.Q==2){
			s="history record";
		}else{
			s="历史记录";
		}
		return s;
	}
	public String SetInputN(){
		if(index.Q==1){
			s="輸入題目個數";
		}else if(index.Q==2){
			s="Enter the number of questions";
		}else{
			s="输入题目个数";
		}
		return s;
	}
}
