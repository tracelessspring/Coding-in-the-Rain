
package tracelessspring;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Modify_Task_Frame extends JFrame{
	private String str_jlb_weiboemailcontent;
	private String str_jlb_idoremail;
	private static String[] str_taskname;
	private String str_date;
	private String str_time;
	private String str_receiveemail;
	private String str_emailkey;
	private String str_idoremail;
	private String str_weibokey;
	private String str_weiboemailcontent;
	
	//private JTextField jtf_taskname;
	private JTextField jtf_date;
	private JTextField jtf_time;
	private JTextField jtf_receiveemail;
	private JTextField jtf_idoremail;
	private JPasswordField jpf_weibokey;
	private JTextArea jta_weiboemailcontent;
	private JPasswordField jpf_emailkey;
	//private JPasswordField jpf_weibokey;
	
	private JLabel jlb_framename;
	private JLabel jlb_taskname;
	private JLabel jlb_ifthis;
	private JLabel jlb_thenthat;
	private JLabel jlb_date;
	private JLabel jlb_time;
	private JLabel jlb_receiveemail;
	private JLabel jlb_emailkey;
	private JLabel jlb_idoremail;
	private JLabel jlb_weibokey;
	private JLabel jlb_weiboemailcontent;        //这里是微博或者邮件内容
	
	private static JComboBox jcb_taskname;
	private JComboBox jcb1;
	private JComboBox jcb2;
	
	private JButton jb_ok;
	private JButton jb_reset;
	private JButton jb_cancel;
	
	private JScrollPane scrollpane1;
	
	public static void fresh_taskname(String taskname){
		jcb_taskname.addItem(taskname);
		jcb_taskname.setSelectedIndex(0);
		/*System.out.println("true");
		str_taskname=new String[Runner.count_task];
		for(int i=0;i<Runner.count_task;i++){
			str_taskname[i]=Runner.task[i].get_taskname();
			//System.out.println(str_taskname[0]);
		}*/
		
	}
	
	public static void delete_taskname(int i){
		jcb_taskname.removeItemAt(i);
	}
	
	public void set2clock(){
		str_receiveemail="";
		jtf_receiveemail.setText(str_receiveemail);
		str_emailkey="";
		jpf_emailkey.setText(str_emailkey);
		
		jlb_date.setVisible(true);
		jlb_time.setVisible(true);
		jlb_receiveemail.setVisible(false);
		jlb_emailkey.setVisible(false);
		jtf_date.setVisible(true);
		jtf_time.setVisible(true);
		jtf_receiveemail.setVisible(false);
		jpf_emailkey.setVisible(false);
	}
	
	public void set2receiveemail(){
		str_date="";
		jtf_date.setText(str_date);
		str_time="";
		jtf_time.setText(str_time);
		
		jlb_date.setVisible(false);;
		jlb_time.setVisible(false);
		jlb_receiveemail.setVisible(true);
		jlb_emailkey.setVisible(true);
		jtf_date.setVisible(false);
		jtf_time.setVisible(false);
		jtf_receiveemail.setVisible(true);
		jpf_emailkey.setVisible(true);
	}
	
	public void set2weibo(){
		str_idoremail="";
		jtf_idoremail.setText(str_idoremail);
		str_weibokey="";
		jpf_weibokey.setText(str_weibokey);
		str_weiboemailcontent="";
		jta_weiboemailcontent.setText(str_weiboemailcontent);
				
		str_jlb_idoremail="ID:";
		jlb_idoremail.setText(str_jlb_idoremail);
		//jlb_idoremail=new JLabel(str_jlb_idoremail);
		str_weiboemailcontent="微博内容:";
		jlb_weiboemailcontent.setText(str_weiboemailcontent);
		//jlb_weiboemailcontent=new JLabel(str_weiboemailcontent);
		jlb_weibokey.setVisible(true);
		jpf_weibokey.setVisible(true);
	}
	
	public void set2sendemail(){
		str_idoremail="";
		jtf_idoremail.setText(str_idoremail);
		str_weibokey="";
		jpf_weibokey.setText(str_weibokey);
		str_weiboemailcontent="";
		jta_weiboemailcontent.setText(str_weiboemailcontent);
		
		str_jlb_idoremail="邮箱:";
		jlb_idoremail.setText(str_jlb_idoremail);
		//jlb_idoremail=new JLabel(str_jlb_idoremail);
		str_weiboemailcontent="邮件内容:";
		jlb_weiboemailcontent.setText(str_weiboemailcontent);
		//jlb_weiboemailcontent=new JLabel(str_weiboemailcontent);
		jlb_weibokey.setVisible(false);
		jpf_weibokey.setVisible(false);
	}
	
	
	public void reset(){           //将变量都清零,JComboBox也恢复到两个selectedindex都为0的状态
		jcb1.setSelectedIndex(0);
		jcb2.setSelectedIndex(0);
		str_date="";
		str_time="";
		str_receiveemail="";
		str_emailkey="";
		str_jlb_idoremail="ID:";
		str_jlb_weiboemailcontent="微博内容:";
		str_idoremail="";
		str_weibokey="";
		str_weiboemailcontent="";
		
		jtf_date.setText(str_date);
		jtf_time.setText(str_time);
		jtf_receiveemail.setText(str_receiveemail);
		jpf_emailkey.setText(str_emailkey);
		jtf_idoremail.setText(str_idoremail);
		jpf_weibokey.setText(str_weibokey);
		jta_weiboemailcontent.setText(str_weiboemailcontent);
		jlb_idoremail.setText(str_jlb_idoremail);
		jlb_weiboemailcontent.setText(str_jlb_weiboemailcontent);
		
		jtf_date.setVisible(true);
		jlb_date.setVisible(true);
		jtf_time.setVisible(true);
		jlb_time.setVisible(true);
		jtf_receiveemail.setVisible(false);
		jlb_receiveemail.setVisible(false);
		jpf_emailkey.setVisible(false);
		jlb_emailkey.setVisible(false);
		
		jtf_idoremail.setVisible(true);
		jlb_idoremail.setVisible(true);
		jpf_weibokey.setVisible(true);
		jlb_weibokey.setVisible(true);
		jta_weiboemailcontent.setVisible(true);
		jlb_weiboemailcontent.setVisible(true);
		
		jcb_taskname.setSelectedIndex(0);
	}
	
	public void window_close(){     
		reset();
		setVisible(false);
	}
	
	public void set_by_select()      //根据选择的任务来改变显示的页面
	{
		int index=jcb_taskname.getSelectedIndex();
		//System.out.println("index="+index);
		if(index==0){
			reset();
			
		}
		else{
			jcb1.setSelectedIndex(Runner.task[index-1].get_clockoremail());
			jcb2.setSelectedIndex(Runner.task[index-1].get_weibooremail());
			
			
			str_date=Runner.task[index-1].get_date();
			str_time=Runner.task[index-1].get_time();
			str_receiveemail=Runner.task[index-1].get_receiveemail();
		    str_emailkey=Runner.task[index-1].get_emailkey();
		    if(Runner.task[index-1].get_clockoremail()==0){
		    	str_jlb_idoremail="ID:";
		    }
		    else{
		    	str_jlb_idoremail="邮箱:";
		    }
			if(Runner.task[index-1].get_weibooremail()==0){
				str_jlb_weiboemailcontent="微博内容:";
			}
			else{
				str_jlb_weiboemailcontent="邮件内容:";
			}
			str_idoremail=Runner.task[index-1].get_idoremail();
			str_weibokey=Runner.task[index-1].get_weibokey();
			str_weiboemailcontent=Runner.task[index-1].get_weiboemailcontent();
			
			
			/*System.out.println(Runner.task[index-1].get_taskname()+"    "+Runner.task[index-1].get_clockoremail()+"    "+
					Runner.task[index-1].get_date()+"    "+Runner.task[index-1].get_time()+"    "+
					Runner.task[index-1].get_receiveemail()+"    "+Runner.task[index-1].get_emailkey()+"    "+
					Runner.task[index-1].get_weibooremail()+"    "+Runner.task[index-1].get_idoremail()+"    "+
					Runner.task[index-1].get_weibokey()+"    "+Runner.task[index-1].get_weiboemailcontent());*/
			//jcb1.setSelectedIndex(Runner.task[index-1].get_clockoremail());
			//System.out.println(Runner.task[index-1].get_clockoremail());
			//jcb2.setSelectedIndex(Runner.task[index-1].get_weibooremail());
			//System.out.println(Runner.task[index-1].get_weibooremail());
			
			jtf_date.setText(str_date);
			jtf_time.setText(str_time);
			jtf_receiveemail.setText(str_receiveemail);
			jpf_emailkey.setText(str_emailkey);
			jlb_idoremail.setText(str_jlb_idoremail);
			jlb_weiboemailcontent.setText(str_jlb_weiboemailcontent);
			jtf_idoremail.setText(str_idoremail);
			jpf_weibokey.setText(str_weibokey);
			jta_weiboemailcontent.setText(str_weiboemailcontent);
			
			if(index!=0){
				if(Runner.task[index-1].get_clockoremail()==0){
					if(Runner.task[index-1].get_weibooremail()==0){
						jtf_date.setVisible(true);
						jlb_date.setVisible(true);
						jtf_time.setVisible(true);
						jlb_time.setVisible(true);
						jtf_receiveemail.setVisible(false);
						jlb_receiveemail.setVisible(false);
						jpf_emailkey.setVisible(false);
						jlb_emailkey.setVisible(false);
						
						jtf_idoremail.setVisible(true);
						jlb_idoremail.setVisible(true);
						jpf_weibokey.setVisible(true);
						jlb_weibokey.setVisible(true);
						jta_weiboemailcontent.setVisible(true);
						jlb_weiboemailcontent.setVisible(true);
					}
					else{
						System.out.println("meet here1");
						jtf_date.setVisible(true);
						jlb_date.setVisible(true);
						jtf_time.setVisible(true);
						jlb_time.setVisible(true);
						jtf_receiveemail.setVisible(false);
						jlb_receiveemail.setVisible(false);
						jpf_emailkey.setVisible(false);
						jlb_emailkey.setVisible(false);
						
						jtf_idoremail.setVisible(true);
						jlb_idoremail.setVisible(true);
						jpf_weibokey.setVisible(false);
						jlb_weibokey.setVisible(false);
						jta_weiboemailcontent.setVisible(true);
						jlb_weiboemailcontent.setVisible(true);
					}
				}
				else{
					if(Runner.task[index-1].get_weibooremail()==0){
						jtf_date.setVisible(false);
						jlb_date.setVisible(false);
						jtf_time.setVisible(false);
						jlb_time.setVisible(false);
						jtf_receiveemail.setVisible(true);
						jlb_receiveemail.setVisible(true);
						jpf_emailkey.setVisible(true);
						jlb_emailkey.setVisible(true);
						
						jtf_idoremail.setVisible(true);
						jlb_idoremail.setVisible(true);
						jpf_weibokey.setVisible(true);
						jlb_weibokey.setVisible(true);
						jta_weiboemailcontent.setVisible(true);
						jlb_weiboemailcontent.setVisible(true);
					}
					else{
						System.out.println("meet here2");
						jtf_date.setVisible(false);
						jlb_date.setVisible(false);
						jtf_time.setVisible(false);
						jlb_time.setVisible(false);
						jtf_receiveemail.setVisible(true);
						jlb_receiveemail.setVisible(true);
						jpf_emailkey.setVisible(true);
						jlb_emailkey.setVisible(true);
						
						jtf_idoremail.setVisible(true);
						jlb_idoremail.setVisible(true);
						jpf_weibokey.setVisible(false);
						jlb_weibokey.setVisible(false);
						jta_weiboemailcontent.setVisible(true);
						jlb_weiboemailcontent.setVisible(true);
					}
				}
				
				
			}
			
		}
		
	}
	
	
	
	
	
	public void init(){
		
		str_taskname=new String[1];
		//jcb_taskname=new JComboBox(str_taskname);
		str_taskname[0]="              ";
		//System.out.println(Runner.count_task);
		/*if(Runner.count_task==0){
			str_taskname=new String[1];
			System.out.println("等于0");
			//str_taskname("");
			str_taskname[0]="                 ";
		}
		else{
			System.out.println("等于1");
			str_taskname=new String[Runner.count_task];
			for(int i=0;i<Runner.count_task;i++){
				str_taskname[i]=Runner.task[i].get_taskname();
				//System.out.println(str_taskname[0]);
			}
		}*/
		
		
		str_date="";
		str_time="";
		str_receiveemail="";
		str_emailkey="";
		str_idoremail="";
		str_weibokey="";
		str_weiboemailcontent="";
		str_jlb_idoremail="ID:";

		
		jlb_framename=new JLabel("修改任务",JLabel.CENTER);
		jlb_taskname=new JLabel("选择要修改的任务名称:");
		jlb_ifthis=new JLabel("IF   THIS",JLabel.LEFT);
		jlb_thenthat=new JLabel("THEN   THAT",JLabel.LEFT);
		jlb_date=new JLabel("日期:");
		jlb_time=new JLabel("时间:");
		jlb_receiveemail=new JLabel("收件邮箱:");
		jlb_emailkey=new JLabel("密码:");
		jlb_idoremail=new JLabel(str_jlb_idoremail);
		jlb_weibokey=new JLabel("密码:");
		jlb_weiboemailcontent=new JLabel("微博内容:");
		
		jcb_taskname=new JComboBox(str_taskname);
		jcb_taskname.setSelectedIndex(0);
		jcb1=new JComboBox(new String[]{"时钟","收到邮件"});
		jcb2=new JComboBox(new String[]{"新浪微博","发送邮件"});
		
		jb_ok=new JButton("确定");
		jb_reset=new JButton("重置");
		jb_cancel=new JButton("取消");
		
		
		//jtf_taskname=new JTextField(str_taskname,60);
		jtf_date=new JTextField(str_date,15);
		jtf_time=new JTextField(str_time,15);
		jtf_receiveemail=new JTextField(str_receiveemail,15);
		jpf_emailkey=new JPasswordField(str_emailkey,15);
		jtf_idoremail=new JTextField(str_idoremail,15);
		jpf_weibokey=new JPasswordField(str_weibokey,15);
		jta_weiboemailcontent=new JTextArea(str_weiboemailcontent,5,20);
		jta_weiboemailcontent.setLineWrap(true);
		jta_weiboemailcontent.setWrapStyleWord(true);
		jta_weiboemailcontent.setEditable(true);
		scrollpane1=new JScrollPane(jta_weiboemailcontent);
		jpf_emailkey=new JPasswordField(str_emailkey,15);
		jpf_weibokey=new JPasswordField(str_weibokey,15);
		
		
		jlb_framename.setFont(new Font("SansSerif",Font.BOLD,32));
		jlb_ifthis.setBounds(50, 150, 80, 20);
		jlb_thenthat.setBounds(400, 150, 80, 20);
		jcb1.setBounds(75, 200, 80, 20);
		jcb2.setBounds(450, 200, 80, 20);
		
		
		jlb_receiveemail.setVisible(false);
		jlb_emailkey.setVisible(false);
		jtf_receiveemail.setVisible(false);
		jpf_emailkey.setVisible(false);
		
		
		//set2clock();
		//set2weibo();
	}
	
	
	public Modify_Task_Frame(){
		
		init();
		
		
		/*jlb_taskname.setVisible(true);
	    jlb_ifthis.setVisible(true);
		
		jlb_thenthat.setVisible(true);
		
		jlb_date.setVisible(true);
		jlb_time.setVisible(true);
		jlb_receiveemail.setVisible(false);
		jlb_emailkey.setVisible(false);
		jlb_idoremail.setVisible(true);
		jlb_weibokey.setVisible(true);
		jlb_weiboemailcontent.setVisible(true);
		jtf_receiveemail.setVisible(false);
		jpf_emailkey.setVisible(false);*/
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp1.add(jlb_framename);
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp2.add(jlb_taskname);
		jp2.add(jcb_taskname);
		
		JPanel jp3=new JPanel();
		jp3.setLayout(new GridLayout(2,1,5,15));
		jp3.add(jp1);
		jp3.add(jp2);
		jp3.setBounds(25, 10, 800, 100);
		
		JPanel jp4=new JPanel();
		jp4.setLayout(new GridLayout(1,2,5,15));
		jp4.add(jlb_ifthis);
		jp4.add(jlb_thenthat);
		jp4.setBounds(50, 150, 700, 20);
		
		JPanel jp5=new JPanel();
		jp5.setLayout(new GridLayout(4,1,5,15));
		jp5.add(jlb_date);
		jp5.add(jlb_receiveemail);
		jp5.add(jlb_time);
		jp5.add(jlb_emailkey);
		jp5.setBounds(75, 240, 60, 150);
		
		JPanel jp6=new JPanel();
		jp6.setLayout(new GridLayout(4,1,5,15));
		jp6.add(jtf_date);
		jp6.add(jtf_receiveemail);
		jp6.add(jtf_time);
		jp6.add(jpf_emailkey);
		jp6.setBounds(135, 240, 150, 150);
		
		JPanel jp7=new JPanel();
		jp7.setLayout(new GridLayout(2,1,5,15));
		jp7.add(jlb_idoremail);
		jp7.add(jlb_weibokey);
		jp7.setBounds(450, 240, 60, 65);
		
		JPanel jp8=new JPanel();
		jp8.setLayout(new GridLayout(2,1,5,15));
		jp8.add(jtf_idoremail);
		jp8.add(jpf_weibokey);
		jp8.setBounds(510, 240, 150, 65);
		
		
		JPanel jp9=new JPanel();
		jp9.setLayout(new BorderLayout(5,5));
		jp9.add(jlb_weiboemailcontent,BorderLayout.NORTH);
		jp9.add(scrollpane1,BorderLayout.CENTER);
		jp9.setBounds(450, 320, 210, 100);
		
		JPanel jp10=new JPanel();
		jp10.setLayout(new GridLayout(1,3,55,5));
		jp10.add(jb_ok);
		jp10.add(jb_reset);
		jp10.add(jb_cancel);
		jp10.setBounds(140,480,500,25);
		
		setLayout(null);
		add(jp3);
		add(jp4);
		add(jcb1);
		add(jcb2);
		add(jp5);
		add(jp6);
		add(jp7);
		add(jp8);
		add(jp9);
		add(jp10);
		
		setTitle("修改任务");
		setSize(800,600);
		setLocationRelativeTo(null);
		
		
		jcb_taskname.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				set_by_select();
			}
		});
		
		jcb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jcb1.getSelectedIndex()==0)
					set2clock();
				else if(jcb1.getSelectedIndex()==1)
					set2receiveemail();
				else
					System.out.println("error in jcb1.addActionListener");
			}
		});
		
		jcb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jcb2.getSelectedIndex()==0)
					set2weibo();
				else if(jcb2.getSelectedIndex()==1)
					set2sendemail();
				else
					System.out.println("error in jcb2.addActionListener");
			}
		});
		
		
		
		
		
		jtf_date.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_date=jtf_date.getText();
				System.out.println(str_date);
			}
			public void removeUpdate(DocumentEvent e){
				str_date=jtf_date.getText();
				System.out.println(str_date);
			}
			public void changedUpdate(DocumentEvent e){
				str_date=jtf_date.getText();
				System.out.println(str_date);
			}
		});
		
		jtf_time.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_time=jtf_time.getText();
				System.out.println(str_time);
			}
			public void removeUpdate(DocumentEvent e){
				str_time=jtf_time.getText();
				System.out.println(str_time);
			}
			public void changedUpdate(DocumentEvent e){
				str_time=jtf_time.getText();
				System.out.println(str_time);
			}
		});
		
		jtf_receiveemail.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_receiveemail=jtf_receiveemail.getText();
				System.out.println(str_receiveemail);
			}
			public void removeUpdate(DocumentEvent e){
				str_receiveemail=jtf_receiveemail.getText();
				System.out.println(str_receiveemail);
			}
			public void changedUpdate(DocumentEvent e){
				str_receiveemail=jtf_receiveemail.getText();
				System.out.println(str_receiveemail);
			}
		});
		
		jpf_emailkey.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_emailkey=jpf_emailkey.getText();
				System.out.println(str_emailkey);
			}
			public void removeUpdate(DocumentEvent e){
				str_emailkey=jpf_emailkey.getText();
				System.out.println(str_emailkey);
			}
			public void changedUpdate(DocumentEvent e){
				str_emailkey=jpf_emailkey.getText();
				System.out.println(str_emailkey);
			}
		});
		
		jtf_idoremail.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_idoremail=jtf_idoremail.getText();
				System.out.println(str_idoremail);
			}
			public void removeUpdate(DocumentEvent e){
				str_idoremail=jtf_idoremail.getText();
				System.out.println(str_idoremail);
			}
			public void changedUpdate(DocumentEvent e){
				str_idoremail=jtf_idoremail.getText();
				System.out.println(str_idoremail);
			}
		});
		
		jpf_weibokey.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_weibokey=jpf_weibokey.getText();
				System.out.println(str_weibokey);
			}
			public void removeUpdate(DocumentEvent e){
				str_weibokey=jpf_weibokey.getText();
				System.out.println(str_weibokey);
			}
			public void changedUpdate(DocumentEvent e){
				str_weibokey=jpf_weibokey.getText();
				System.out.println(str_weibokey);
			}
		});
		
		jta_weiboemailcontent.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				str_weiboemailcontent=jta_weiboemailcontent.getText();
				System.out.println(str_weiboemailcontent);
			}
			public void removeUpdate(DocumentEvent e){
				str_weiboemailcontent=jta_weiboemailcontent.getText();
				System.out.println(str_weiboemailcontent);
			}
			public void changedUpdate(DocumentEvent e){
				str_weiboemailcontent=jta_weiboemailcontent.getText();
				System.out.println(str_weiboemailcontent);
			}
		});
		
		
		
		
		jb_ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=jcb_taskname.getSelectedIndex();
				if(index!=0){
					Runner.task[index-1].set_clockoremail(jcb1.getSelectedIndex());
					Runner.task[index-1].set_weibooremail(jcb2.getSelectedIndex());
					Runner.task[index-1].set_date(str_date);
					Runner.task[index-1].set_time(str_time);
					Runner.task[index-1].set_receiveemail(str_receiveemail);
					Runner.task[index-1].set_emailkey(str_emailkey);
					Runner.task[index-1].set_idoremail(str_idoremail);
					Runner.task[index-1].set_weibokey(str_weibokey);
					Runner.task[index-1].set_weiboemailcontent(str_weiboemailcontent);
					
					
					if(jcb1.getSelectedIndex()==0){
						if(jcb2.getSelectedIndex()==0){
							MainFrame.modify_task(index-1, "在时刻:"+str_date+str_time+"发一条微博", "");
						}
						else if(jcb2.getSelectedIndex()==1){
							MainFrame.modify_task(index-1, "在时刻:"+str_date+str_time+"向邮箱:"+str_idoremail+"发送一封邮件", "");
						}
						else{
							System.out.println("error in jb_ok.addActionListener1");
						}
					}
					else if(jcb1.getSelectedIndex()==1){
						if(jcb2.getSelectedIndex()==0){
							MainFrame.modify_task(index-1, "在邮箱:"+str_receiveemail+"收到邮件后发送一条微博", "");
						}
						else if(jcb2.getSelectedIndex()==1){
							MainFrame.modify_task(index-1, "在邮箱:"+str_receiveemail+"收到邮件后向邮箱:"+str_idoremail+"发送一封邮件", "");
						}
						else{
							System.out.println("error in jb_ok.addActionListener2");
						}
					}
					else{
						System.out.println("error in jb_ok.addActionListener3");
					}
					
					reset();
					window_close();
					
				}
			}
		});
				
				
				
				
				/*Runner.task[Runner.count_task]=new Task(Runner.task[index],jcb1.getSelectedIndex(),str_date,
						str_time,str_receiveemail,str_emailkey,jcb2.getSelectedIndex(),str_idoremail,
						str_weibokey,str_weiboemailcontent);
				
				System.out.print(str_taskname+"   "+jcb1.getSelectedIndex()+"   "+str_date+"   "+
						str_time+"   "+str_receiveemail+"   "+str_emailkey+"   "+jcb2.getSelectedIndex()+"   "+str_idoremail+"   "+
						str_weibokey+"   "+str_weiboemailcontent+"        ");
				System.out.println("jcb1="+jcb1.getSelectedIndex()+"           "+"jcb2="+jcb2.getSelectedIndex());
				
				if(jcb1.getSelectedIndex()==0){
					if(jcb2.getSelectedIndex()==0){
						MainFrame.add_task(str_taskname, "在时刻:"+str_date+str_time+"发一条微博", "");
					}
					else if(jcb2.getSelectedIndex()==1){
						MainFrame.add_task(str_taskname, "在时刻:"+str_date+str_time+"向邮箱:"+str_idoremail+"发送一封邮件", "");
					}
					else{
						System.out.println("error in jb_ok.addActionListener1");
					}
				}
				else if(jcb1.getSelectedIndex()==1){
					if(jcb2.getSelectedIndex()==0){
						MainFrame.add_task(str_taskname, "在邮箱:"+str_receiveemail+"收到邮件后发送一条微博", "");
					}
					else if(jcb2.getSelectedIndex()==1){
						MainFrame.add_task(str_taskname, "在邮箱:"+str_receiveemail+"收到邮件后向邮箱:"+str_idoremail+"发送一封邮件", "");
					}
					else{
						System.out.println("error in jb_ok.addActionListener2");
					}
				}
				else{
					System.out.println("error in jb_ok.addActionListener3");
				}
				
				
				Runner.count_task++;
				Modify_Task_Frame.fresh_taskname(str_taskname);
				
				//System.out.println("Runner.count_task="+Runner.count_task);
				int index=Runner.count_task;
				System.out.println(Runner.task[index-1].get_taskname()+"    "+Runner.task[index-1].get_clockoremail()+"    "+
						Runner.task[index-1].get_date()+"    "+Runner.task[index-1].get_time()+"    "+
						Runner.task[index-1].get_receiveemail()+"    "+Runner.task[index-1].get_emailkey()+"    "+
						Runner.task[index-1].get_weibooremail()+"    "+Runner.task[index-1].get_idoremail()+"    "+
						Runner.task[index-1].get_weibokey()+"    "+Runner.task[index-1].get_weiboemailcontent());
				
				reset();
				window_close();
				
			}*/
		
		
		jb_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window_close();
			}
		});
		
		jb_reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reset();
			}
		});
		
	}
}