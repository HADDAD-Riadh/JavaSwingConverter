package org.lissi.extension.owl.smc.editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Concept extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	public JTextField jTextField0;
	private JLabel jLabel1;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JComboBox jComboBox0;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JComboBox jComboBox1;
	private JButton jButton0;
	private JLabel jLabel5;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";


	public Concept()
	{

		initComponents();
	}


	private void initComponents()
	{

		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(36, 10, 10), new Leading(44, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(80, 172, 10, 10), new Leading(40, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(88, 12, 12), new Leading(122, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(84, 12, 12), new Leading(154, 10, 10)));
		add(getJComboBox0(), new Constraints(new Leading(144, 117, 10, 10), new Leading(149, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(146, 112, 12, 12), new Leading(116, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(83, 294, 10, 10), new Leading(189, 133, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(36, 132, 10, 10), new Leading(94, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(31, 10, 10), new Leading(372, 10, 10)));
		add(getJComboBox1(), new Constraints(new Leading(83, 235, 10, 10), new Leading(369, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(124, 131, 10, 10), new Leading(440, 10, 10)));
		add(getJLabel5(), new Constraints(new Leading(72, 292, 10, 10), new Leading(12, 20, 12, 12)));
		setSize(417, 544);
	}


	private JLabel getJLabel5()
	{

		if (jLabel5 == null)
		{
			jLabel5 = new JLabel();
		}
		return jLabel5;
	}


	private JButton getJButton0()
	{

		if (jButton0 == null)
		{
			jButton0 = new JButton();
			jButton0.setText("Save Concept");
			jButton0.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event)
				{

					jButton0ActionActionPerformed(event);
				}
			});
		}
		return jButton0;
	}


	private JComboBox getJComboBox1()
	{

		ArrayList<String> dd = new ArrayList<String>();

		if (jComboBox1 == null)
		{
			dd.add("Super concept........");
			for (int i = 0; i < staticClassSmc.actionStatic._SmcConcepts.size(); i++)
			{
				dd.add(staticClassSmc.actionStatic._SmcConcepts.get(i).getUri().toString().substring(staticClassSmc.actionStatic._SmcConcepts.get(i).getUri().toString().indexOf("#") + 1));
				if (dd.contains(getJTextField0().getText()))
					dd.remove(getJTextField0().getText());
			}
			jComboBox1 = new JComboBox(dd.toArray());
		}
		return jComboBox1;
	}


	private JLabel getJLabel4()
	{

		if (jLabel4 == null)
		{
			jLabel4 = new JLabel();
			jLabel4.setText("Inherit :");
		}
		return jLabel4;
	}


	private JTextField getJTextField1()
	{

		if (jTextField1 == null)
		{
			jTextField1 = new JTextField();
			jTextField1.setAutoscrolls(true);
		}
		return jTextField1;
	}


	private JComboBox getJComboBox0()
	{

		if (jComboBox0 == null)
		{
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "fr", "en", "it" }));

		}
		return jComboBox0;
	}


	private JLabel getJLabel3()
	{

		if (jLabel3 == null)
		{
			jLabel3 = new JLabel();
			jLabel3.setText("Language :");
		}
		return jLabel3;
	}


	private JLabel getJLabel2()
	{

		if (jLabel2 == null)
		{
			jLabel2 = new JLabel();
			jLabel2.setText("Name :");
		}
		return jLabel2;
	}


	private JScrollPane getJScrollPane0()
	{

		if (jScrollPane0 == null)
		{
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTextArea0());
		}
		return jScrollPane0;
	}


	private JTextArea getJTextArea0()
	{

		if (jTextArea0 == null)
		{
			jTextArea0 = new JTextArea();
			jTextArea0.setText("jTextArea0");
			jTextArea0.setAutoscrolls(true);
		}
		return jTextArea0;
	}


	private JLabel getJLabel1()
	{

		if (jLabel1 == null)
		{
			jLabel1 = new JLabel();
			jLabel1.setText("Localized Description :");
		}
		return jLabel1;
	}


	private JTextField getJTextField0()
	{

		if (jTextField0 == null)
		{
			jTextField0 = new JTextField();
			jTextField0.setAutoscrolls(true);
		}
		return jTextField0;
	}


	private JLabel getJLabel0()
	{

		if (jLabel0 == null)
		{
			jLabel0 = new JLabel();
			jLabel0.setText("Name :");
		}
		return jLabel0;
	}


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
			@Override
			public void run()
			{

				Concept frame = new Concept();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Concept");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}


	private void jButton0ActionActionPerformed(ActionEvent event)
	{

		if (getJTextField0().getText().isEmpty() || getJTextField0().getText().equals(""))
		{
			getJLabel5().setText("Action name can not be empty");
			getJLabel5().setForeground(Color.red);

		} else
		{
			EditorComponentSmc c = new EditorComponentSmc();

			try
			{

				String language = (String) getJComboBox0().getSelectedItem();
				getJLabel3().setText("");
				// System.out.println(result);
				try
				{
					c.addConcept(getJTextField0().getText(), getJComboBox1().getSelectedItem().toString(), jTextArea0.getText(), language);
					this.dispose();
				} catch (OWLOntologyCreationException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (PropertyVetoException e)
			{
				// TODO Auto-generated catch block
				// getJLabel3().setText("Action Already Exist ");

				e.printStackTrace();
			}
			/*
			 * TextEditor t = TextEditor.getInstance();
			 * t.textArea.setText(LoadSemanticModel.Refresh());
			 */
		}
	}

}
