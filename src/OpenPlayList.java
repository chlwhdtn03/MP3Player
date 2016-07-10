import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenPlayList implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(!Playlist.frame.isShowing()) { 
		Playlist.open();
		} else {
		Playlist.frame.show();
		}
	}

}
