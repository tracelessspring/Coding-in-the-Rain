package tracelessspring;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Checkordelete_Task_Frame extends JFrame{
	
	private static String[] task_name;
	private String task_description;
	private static JList jl_taskname;
	private static JTextArea jta_taskdescription;
	
	private JScrollPane scrollpane1;
	private JScrollPane scrollpane2;
	
	public static void fresh_taskname(){
		task_name=new String[Runner.count_task];
		for(int i=0;i<Runner.count_task;i++){
			task_name[i]=Runner.task[i].get_taskname();
		}
		jl_taskname.setListData(task_name);
		jl_taskname.setSelectedIndex(0);
		jta_taskdescription.setText(MainFrame.str_description[0]);
	}
	
	
	public void window_close(){
		setVisible(false);
	}
	
	public void init(){
		task_name=new String[1];
		task_name[0]="当前没有任务";
		task_description="";
		jl_taskname=new JList(task_name);
		scrollpane1=new JScrollPane(jl_taskname);
		
		jta_taskdescription=new JTextArea("",20,20);
		jta_taskdescription.setLineWrap(true);
		jta_taskdescription.setWrapStyleWord(true);
		jta_taskdescription.setEditable(true);
		scrollpane2=new JScrollPane(jta_taskdescription);
	}
	
	public Checkordelete_Task_Frame(){
		init();
		
		JLabel jlb_framename=new JLabel("删除任务",JLabel.CENTER);
		jlb_framename.setFont(new Font("SansSerif",Font.BOLD,24));
		
		JLabel jlb_taskname=new JLabel("任务列表:",JLabel.LEFT);
		JLabel jlb_taskdescription=new JLabel("被选中任务的详细信息:");
		
		
		JButton jb_delete=new JButton("删除");
		JButton jb_exit=new JButton("退出");
		
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(jlb_framename);
		p1.setBounds(25, 15, 350, 40);
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(1,2,5,5));
		p2.add(jlb_taskname);
		p2.add(jlb_taskdescription);
		p2.setBounds(25, 65, 325, 20);
		
		JPanel p3=new JPanel();
		p3.setLayout(new GridLayout(1,2,25,25));
		p3.add(scrollpane1);
		p3.add(scrollpane2);
		//p3.add(jta_taskdescription);
		p3.setBounds(25, 90, 325, 110);
		
		JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(1,2,25,5));
		p4.add(jb_delete);
		p4.add(jb_exit);
		p4.setBounds(100, 225, 175, 25);
		
		setLayout(null);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		setTitle("删除任务");
		setSize(400,300);
		setLocationRelativeTo(null);

		
		jl_taskname.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(jl_taskname.getSelectedIndex()>=0){
					jta_taskdescription.setText(MainFrame.str_description[jl_taskname.getSelectedIndex()*2]);
				}
				
			}
		});
		
		jb_delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=jl_taskname.getSelectedIndex();
				
				for(int i=index;i<Runner.count_task-1;i++){
					Runner.task[i]=Runner.task[i+1];
					MainFrame.str_description[i*2]=MainFrame.str_description[(i+1)*2];
					MainFrame.str_description[i*2+1]=MainFrame.str_description[(i+1)*2+1];
					MainFrame.str_outinfo[i*2]=MainFrame.str_description[(i+1)*2];
					MainFrame.str_outinfo[i*2+1]=MainFrame.str_outinfo[(i+1)*2+1];
				}
				Runner.count_task--;
				MainFrame.task_list.removeItemAt(index+1);
				MainFrame.task_list.setSelectedIndex(0);
				Modify_Task_Frame.delete_taskname(index+1);
				Check_Alltask_Frame.fresh_taskname();
				fresh_taskname();
				jl_taskname.setSelectedIndex(0);
				//window_close();
			}
		});
		
		jb_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jl_taskname.setSelectedIndex(0);
				window_close();
			}
		});
		
	}
	
	
}