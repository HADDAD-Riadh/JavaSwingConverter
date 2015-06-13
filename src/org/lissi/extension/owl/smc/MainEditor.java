package org.lissi.extension.owl.smc;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.GroupLayout;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import com.lissi.parisest.readontology.imp.ImportSmcFile;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MainEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem jMenuItem0;
	private JMenuItem jMenuItem3;
	private JMenu jMenu0;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JMenuItem jMenuItem2;
	private JMenu jMenu2;
	private JMenuBar jMenuBar0;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public MainEditor()
	{
setContentPane(new ImagePanel("riadh.png"));

		initComponents();
	}


	private void initComponents() {
		setLayout(new GroupLayout());
		setJMenuBar(getJMenuBar0());
		setSize(320, 240);
	}


	private JMenuBar getJMenuBar0()
	{

		if (jMenuBar0 == null)
		{
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getJMenu0());
			jMenuBar0.add(getJMenu1());
			jMenuBar0.add(getJMenu2());
		}
		return jMenuBar0;
	}


	private JMenu getJMenu2()
	{

		if (jMenu2 == null)
		{
			jMenu2 = new JMenu();
			jMenu2.setText("?");
			jMenu2.add(getJMenuItem2());
		}
		return jMenu2;
	}


	private JMenuItem getJMenuItem2()
	{

		if (jMenuItem2 == null)
		{
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Version 1.0");

		}
		return jMenuItem2;
	}


	private JMenu getJMenu1()
	{

		if (jMenu1 == null)
		{
			jMenu1 = new JMenu();
			jMenu1.setText("About");
			jMenu1.add(getJMenuItem1());
		}
		return jMenu1;
	}


	private JMenuItem getJMenuItem1()
	{

		if (jMenuItem1 == null)
		{
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("LissiOwlSmc Documentation");
			jMenuItem1.addActionListener(new MenuActionListenerOpenFile());

		}
		return jMenuItem1;
	}


	private JMenu getJMenu0()
	{

		if (jMenu0 == null)
		{
			jMenu0 = new JMenu();
			jMenu0.setText("File");
			jMenu0.add(getJMenuItem0());
			jMenu0.add(getJMenuItem3());
		}
		return jMenu0;
	}


	private JMenuItem getJMenuItem3()
	{

		if (jMenuItem3 == null)
		{
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Import Owl File");
			jMenuItem3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event)
				{

					try
					{
						jMenuItem0ActionActionPerformed(event);
					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

		}
		return jMenuItem3;
	}


	private JMenuItem getJMenuItem0()
	{

		if (jMenuItem0 == null)
		{
			jMenuItem0 = new JMenuItem();
			jMenuItem0.setText("Import Smc File");
			jMenuItem0.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event)
				{

					try
					{
						jMenuItem0ActionActionPerformed2(event);
					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		return jMenuItem0;
	}


	@SuppressWarnings("unused")
	private static void installLnF()
	{

		try
		{
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e)
		{
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL + " on this platform:" + e.getMessage());
		}
	}


	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void main(String[] args)
	{

		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run()
			{

				final MainEditor frame = new MainEditor();
				frame.setTitle("Lissi Smc Owl Editor");
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				
				ImagePanel panel = new ImagePanel(new ImageIcon("riadh.png").getImage());

				   
				    frame.getContentPane().add(panel);
			    	frame.addWindowListener(new java.awt.event.WindowAdapter() {

					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent)
					{

					if (JOptionPane.showConfirmDialog(frame, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
						{
							System.exit(0);
						}
					}
				});
			}
		});
	}


	private void jMenuItem0ActionActionPerformed(ActionEvent event)
	{

		EditorComponent d = new EditorComponent();
		try
		{
			d.afficher();

		} catch (OWLOntologyCreationException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PropertyVetoException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	private void jMenuItem0ActionActionPerformed2(ActionEvent event) throws Exception
	{

		ImportSmcFile d = new ImportSmcFile();
		try
		{
			d.afficher();

		} catch (OWLOntologyCreationException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PropertyVetoException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class MenuActionListenerOpenFile implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			try
			{
				File file = new File(getClass().getResource("/resources/Documentation.pdf").toURI());
				Desktop.getDesktop().open(file);
			} catch (Exception eee)
			{
				eee.printStackTrace();
			}

		}
	}

}
