import java.awt.Color;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Playlist {
	public static JList text;

	public static JFrame frame;
    public static void open()
    {
        frame = new javax.swing.JFrame( "재생목록" );
      //javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder( "Drop 'em" );
         
         text = new javax.swing.JList();
         text.setListData(MP3.vector);
        frame.getContentPane().add( 
            new javax.swing.JScrollPane( text ), 
            java.awt.BorderLayout.CENTER );
        
        new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {
            	MP3.vector.addElement(files[i].getPath());
                text.setListData(MP3.vector);
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
        
        text.addMouseListener(new PlaylistPlayMP3(MP3.time, MP3.info, MP3.controll, text));

        frame.setBounds( 100, 100, 300, 400 );
        frame.setDefaultCloseOperation( frame.DISPOSE_ON_CLOSE );
        frame.setVisible(true);
    }   // end main

}
