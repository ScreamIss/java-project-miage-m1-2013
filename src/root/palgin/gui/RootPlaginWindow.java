package root.palgin.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RootPlaginWindow {

	private JFrame frmTableur;

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

	/**
	 * Create the application.
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
		btnInstallplagin.setForeground(new Color(255, 255, 0));
		btnInstallplagin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInstallplagin.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(btnInstallplagin);
		
		JButton btnDeleteplagin = new JButton("DeletePlagin");
		btnDeleteplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteplagin.setForeground(new Color(255, 0, 0));
		btnDeleteplagin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnDeleteplagin);
	}

}
