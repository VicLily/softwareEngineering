package work3;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class show extends JFrame{
	public static JTextArea jTextArea;
	public static JTextArea jTextAreax;
	private JLabel jl1,jl2;
	JButton jb,jbx;
   public show(){
	   setTitle(new Title().SetRecordTitle());
		setBounds(550, 350, 500, 400);
		Container cp=getContentPane();
		cp.setLayout(null);
		jTextArea=new JTextArea();
		jTextArea.setBounds(20,10,460,150);
		jTextArea.setLineWrap(true);
		cp.add(jTextArea);
		String ss=new FileIO().FileIn();
		jTextArea.setText(ss);
		jb=new JButton();
		jb.setText(new Title().SetBack());
		jb.setBounds(270, 300, 80, 20);
		cp.add(jb);
		cp.setFocusable(true);
		jb.addActionListener(new ActionListener(){//返回
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			  new select();
			}
			});
		 setVisible(true);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
   }
}
