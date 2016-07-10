import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class MP3 {
	public static boolean START = false;
	public static JFrame GUI;
	static JProgressBar time;
	static JLabel info;
	static JButton controll;
	public static AdvancedPlayer player;
	public static Vector vector = new Vector<>();
	
	public static void main(String[] args)
	{
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {}
		
		Font font = new Font("맑은 고딕", Font.BOLD, 11);
	    GUI = new JFrame("Media Player");
		GUI.setFont(font);
		GUI.setSize(300, 135);
		GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GUI.setLayout(new FlowLayout());
		
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem open = new JMenuItem("열기");
		JMenuItem musicbox = new JMenuItem("재생목록");
		
		GUI.setJMenuBar(bar);
		bar.add(file);
		file.add(open);
		file.addNotify();
		file.add(musicbox);
		
		time = new JProgressBar();
		info = new JLabel();
		controll = new JButton("중지");
		
		time.setEnabled(true);
		
		GUI.add(info);
		GUI.add(time);
		GUI.add(controll);
		GUI.setVisible(true);
		
		Playlist.open();
		
		open.addActionListener(new FileDialogOpen(time, info, controll));
		musicbox.addActionListener(new OpenPlayList());
        
		time.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(START) {
				int mouseX = e.getX(); 
				int progressBarVal = (int)Math.round(((double)mouseX / (double)time.getWidth()) * time.getMaximum());
			    time.setValue(progressBarVal);
				}
			}
		});

	}
}
