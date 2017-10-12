package work3;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
//显示每个题的具体内容，用户输入自己的答案
public class outputResult extends JFrame{
		public static JTextArea jTextArea;
		public static JTextArea jTextAreax;
		private JLabel jl1,jl2;
		JButton jb,jbx;
	   public outputResult(){
		   setTitle(new Title().SetTitle());
			setBounds(550, 350, 500, 450);
			Container cp=getContentPane();
			cp.setLayout(null);
			jTextArea=new JTextArea();
			jTextAreax=new JTextArea();
			jl1=new JLabel("Q:");
			jl2=new JLabel("A:");
			jl1.setBounds(2,20,20,20);
			jTextArea.setBounds(20,20,460,150);
			jl2.setBounds(2,180,20,20);
			jTextAreax.setBounds(20,180,460, 150);
			jTextArea.setLineWrap(true);
			jTextAreax.setLineWrap(true);
			dati.text.setBounds(400, 1, 70, 20);
			cp.add(dati.text);
			cp.add(jl1);
			cp.add(jTextArea);
			cp.add(jl2);
			cp.add(jTextAreax);
			//new FileIO().FileInQuestion();//
			jb=new JButton();
			jbx=new JButton();
			jb.setText(new Title().SetBack());
			jbx.setText(new Title().SetCommit());
			jbx.setBounds(160, 350, 80, 20);
			jb.setBounds(260, 350, 80, 20);
			cp.add(jb);
			cp.add(jbx);
			cp.setFocusable(true);
			jb.addActionListener(new ActionListener(){//返回
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				  new select();
				}
				});
			jbx.addActionListener(new ActionListener(){//提交
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					  new judge2(jTextAreax.getText());
				}
				});
			 setVisible(true);
			 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   }
}
