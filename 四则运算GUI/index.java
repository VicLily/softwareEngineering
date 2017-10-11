package work3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


//用户登录
public class index extends JFrame{
	public static int Q;
	private static final long serialVersionUID = 1L;
	public index(){
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	setTitle("用户登录");
	setBounds(550, 350, 350, 250);
	Container cp=getContentPane();
	cp.setLayout(null);
	JLabel jl=new JLabel("用户名：");
	jl.setBounds(15, 15, 200, 18);
	final JTextField name=new JTextField();
	name.setBounds(80, 10, 150, 18);
	JLabel jl2=new JLabel("密码：");
	jl2.setBounds(15, 50, 200, 18);
	final JPasswordField password=new JPasswordField();
	password.setBounds(80, 50, 150, 18);
	JLabel jll=new JLabel("选择语言：");
	jll.setBounds(15, 85, 200, 18);
	String[] test={"简体中文","繁体中文","English"};
	JComboBox<String> comboBox=new JComboBox<String>(test); 
	comboBox.setBounds(80, 90, 80,20);
	cp.add(jl);
	cp.add(name);
	cp.add(jl2);
	cp.add(password);
	cp.add(comboBox);
	cp.add(jll);
	JButton jb=new JButton("登录");
	jb.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
	if(name.getText().trim().length()==0||new String(password.getPassword()).trim().length()==0){
	JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
	return;
	}
	if(name.getText().trim().equals("Jack")&&new String(password.getPassword()).trim().equals("123")){
	//JOptionPane.showMessageDialog(null, "登录成功");
		setVisible(false);
		Q=comboBox.getSelectedIndex();//获取语言类型
		new select();
	}
	else{
	JOptionPane.showMessageDialog(null, "用户名或密码错误");
	}
	}
	});
	jb.setBounds(80, 150, 60, 18);
	cp.add(jb);
	final JButton button = new JButton();
	button.setText("重置");
	button.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
	// TODO 自动生成方法存根
	name.setText("");
	password.setText("");
	}
	});
	button.setBounds(150, 150, 60, 18);
	getContentPane().add(button);
	setVisible(true);
	}

	public static void main(String[] args) {
	new index();
	}

}
