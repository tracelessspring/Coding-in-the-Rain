package tracelessspring;
import javax.swing.*;
import java.awt.*;

public class Runner{
	public static Task[] task=new Task[10];
	public static int count_task=0;
	
	public static void main(String[] args){
		JFrame frame=new MainFrame();
		frame.setTitle("MYIFTTT");
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
