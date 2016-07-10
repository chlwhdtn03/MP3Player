import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class PlaylistPlayMP3 implements MouseListener {
	JProgressBar time;
	JLabel info;
	JButton controll;
	JList text;
	
	public PlaylistPlayMP3(JProgressBar time, JLabel info, JButton controll,JList text) {
		this.time = time;
		this.info = info;
		this.controll = controll;
		this.text = text;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		File file = new File(text.getSelectedValue().toString());
		if(file.getName().endsWith(".mp3")) {
			if(arg0.getClickCount() == 2) {	    
			MP3.GUI.setTitle(file.getName());
			info.setText(file.getName());
			while(true) {
			try {
		    System.out.println(file.getPath());
			FileInputStream inf = new FileInputStream(file);
			MP3.player = new AdvancedPlayer(inf);
			MP3.START = true;
			MP3.player.play();
			} catch (JavaLayerException | FileNotFoundException e) {
				JOptionPane.showMessageDialog(Playlist.frame, "실행하려는 파일이 존재하지 않습니다.", "알 수 없는 파일", JOptionPane.ERROR_MESSAGE);
				return;
			}
			}
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(Playlist.frame, "MP3 형식이 아닙니다.", "MP3 파일", JOptionPane.ERROR_MESSAGE);
		}
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
