package work3;

import java.awt.Container;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
//选择答题或者查看历史记录
public class select extends JFrame{
	String a,b;
  public select(){
		setBounds(550, 350, 350, 250);
		Container cp=getContentPane();
		cp.setLayout(null);
		 if(index.Q==1){
			 setTitle("歡迎用戶"); 
			a="記錄";
			b="答題";
		}else if(index.Q==2){
			setTitle("Welcome"); 
			a="Record";
			b="Answer";
		}else {
			setTitle("欢迎用户");
			a="记录";
			b="答题";
		}
		JButton jb=new JButton(a);
		jb.addActionListener(new ActionListener(){//查看历史记录
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		  new show();
		}
		});
		jb.setBounds(70, 70, 100, 28);
		cp.add(jb);
		final JButton button = new JButton();
		button.setText(b);
		button.addActionListener(new ActionListener(){//进入答题
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		   new dati();
		}
		});
		button.setBounds(180, 70, 100, 28);
		getContentPane().add(button);
		 this.setVisible(true);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }

  public static void main(String[] args) {
		new select();
		}

}
