package work3;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
//显示答题个数  和每题的分数,进行下题
public class resultShow1 extends JFrame{
		public static JTextArea jTextArea;
		public static JTextArea jTextAreax;
		private JLabel jl1,jl2;
		JButton jb,jbx;
	   public resultShow1(){
		   setTitle(new Title().SetTitle());
			setBounds(550, 350, 500, 400);
			Container cp=getContentPane();
			cp.setLayout(null);
			jTextArea=new JTextArea();
			jTextArea.setBounds(20,20,460,150);
			jTextArea.setLineWrap(true);
			dati.text.setBounds(400, 1, 70, 20);
			cp.add(dati.text);
			cp.add(jTextArea);
			jb=new JButton();
			jbx=new JButton();
			jb.setText(new Title().SetBack());
			jbx.setText(new Title().SetNext());
			jbx.setBounds(150, 300, 80, 20);
			jb.setBounds(260, 300, 80, 20);
			cp.add(jb);
			cp.add(jbx);
			cp.setFocusable(true);
			jb.addActionListener(new ActionListener(){//返回
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				  new select();
				}
				});
			jbx.addActionListener(new ActionListener(){//下题
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					  new judge();
				}
				});
			 setVisible(true);
			 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   }
}
