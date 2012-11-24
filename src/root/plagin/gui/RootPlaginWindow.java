package root.plagin.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author VadymPivak
 *
 */

public class RootPlaginWindow {

	private JFrame frmTableur;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RootPlaginWindow window = new RootPlaginWindow();
					window.frmTableur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * * Create the application.
	 */
	public RootPlaginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTableur = new JFrame();
		frmTableur.setTitle("TABLEUR");
		frmTableur.setBounds(100, 100, 450, 300);
		frmTableur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmTableur.setJMenuBar(menuBar);

		JButton btnAddplagin = new JButton("AddPlagin");
		btnAddplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddplagin.setForeground(new Color(51, 153, 102));
		menuBar.add(btnAddplagin);

		JButton btnInstallplagin = new JButton("InstallPlagin");
		btnInstallplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInstallplagin.setForeground(new Color(102, 0, 204));
		btnInstallplagin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInstallplagin.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(btnInstallplagin);

		JButton btnDeleteplagin = new JButton("DeletePlagin");
		btnDeleteplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteplagin.setForeground(new Color(255, 0, 0));


		btnInstallplagin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("jar","zip");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(table);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
			}
		});

		menuBar.add(btnDeleteplagin);

		table = new JTable();
		frmTableur.getContentPane().add(table, BorderLayout.CENTER);
	}

}
