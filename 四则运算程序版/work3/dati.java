package work3;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

//输入题目个数，开始答题
public class dati extends JFrame {
	public static JTextArea jTextArea;
	public static JTextArea jTextAreax;
	public static JTextField text;
	JTextField textshow;
	Listener listener;
	Timer count;
	private JLabel jl1, jl2;
	JButton jb, jbx;

	public dati() {
		setTitle(new Title().SetTitle());
		setBounds(550, 350, 500, 450);
		Container cp = getContentPane();
		cp.setLayout(null);
		text = new JTextField("1");
		text.setBounds(400, 1, 70,20);
		listener = new Listener();
		text.addActionListener(listener);
		listener.setCount(text);
		count = new Timer(1000, listener);
		count.start();
		jTextArea = new JTextArea();
		jTextAreax = new JTextArea();
		jl1 = new JLabel("Q:");
		jl2 = new JLabel("A:");
		jl1.setBounds(2, 20, 20, 20);
		jTextArea.setBounds(20, 20, 460, 150);
		jl2.setBounds(2, 200, 20, 20);
		jTextAreax.setBounds(20, 200, 460, 150);
		jTextArea.setLineWrap(true);
		jTextAreax.setLineWrap(true);
		cp.add(text);
		cp.add(jl1);
		cp.add(jTextArea);
		cp.add(jl2);
		cp.add(jTextAreax);
		jTextArea.setText(new Title().SetInputN());
		jb = new JButton();
		jbx = new JButton();
			jb.setText(new Title().SetBack());
			jbx.setText(new Title().SetCommit());
		jbx.setBounds(150, 360, 80, 20);
		jb.setBounds(270, 360, 80, 20);
		cp.add(jb);
		cp.add(jbx);
		cp.setFocusable(true);
		jb.addActionListener(new ActionListener() {// 返回
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new select();
			}
		});
		jbx.addActionListener(new ActionListener() {// 提交
			public void actionPerformed(ActionEvent arg0) {
				String s = jTextAreax.getText();
				theMain.N = Integer.valueOf(s).intValue();
				// JOptionPane.showMessageDialog(null, "ok!");
				setVisible(false);
				new inputNum();
			}
		});
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
/*
	public static void main(String[] args) {
		new dati();
	}*/

	class Listener implements ActionListener {
		JTextField text;

		public void setCount(JTextField text) {
			this.text = text;
		}

		public void actionPerformed(ActionEvent e) {
			String str = text.getText();
			int x = Integer.parseInt(str);
			x++;
			text.setText("" + x);
		}
	}
}
