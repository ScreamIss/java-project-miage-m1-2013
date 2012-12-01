package com.plugin.root;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.plugin.activator.PluginActivator;

public class RootPlaginWindow {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(RootPlaginWindow.class);

    private JFrame frmTableur;
    private JTable table;

    private JPanel panel;

    /**
     * Launch the application.
     */
    public void create() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final RootPlaginWindow window = new RootPlaginWindow();
                    window.frmTableur.setVisible(true);
                } catch (final Exception e) {
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

        final JMenuBar menuBar = new JMenuBar();
        frmTableur.setJMenuBar(menuBar);

        final JButton btnAddplagin = new JButton("AddPlagin");
        btnAddplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAddplagin.setForeground(new Color(51, 153, 102));
        menuBar.add(btnAddplagin);

        final JButton btnInstallplagin = new JButton("InstallPlagin");
        btnInstallplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnInstallplagin.setForeground(new Color(102, 0, 204));
        btnInstallplagin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
            }
        });
        btnInstallplagin.setHorizontalAlignment(SwingConstants.LEFT);
        menuBar.add(btnInstallplagin);

        final JButton btnDeleteplagin = new JButton("DeletePlagin");
        btnDeleteplagin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnDeleteplagin.setForeground(new Color(255, 0, 0));


        btnInstallplagin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
               // TODO test
              //  chooser.setCurrentDirectory(new File("/home/tant/workspace/Plugin/DummyPlugin"));


              //  final FileNameExtensionFilter filter = new FileNameExtensionFilter("jar", "zip");
              //  chooser.setFileFilter(filter);
                final int returnVal = chooser.showOpenDialog(table);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    final String path = chooser.getSelectedFile().getAbsolutePath();
                    LOG.info("You chose to open this file '" + path + "'");

                    try {
                        final Class activator = PluginActivator.activate(path);
                        final Object activatorInstance = activator.newInstance();

                        final Class[] paramTypes =
                                new Class[] {String[].class, int.class, int.class};

                        final Method method = activator.getMethod("activate", paramTypes);
                        final Object[] args = new Object[] {
                            new String[] {new String("Name " + System.currentTimeMillis()) },
                            new Integer(1),
                            new Integer(10)
                        };
                        final JComponent pluginComponent =
                                (JComponent) method.invoke(activatorInstance, args);

                        panel.add(pluginComponent);
                        panel.revalidate();
                    } catch (final Exception e1) {
                        LOG.error("Activator error", e1);
                        JOptionPane.showMessageDialog(
                            frmTableur,
                            "Invalid file '" + path + "'",
                            "Activation error",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }




                }
            }
        });

        menuBar.add(btnDeleteplagin);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JTextField("Test"));
        //frmTableur.getContentPane().add(table, BorderLayout.CENTER);
        frmTableur.getContentPane().add(panel, BorderLayout.CENTER);
    }

}
