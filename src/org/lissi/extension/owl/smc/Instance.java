package org.lissi.extension.owl.smc;

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

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Instance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JComboBox jComboBox0;
	private JTextField jTextField0;
	private JPanel jPanel0;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JPanel jPanel1;
	private JTextField jTextField1;
	private JComboBox jComboBox1;
	private JLabel jLabel4;
	private JComboBox jComboBox2;
	private JButton jButton0;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public Instance() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(43, 10, 10), new Leading(38, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(41, 10, 10), new Leading(78, 12, 12)));
		add(getJComboBox0(), new Constraints(new Leading(105, 116, 10, 10), new Leading(72, 12, 12)));
		add(getJTextField0(), new Constraints(new Leading(105, 113, 10, 10), new Leading(32, 12, 12)));
		add(getJPanel0(), new Constraints(new Leading(43, 402, 10, 10), new Leading(121, 302, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(63, 10, 10), new Leading(443, 10, 10)));
		add(getJComboBox2(), new Constraints(new Leading(165, 197, 10, 10), new Leading(438, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(145, 143, 10, 10), new Leading(491, 10, 10)));
		setSize(451, 544);
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save Instance");
		}
		return jButton0;
	}

	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			jComboBox2.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox2;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Property Name :");
		}
		return jLabel4;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox1;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("jTextField1");
			jTextField1.setAutoscrolls(true);
		}
		return jTextField1;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Description :", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJScrollPane0(), new Constraints(new Leading(-1, 342, 10, 10), new Bilateral(-3, 0, 25)));
		}
		return jPanel1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTextArea0());
		}
		return jScrollPane0;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
			jTextArea0.setText("jTextArea0");
			jTextArea0.setAutoscrolls(true);
		}
		return jTextArea0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Language :");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Name :");
		}
		return jLabel2;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Localized Discription :", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJLabel2(), new Constraints(new Leading(12, 12, 12), new Leading(17, 10, 10)));
			jPanel0.add(getJLabel3(), new Constraints(new Leading(12, 12, 12), new Leading(51, 12, 12)));
			jPanel0.add(getJPanel1(), new Constraints(new Bilateral(7, 0, 0), new Bilateral(79, 0, 0)));
			jPanel0.add(getJTextField1(), new Constraints(new Leading(60, 201, 10, 10), new Leading(11, 70, 79)));
			jPanel0.add(getJComboBox1(), new Constraints(new Leading(83, 174, 10, 10), new Leading(46, 70, 79)));
		}
		return jPanel0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setText("jTextField0");
			jTextField0.setAutoscrolls(true);
		}
		return jTextField0;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Concept :");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Name :");
		}
		return jLabel0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Instance frame = new Instance();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Instance");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
