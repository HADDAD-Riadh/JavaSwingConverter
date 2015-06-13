package org.lissi.extension.owl.smc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import staticClass.actionStatic;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Action extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox0;
	private JTextField jTextField0;
	private JLabel jLabel2;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox1;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox2;
	private JLabel jLabel4;
	private JPanel jPanel0;
	private JButton jButton0;
	private JPanel jPanel1;
	private JLabel jLabel3;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";


	public Action()
	{

		initComponents();
	}


	private void initComponents()
	{

		setTitle("Add Action");
		setLayout(new GroupLayout());
		add(getJPanel1(), new Constraints(new Leading(15, 357, 10, 10), new Leading(14, 507, 10, 10)));
		setSize(388, 530);
	}


	private JLabel getJLabel3()
	{

		if (jLabel3 == null)
		{
			// jLabel3.setBackground(bg)(Color.red);
			jLabel3 = new JLabel();
			jLabel3.setBackground(Color.red);
		}
		return jLabel3;
	}


	private JPanel getJPanel1()
	{

		if (jPanel1 == null)
		{
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Action", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJLabel0(), new Constraints(new Leading(29, 10, 10), new Leading(45, 12, 12)));
			jPanel1.add(getJLabel1(), new Constraints(new Leading(29, 12, 12), new Leading(76, 12, 12)));
			jPanel1.add(getJLabel2(), new Constraints(new Leading(31, 10, 10), new Leading(109, 12, 12)));
			jPanel1.add(getJPanel0(), new Constraints(new Leading(7, 317, 10, 10), new Leading(140, 265, 10, 10)));
			jPanel1.add(getJButton0(), new Constraints(new Leading(81, 171, 12, 12), new Leading(433, 10, 10)));
			jPanel1.add(getJTextField0(), new Constraints(new Leading(81, 174, 12, 12), new Leading(39, 12, 12)));
			jPanel1.add(getJComboBox1(), new Constraints(new Leading(84, 170, 12, 12), new Leading(104, 12, 12)));
			jPanel1.add(getJComboBox0(), new Constraints(new Leading(84, 171, 12, 12), new Leading(72, 12, 12)));
			jPanel1.add(getJLabel3(), new Constraints(new Leading(48, 263, 10, 10), new Leading(8, 21, 10, 10)));
		}
		return jPanel1;
	}


	private JButton getJButton0()
	{

		if (jButton0 == null)
		{
			jButton0 = new JButton();
			jButton0.setText("Add Action");
			jButton0.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event)
				{

					jButton0ActionActionPerformed(event);
				}
			});
		}
		return jButton0;
	}


	private JPanel getJPanel0()
	{

		if (jPanel0 == null)
		{
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Localized Discription", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJComboBox2(), new Constraints(new Leading(92, 110, 10, 10), new Leading(3, 10, 10)));
			jPanel0.add(getJLabel4(), new Constraints(new Leading(12, 12, 12), new Leading(8, 12, 12)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Leading(0, 291, 10, 10), new Leading(35, 188, 12, 12)));
		}
		return jPanel0;
	}


	private JLabel getJLabel4()
	{

		if (jLabel4 == null)
		{
			jLabel4 = new JLabel();
			jLabel4.setText("Language :");
		}
		return jLabel4;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getJComboBox2()
	{

		if (jComboBox2 == null)
		{
			jComboBox2 = new JComboBox();
			jComboBox2.setModel(new DefaultComboBoxModel(new Object[] { "fr", "en", "it" }));
		}
		return jComboBox2;
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
			jTextArea0.setText("Description Here");
			jTextArea0.setAutoscrolls(true);
		}
		return jTextArea0;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getJComboBox1()
	{

		if (jComboBox1 == null)
		{
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "Physical", "Logical" }));
		}
		return jComboBox1;
	}


	private JLabel getJLabel2()
	{

		if (jLabel2 == null)
		{
			jLabel2 = new JLabel();
			jLabel2.setText("Type :");
		}
		return jLabel2;
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


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getJComboBox0()
	{

		ArrayList<String> dd = new ArrayList<String>();
		if (jComboBox0 == null)
		{
			for (int i = 0; i < actionStatic._owlMicroConceptList.size(); i++)
			{
				dd.add(actionStatic._owlMicroConceptList.get(i).getUri().toString().substring(actionStatic._owlMicroConceptList.get(i).getUri().toString().toString().indexOf("#") + 1, actionStatic._owlMicroConceptList.get(i).getUri().toString().length()));
			}

			jComboBox0 = new JComboBox(dd.toArray());

			// jComboBox0.setModel(new DefaultComboBoxModel(new Object[] {
			// "System", "Appliance", "Plate", "Dish" }));
		}
		return jComboBox0;
	}


	private JLabel getJLabel1()
	{

		if (jLabel1 == null)
		{
			jLabel1 = new JLabel();
			jLabel1.setText("Domain :");
		}
		return jLabel1;
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
			@Override
			public void run()
			{

				Action frame = new Action();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Action");
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
			getJLabel3().setText("Action name can not be empty");
			getJLabel3().setForeground(Color.red);

		} else
		{
			EditorComponent c = new EditorComponent();

			try
			{
				String result = (String) getJComboBox0().getSelectedItem();
				String language = (String) getJComboBox2().getSelectedItem();
				String actiontype = (String) getJComboBox1().getSelectedItem();
				getJLabel3().setText("");
				// System.out.println(result);
				try
				{
					c.addAction(getJTextField0().getText(), jTextArea0.getText(), result, language, actiontype);
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
