package notepad;

//
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
//import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Notepad extends JFrame implements ActionListener {
	JTextArea area;
	JScrollPane pane;
	JMenuBar menubar;
	String text;

	Notepad() {
		setBounds(0, 0, 1700, 8500);

		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");

		JMenuItem newdoc = new JMenuItem("New");
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newdoc.addActionListener(this);

		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		open.addActionListener(this);

		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.addActionListener(this);

		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		print.addActionListener(this);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		exit.addActionListener(this);

		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		JMenu edit = new JMenu("Edit");

		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copy.addActionListener(this);

		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cut.addActionListener(this);

		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		paste.addActionListener(this);

		JMenuItem selectall = new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);

		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectall);

		JMenu help = new JMenu("Help");

		JMenuItem about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		about.addActionListener(this);

		help.add(about);

		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);

		setJMenuBar(menubar);

		area = new JTextArea();

		pane = new JScrollPane(area);
		area.setFont(new Font("SAND_SERIF", Font.PLAIN, 20));

		pane.setBorder(BorderFactory.createEmptyBorder());

		add(pane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		int n = 0;
		if (s.equals("New"))
			n = 1;
		else if (s.equals("Open"))
			n = 2;
		else if (s.equals("Save"))
			n = 3;
		else if (s.equals("Print"))
			n = 4;
		else if (s.equals("Exit"))
			n = 5;
		else if (s.equals("Copy"))
			n = 6;
		else if (s.equals("Cut"))
			n = 7;
		else if (s.equals("Paste"))
			n = 8;
		else if (s.contentEquals("Select All"))
			n = 9;
		else if (s.contentEquals("About"))
			n = 10;
		switch (n) {
		case (1):
			area.setText("");
			break;
		case (2):
			JFileChooser chooser = new JFileChooser();

			chooser.setAcceptAllFileFilterUsed(false);

			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only txt files", "txt");

			chooser.addChoosableFileFilter(restrict);

			int Action = chooser.showOpenDialog(this);

			if (Action != JFileChooser.APPROVE_OPTION)
				return;
			File f = chooser.getSelectedFile();
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				area.read(br, null);
			} catch (Exception exc) {
			}
			break;
		case (3):
			JFileChooser saveas = new JFileChooser();

			saveas.setApproveButtonText("Save");

			int action = saveas.showOpenDialog(this);

			if (action != JFileChooser.APPROVE_OPTION)
				return;

			File file = new File(saveas.getSelectedFile() + ".txt");

			BufferedWriter outfile = null;

			try {
				outfile = new BufferedWriter(new FileWriter(file));
				area.write(outfile);
			} catch (Exception excp) {
			}
			break;
		case (4):
			try {
				area.print();
			} catch (Exception ex) {
			}
			break;
		case (5):
			System.exit(0);
			break;
		case (6):
			text = area.getSelectedText();
			break;
		case (7):
			text = area.getSelectedText();
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
			break;
		case (8):
			area.insert(text, area.getCaretPosition());
			break;
		case (9):
			area.selectAll();
			break;
		case (10):
			new About().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Notepad().setVisible(true);

	}

}
