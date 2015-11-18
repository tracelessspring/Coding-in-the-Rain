package tracelessspring;
import java.awt.*;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;

public class MainFrame extends JFrame{
	public static JComboBox task_list;
	
	private static Date date;
	private Timer[] timer;
	//private static Receive_Email receive_email=new Receive_Email();
	private Receive_Send_Email receive_send_email=new Receive_Send_Email();
	private Send_Weibo_Message send_weibo_message=new Send_Weibo_Message();
	
	private static JTextArea task_description;
	private static JTextArea output_information;
	
	private Add_Task_Frame addtask;
	private Modify_Task_Frame modifytask;
	private Checkordelete_Task_Frame checkordeletetask;
	private Check_Alltask_Frame checkalltask;
	
	
	private static String[] str_task;
	public static String[] str_description;
	public static String[] str_outinfo;
	
	public void MainFrame_init(){
		addtask=new Add_Task_Frame();
		modifytask=new Modify_Task_Frame();
		checkordeletetask=new Checkordelete_Task_Frame();
		checkalltask=new Check_Alltask_Frame();
		timer=new Timer[10];      //可同时运行十个任务
	}
	
	
	
	public MainFrame(){
		str_task=new String[10];   
		str_description=new String[40];   
		str_outinfo=new String[40];  
		
		
		
		MainFrame_init();
		
		JLabel title=new JLabel("单机版IFTTT");             //标题
		title.setFont(new Font("SansSerif",Font.BOLD,36));                               //设置标题字体
		
		JLabel word1=new JLabel("选择需要运行的任务:");       
		JLabel word2=new JLabel("正在运行的任务描述:");
		JLabel word3=new JLabel("输出信息:");
		
		String[] real_task={"当前没有任务"};
		task_list=new JComboBox(real_task);
		task_list.setForeground(Color.DARK_GRAY);
		
		task_description=new JTextArea("",10,30);
		task_description.setLineWrap(true);
		task_description.setWrapStyleWord(true);
		task_description.setEditable(false);
		JScrollPane scrollPane1=new JScrollPane(task_description);
		
		String direction="使用说明：\n1、首先用户新建任务\n2、然后再选择控制->运行任务来开始任务\n3、可在下列文本域内查看当前任务的完整描述";
		JTextArea user_direction=new JTextArea(direction,25,25);
		user_direction.setLineWrap(true);
		user_direction.setWrapStyleWord(true);
		user_direction.setEditable(false);
		//JScrollPane scrollPane2=new JScrollPane(user_direction);
		
		output_information=new JTextArea("",10,60);
		output_information.setLineWrap(true);
		output_information.setWrapStyleWord(true);
		output_information.setEditable(false);
		JScrollPane scrollPane2=new JScrollPane(output_information);
		
		JMenuBar jmb=new JMenuBar();
		JMenu task=new JMenu("任务");
		JMenu control=new JMenu("控制");
		JMenu help=new JMenu("帮助");
		JMenuItem newTask=new JMenuItem("新建任务...    Ctrl-N");
		JMenuItem modifyTask=new JMenuItem("修改任务...    Ctrl-C");
		JMenuItem deleteTask=new JMenuItem("删除任务...    Ctrl-D");
		JMenuItem checkTask=new JMenuItem("查看所有任务...    Ctrl-V");
		JMenuItem startTask=new JMenuItem("开始任务...    Alt-Y");
		JMenuItem pauseTask=new JMenuItem("暂停任务...    Alt-P");
		JMenuItem endTask=new JMenuItem("结束任务...    Alt-N");
		
		task.add(newTask);
		task.add(modifyTask);
		task.add(deleteTask);
		task.add(checkTask);
		control.add(startTask);
		control.add(pauseTask);
		control.add(endTask);
		
		jmb.add(task);
		jmb.add(control);
		jmb.add(help);
		jmb.setBounds(0, 0, 800, 25);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		
		p1.add(title);
		p1.setBounds(25, 50, 350, 60);
		
		p2.setLayout(new GridLayout(1,2,0,0));
		p2.add(word1);
		p2.add(task_list);
		p2.setBounds(25, 125, 350, 25);

		p3.setLayout(new BorderLayout(5,5));
		p3.add(word2,BorderLayout.NORTH);
		p3.add(scrollPane1,BorderLayout.CENTER);
		//p3.add(task_description,BorderLayout.CENTER);
		p3.setBounds(25,180,350,170);
		
		p4.add(user_direction);
		p4.setBounds(410, 50, 350, 295);
		
		p5.setLayout(new BorderLayout(5,5));
		p5.add(word3,BorderLayout.NORTH);
		p5.add(scrollPane2, BorderLayout.CENTER);
		p5.setBounds(25, 375, 725, 150);
		
		setLayout(null);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(jmb);
		
		newTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addtask.setVisible(true);
			}
		});
		
		modifyTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				modifytask.setVisible(true);
			}
		});
		
		deleteTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				checkordeletetask.setVisible(true);
			}
		});
		
		checkTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				checkalltask.setVisible(true);
			}
		});
		
		startTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				date=new Date();
				final int index=task_list.getSelectedIndex();
				System.out.println("选择开始的任务是:"+Runner.task[index-1].get_taskname());
				str_outinfo[(index-1)*2]="now the Task begins ...";
				output_information.setText(str_outinfo[(index-1)*2]);
				
				if(index>=1){
					if(Runner.task[index-1].get_clockoremail()==0){        //定时器
						if(Runner.task[index-1].get_weibooremail()==0){  //定时发微博
							System.out.println("timer in");
							timer[index-1]=new Timer(23000,new ActionListener(){
								public void actionPerformed(ActionEvent e){
									try {
										System.out.println("timer in again");
										if(Runner.task[index-1].is_equal1(Runner.task[index-1].get_date(),
												Runner.task[index-1].get_time(),Task.get_current_time())){
											send_weibo_message.send_weibo(Runner.task[index-1].get_weiboemailcontent());
											System.out.println("send message successfully1");
											
											str_outinfo[(index-1)*2]="the task successfully finished";
											output_information.setText(str_outinfo[(index-1)*2]);
											timer[index-1].stop();
										}
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});
							timer[index-1].start();     
						}
						else{                                              //定时发邮件
							timer[index-1]=new Timer(17000,new ActionListener(){
								public void actionPerformed(ActionEvent e){
									try {
										System.out.println("timer in");
										
										if(Runner.task[index-1].is_equal1(Runner.task[index-1].get_date(),
												Runner.task[index-1].get_time(),Task.get_current_time())){
											receive_send_email.Send_email(Runner.task[index-1].get_weiboemailcontent(), 
													Runner.task[index-1].get_idoremail());
											str_outinfo[(index-1)*2]="the task successfully finished";
											output_information.setText(str_outinfo[(index-1)*2]);
											timer[index-1].stop();
										}
									} catch (AddressException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ParseException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (MessagingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});
							timer[index-1].start();
						}
					}
					else{
						if(Runner.task[index-1].get_weibooremail()==0){      //收到邮件发微博
							final Date time=Task.get_current_time();
							timer[index-1]=new Timer(31000,new ActionListener(){
								public void actionPerformed(ActionEvent e){
									System.out.println("timer in");
									if(receive_send_email.Receive_email(Runner.task[index-1].get_receiveemail(),
											Runner.task[index-1].get_emailkey(), time)){
										
										System.out.println("get the mail");
										
										send_weibo_message.send_weibo(Runner.task[index-1].get_weiboemailcontent());
										System.out.println("send message successfully2");
										str_outinfo[(index-1)*2]="the task successfully finished";
										output_information.setText(str_outinfo[(index-1)*2]);
										timer[index-1].stop();
									}
								}
							});
							timer[index-1].start();
						}
						else{      //收到邮件发邮件
							final Date time=Task.get_current_time();
							timer[index-1]=new Timer(41000,new ActionListener(){
								public void actionPerformed(ActionEvent e){
									System.out.println("timer in");
									System.out.println("初始设定时间为："+time);
									if(receive_send_email.Receive_email(Runner.task[index-1].get_receiveemail(),
											Runner.task[index-1].get_emailkey(), time)){
										
										System.out.println("get the mail");
										
										try {
											receive_send_email.Send_email(Runner.task[index-1].get_weiboemailcontent(), 
													Runner.task[index-1].get_idoremail());
										} catch (AddressException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (MessagingException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}	
										str_outinfo[(index-1)*2]="the task successfully finished";
										output_information.setText(str_outinfo[(index-1)*2]);
										timer[index-1].stop();
									}
								}
							});
							timer[index-1].start();
						}
					}
				}
			}
		});
		
		
		pauseTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=task_list.getSelectedIndex();
				str_outinfo[(index-1)*2]="now the Task was suspended ...";
				output_information.setText(str_outinfo[(index-1)*2]);
				timer[index-1].stop();
			}
		});
		
		endTask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=task_list.getSelectedIndex();
				str_outinfo[(index-1)*2]="now the Task is over ...";
				output_information.setText(str_outinfo[(index-1)*2]);
				timer[index-1].stop();
			}
		});
		
		
		task_list.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=task_list.getSelectedIndex();
				if(index!=0){
					task_description.setText(str_description[(index-1)*2]);
					output_information.setText(str_outinfo[(index-1)*2]);
				}
				else{
					task_description.setText("");
					output_information.setText("");
				}
			}
		});
		
		
		
	}
	
	public static void add_task(String taskname,String taskdescription,String taskoutinfo){
		task_list.setSelectedIndex(0);
		task_list.addItem(taskname);
		task_list.setSelectedItem(taskname);
		str_description[Runner.count_task*2]=taskdescription;
		str_outinfo[Runner.count_task*2]=taskoutinfo;
		task_description.setText(taskdescription);
		output_information.setText(taskoutinfo);
	}
	
	public static void modify_task(int taskindex,String taskdescription,String taskoutinfo){
		str_description[taskindex*2]=taskdescription;
		str_outinfo[taskindex*2]=taskoutinfo;
		task_description.setText(taskdescription);
		output_information.setText(taskoutinfo);
	}
	
}
