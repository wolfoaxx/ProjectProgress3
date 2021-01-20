import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class GuitarProjectTest extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTable table;
	private JFrame frame1;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private DefaultTableModel tblmodel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuitarProjectTest frame = new GuitarProjectTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuitarProjectTest() {
		GenreTitle t = new GenreTitle();
		ArrayList<String> arr = t.mySong();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 875, 460);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home Page", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 133, 63));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new MatteBorder(6, 7, 5, 5, (Color) new Color(205, 133, 63)));
		panel_2.setBounds(0, 0, 870, 436);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guitar Learning System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(225, 0, 440, 49);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 93, 86, 27);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblLastName.setBounds(10, 131, 86, 27);
		panel_2.add(lblLastName);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblRace.setBounds(10, 169, 86, 27);
		panel_2.add(lblRace);
		
		JLabel lblSessionTime = new JLabel("Session Time");
		lblSessionTime.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblSessionTime.setBounds(10, 207, 86, 27);
		panel_2.add(lblSessionTime);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(121, 99, 131, 20);
		panel_2.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(121, 137, 131, 20);
		panel_2.add(tfLastName);
		
		JComboBox cbRace = new JComboBox();
		cbRace.setModel(new DefaultComboBoxModel(new String[] {"Please Select:", "Malay", "Indian", "Chinese", "Other"}));
		cbRace.setBounds(121, 175, 131, 20);
		panel_2.add(cbRace);
		
		JComboBox cbSessionTime = new JComboBox();
		cbSessionTime.setModel(new DefaultComboBoxModel(new String[] {"Please Select:", "1Hour", "2Hours", "3Hours", "4Hours"}));
		cbSessionTime.setBounds(121, 213, 131, 20);
		panel_2.add(cbSessionTime);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
						tfFirstName.getText(),
						tfLastName.getText(),
						cbRace.getSelectedItem(),
						cbSessionTime.getSelectedItem(),
					
						
					
		
				
				});
				
				if (table.getSelectedRow() == -1) {
					if(table.getRowCount()== 0) {
						JOptionPane.showMessageDialog(null, "Information Update!","Guitar Learning System",
								JOptionPane.OK_OPTION);
					}
				}
			}
		});
			
		
		btnNewButton.setBounds(10, 259, 102, 34);
		panel_2.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfFirstName.setText("");
				tfLastName.setText("");
				cbRace.setSelectedItem("Please Select:");
				cbSessionTime.setSelectedItem("Please Select:");
				
			}
		});
		btnReset.setBounds(147, 259, 102, 34);
		panel_2.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 99, 501, 247);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Race", "Session Time"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No data available","Guitar Learning System",
								JOptionPane.OK_OPTION);}
					else {
						JOptionPane.showMessageDialog(null, "Select a row to delete","Guitar Learning System",
								JOptionPane.OK_OPTION);}
				}
				
					else {
						model.removeRow(table.getSelectedRow());
						
					
				}
			}
		});
		
		btnDelete.setBounds(82, 304, 102, 34);
		panel_2.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Import Saved Data");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filePath="C:\\Users\\yon\\git\\ProjectProgress2\\ProjectTest\\test.txt";
				File file = new File(filePath);
				
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object[] lines =br.lines().toArray();
					
					for(int i = 0; i<lines.length; i++) {
						String[] row=lines[i].toString().split(" ");
						model.addRow(row);
					}
					
				}
			
			catch(FileNotFoundException ex){
					Logger.getLogger(GuitarProjectTest.class.getName()).log(Level.SEVERE,null,ex);
					
			}
			}
		});
		btnNewButton_1.setBounds(329, 357, 143, 34);
		panel_2.add(btnNewButton_1);
		
		JButton btnPrint = new JButton("Save");
		btnPrint.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath="C:\\Users\\yon\\git\\ProjectProgress2\\ProjectTest\\test.txt";
				File file = new File(filePath);
				
				try {
					FileWriter fw=new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i= 0; i<table.getRowCount(); i++) {
						for(int j=0; j<table.getColumnCount();j++) {
							bw.write(table.getValueAt(i, j).toString()+" ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
				} catch(IOException ex) {
					Logger.getLogger(GuitarProjectTest.class.getName()).log(Level.SEVERE,null,ex);
				}
				
				
			}
		});
		btnPrint.setBounds(482, 357, 143, 34);
		panel_2.add(btnPrint);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame1 = new JFrame();
				if (JOptionPane.showConfirmDialog(frame1, "Are You Sure To Exit This Cool Website?","Guitar Learning System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					
				}
			}
		});
		btnNewButton_2.setBounds(771, 402, 89, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back to Main Menu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(255, 165, 0));
		btnNewButton_3.setBounds(10, 391, 143, 34);
		panel_2.add(btnNewButton_3);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 0, 0));
		panel_12.setBounds(0, 52, 870, 30);
		panel_2.add(panel_12);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_12.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setText("A System That Teach You To Master In All Genre "+arr.toString());
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Guitar Strings", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(205, 133, 63));
		panel_3.setBounds(0, 0, 870, 436);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Knowing Your Guitar Strings\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(10, 11, 471, 37);
		panel_3.add(lblNewLabel_2);
		
		JLabel GuitarImage = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/guitarStrings1.png")).getImage();
		GuitarImage.setIcon(new ImageIcon(img));
		GuitarImage.setBounds(292, 47, 250, 185);
		panel_3.add(GuitarImage);
		
		JTextPane txtpnSaduCanEven = new JTextPane();
		txtpnSaduCanEven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnSaduCanEven.setText("The order is EADGBE, from the lowest (bottom) string to the highest. Before you begin to really commit this to heart, it might be helpful to have some phrases to match the acronym. Here's a few popular ones:\r\n\r\n-Eddie Ate Dynamite Good Bye Eddie\r\n-Elephants And Donkeys Grow Big Ears\r\n-Eventually America Defied Great Britain's Empire\r\n-Eat All Day Go to Bed Early");
		txtpnSaduCanEven.setBackground(new Color(255, 165, 0));
		txtpnSaduCanEven.setForeground(new Color(0, 0, 0));
		txtpnSaduCanEven.setBounds(0, 239, 870, 146);
		panel_3.add(txtpnSaduCanEven);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Chord", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(205, 133, 63));
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		panel_5.setBounds(0, 0, 870, 436);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Guitar Chord");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(10, 11, 191, 57);
		panel_5.add(lblNewLabel_3);
		
		JTextPane txtpnOneOfThe = new JTextPane();
		txtpnOneOfThe.setBackground(new Color(255, 165, 0));
		txtpnOneOfThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnOneOfThe.setText("One of the first skills that all guitarists learn is how to read a chord diagram. These diagrams are very helpful when it comes to showing chord shapes and their fingerings. Fortunately for us, it\u2019s also a very easy skill to pick up and you\u2019ll be reading chord diagrams like a pro by the end of this lesson!\r\n\r\n");
		txtpnOneOfThe.setBounds(0, 59, 870, 66);
		panel_5.add(txtpnOneOfThe);
		
		JLabel Estring = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/Estring1.png")).getImage();
		Estring.setIcon(new ImageIcon(img1));
		Estring.setBounds(20, 127, 140, 201);
		panel_5.add(Estring);
		
		JLabel Dstring = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("/Dstring.png")).getImage();
		Dstring.setIcon(new ImageIcon(img2));
		Dstring.setBounds(170, 127, 140, 201);
		panel_5.add(Dstring);
		
		JLabel chord = new JLabel("");
		Image img3= new ImageIcon(this.getClass().getResource("/chord1.png")).getImage();
		chord.setIcon(new ImageIcon(img3));
		chord.setBounds(317, 121, 494, 207);
		panel_5.add(chord);
		
		JTextPane txtpnTheNumbersAre = new JTextPane();
		txtpnTheNumbersAre.setText("The numbers are telling you which finger you are going to use. The fingers on your left hand are numbered from one through four. Here is what each number represents:\r\n1 - Index Finger || 2 - Middle Finger || 3 - Ring Finger || 4 - Pinky Finger\r\n\r\n\r\n");
		txtpnTheNumbersAre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnTheNumbersAre.setBackground(new Color(255, 165, 0));
		txtpnTheNumbersAre.setBounds(0, 328, 870, 77);
		panel_5.add(txtpnTheNumbersAre);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Strumming", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(205, 133, 63));
		panel_7.setBounds(0, 0, 870, 436);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("HOW TO STRUM?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(10, 11, 374, 56);
		panel_7.add(lblNewLabel_4);
		
		JTextPane txtpnWhileItsImportant = new JTextPane();
		txtpnWhileItsImportant.setText("While it\u2019s important to learn the rudiments and scales when you\u2019re learning to play the guitar, the fun part is when you can start strumming. With a little practice and proper technique, you might be able to start playing songs you recognize sooner than you think\r\n\r\n");
		txtpnWhileItsImportant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnWhileItsImportant.setBackground(new Color(255, 165, 0));
		txtpnWhileItsImportant.setBounds(0, 78, 860, 66);
		panel_7.add(txtpnWhileItsImportant);
		
		JLabel Strum = new JLabel("");
		Image img4= new ImageIcon(this.getClass().getResource("/guitarstrum.png")).getImage();
		Strum.setIcon(new ImageIcon(img4));
		Strum.setBounds(27, 155, 268, 168);
		panel_7.add(Strum);
		
		JLabel patternGuide = new JLabel("");
		Image img5= new ImageIcon(this.getClass().getResource("/patternguide2.png")).getImage();
		patternGuide.setIcon(new ImageIcon(img5));
		patternGuide.setBounds(684, 158, 166, 72);
		panel_7.add(patternGuide);
		
		JTextPane txtpnThisIsThe = new JTextPane();
		txtpnThisIsThe.setText("This is the example of strumming up and down on the guitar.");
		txtpnThisIsThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnThisIsThe.setBackground(new Color(255, 165, 0));
		txtpnThisIsThe.setBounds(26, 334, 269, 44);
		panel_7.add(txtpnThisIsThe);
		
		JTextPane txtpnStrummingGuide = new JTextPane();
		txtpnStrummingGuide.setText("Strumming guide");
		txtpnStrummingGuide.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnStrummingGuide.setBackground(new Color(255, 165, 0));
		txtpnStrummingGuide.setBounds(711, 241, 115, 25);
		panel_7.add(txtpnStrummingGuide);
		
		JLabel pattern1 = new JLabel("");
		Image img6= new ImageIcon(this.getClass().getResource("/patterndown.png")).getImage();
		pattern1.setIcon(new ImageIcon(img6));
		pattern1.setBounds(315, 164, 359, 66);
		panel_7.add(pattern1);
		
		JLabel pattern2 = new JLabel("New label");
		Image img7= new ImageIcon(this.getClass().getResource("/patternupdown.png")).getImage();
		pattern2.setIcon(new ImageIcon(img7));
		pattern2.setBounds(315, 255, 359, 66);
		panel_7.add(pattern2);
		
		JLabel pattern3 = new JLabel("New label");
		Image img8= new ImageIcon(this.getClass().getResource("/pattern3.png")).getImage();
		pattern3.setIcon(new ImageIcon(img8));
		pattern3.setBounds(315, 341, 359, 63);
		panel_7.add(pattern3);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Songs", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(205, 133, 63));
		panel_9.setBounds(0, 0, 870, 432);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblSongsTutorial = new JLabel("Songs Tutorial");
		lblSongsTutorial.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSongsTutorial.setBounds(10, 11, 194, 43);
		panel_9.add(lblSongsTutorial);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 117, 404, 304);
		panel_9.add(scrollPane_1);
		
		JTextPane txtpndaHey = new JTextPane();
		txtpndaHey.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtpndaHey.setBackground(new Color(255, 165, 0));
		txtpndaHey.setText("(D)               (A)\r\nhey Jude dont make it bad.\r\n       (G)                  (D)\r\ntake a sad song and make it better\r\n   (G)                       (D)\r\nremember to let her into your heart\r\n              (A)             (D)\r\nthen you can start to make it better\r\n \r\n \r\n     (D)           (A)\r\nhey Jude dont be afraid\r\n          (G)               (D)\r\nyou were made to go out and get her\r\n    (G)                        (D)\r\nthe minute you let her under your skin\r\n              (A)              (D)\r\nthen you can start to make it better\r\n \r\n \r\n(D7)                      (G)           (Em)\r\nand anytime you feel the pain hey Jude refrain\r\n               (A7)             (D)      (D7)\r\ndont carry the world upon your shoulders\r\n                             (G)               (Em)\r\nfor well you know that its a fool who plays it cool\r\n               (A7)              (D)\r\nby making his world a little bit colder\r\n          (D)        (D7)           (A7)\r\nnahh nahh nahh nahh nahh nahh nahh nahh\r\n \r\n \r\n    (D)              (A)\r\nhey Jude dont let me down\r\n         (G)                  (D)\r\nyou have found her now go and get her\r\n    (G)                       (D)\r\nremember to let her into your heart \r\n              (A)              (D)\r\nthen you can start to make it better\r\n \r\n \r\n(D7)                     (G)          (Em)\r\nso let it out and let it in hey Jude begin\r\n             (A7)              (D)        (D7)\r\nyour waiting for someone to perform with\r\n                                (G)                (Em)\r\nand dont you know that its just you hey Jude you'll do\r\n                 (A7)             (D)\r\nthe movement you need is on your shoulder\r\n           (D)       (D7)            (A7)\r\nnahh nahh nahh nahh nahh nahh nahh nahh\r\n \r\n \r\n    (D)               (A)\r\nhey jude dont make it bad\r\n       (G)                  (D)\r\ntake a sad song and make it better\r\n     (G)                      (D)\r\nremember to let her under your skin\r\n              (A)              (D)\r\nthen you can start to make it better\r\n \r\n \r\n(D)            (C)        (G)            (D)\r\nnahh nahh nahh nanananahh nanananahh hey Jude (repeat several times)");
		scrollPane_1.setViewportView(txtpndaHey);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 0, 0));
		panel_10.setBounds(63, 80, 300, 26);
		panel_9.add(panel_10);
		
		JLabel lblHeyJudeBy = new JLabel("Hey Jude by The Beatles");
		lblHeyJudeBy.setForeground(new Color(255, 255, 255));
		panel_10.add(lblHeyJudeBy);
		lblHeyJudeBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(477, 80, 339, 26);
		panel_9.add(panel_11);
		
		JLabel lblKnockinOnHeavens = new JLabel("Knockin On Heavens Door by Bob Dylan");
		lblKnockinOnHeavens.setForeground(Color.WHITE);
		lblKnockinOnHeavens.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_11.add(lblKnockinOnHeavens);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(441, 117, 419, 304);
		panel_9.add(scrollPane_2);
		
		JTextPane txtpnintroGD = new JTextPane();
		txtpnintroGD.setBackground(new Color(255, 165, 0));
		txtpnintroGD.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtpnintroGD.setText("[Intro]\r\nG D Am\r\nG D C\r\n \r\n[Verse]\r\nG              D            Am\r\nMama take this badge off of me\r\nG       D         C\r\nI can't use it anymore\r\nG            D                        Am\r\nIt's getting dark, too dark to see\r\nG          D                   C\r\nI feel I'm knockin on heaven's door\r\n \r\n[Chorus]\r\nG             D                    Am\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    C\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    Am\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    C\r\nKnock, knock, knockin' on heaven's door\r\n \r\n[Verse]\r\nG           D           Am\r\nMama put my guns in the ground\r\nG       D             C\r\nI can't shoot them anymore\r\nG               D               Am\r\nThat long black cloud is comin' down\r\nG          D                    C\r\nI feel I'm knockin' on heaven's door\r\n \r\n[Chorus]\r\nG             D                    Am\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    C\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    Am\r\nKnock, knock, knockin' on heaven's door\r\nG             D                    C\r\nKnock, knock, knockin' on heaven's door\r\n \r\n[Outro]\r\nG    D    Am\r\n Oo - oo - oo - oo\r\n \r\nG");
		scrollPane_2.setViewportView(txtpnintroGD);
		
		JScrollPane sp = new JScrollPane(textPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(sp);
		
	}
}
