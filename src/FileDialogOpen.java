import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;


public class FileDialogOpen implements ActionListener {
	JProgressBar time;
	JLabel info;
	JButton controll;

	public FileDialogOpen(JProgressBar time, JLabel info, JButton controll) {
		this.time = time;
		this.info = info;
		this.controll = controll;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser musicfile = new JFileChooser();
		musicfile.setVisible(true);
		musicfile.setFileFilter(new FileNameExtensionFilter("mp3","mp3"));
		musicfile.setMultiSelectionEnabled(false);
		if(musicfile.showOpenDialog(MP3.GUI) == JFileChooser.APPROVE_OPTION) {


            	MP3.vector.addElement(musicfile.getSelectedFile().getPath());
                Playlist.text.setListData(MP3.vector);
			String musicurl = musicfile.getSelectedFile().toString();
			System.out.println(musicurl);
			FileInputStream inf = null;
			File file;
			
			try {
				file = musicfile.getSelectedFile();
				inf = new FileInputStream(musicurl);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(musicfile, "선택한 파일이 존재하지 않습니다.", "알 수 없는 파일", JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {	

                MP3.GUI.setTitle(file.getName().toString());
                info.setText(file.getName().toString());
				MP3.player = new AdvancedPlayer(inf);
				MP3.START = true;
				MP3.player.play();
			} catch (JavaLayerException e) {
				JOptionPane.showMessageDialog(musicfile, "실행하려는 파일이 존재하지 않습니다.", "알 수 없는 파일", JOptionPane.ERROR_MESSAGE);
				return;
			
            }			
		}
	}
}


