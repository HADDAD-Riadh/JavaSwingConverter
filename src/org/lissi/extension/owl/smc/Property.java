package org.lissi.extension.owl.smc;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

//VS4E -- DO NOT REMOVE THIS LINE!
public class Property extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JComboBox jComboBox0;
	private JTextField jTextField0;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JComboBox jComboBox2;
	private JTextField jTextField1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel0;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JLabel jLabel5;
	private JTextField jTextField2;
	private JLabel jLabel6;
	private JComboBox jComboBox3;
	private JComboBox jComboBox4;
	private JComboBox jComboBox5;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JPanel jPanel3;
	private JLabel jLabel10;
	private JComboBox jComboBox6;
	private JComboBox jComboBox7;
	private JLabel jLabel11;
	private JComboBox jComboBox8;
	private JButton jButton1;
	private JLabel jLabel13;
	private JComboBox jComboBox9;
	private JLabel jLabel14;
	private JComboBox jComboBox10;
	private JLabel jLabel15;
	private JLabel jLabel2;
	private JLabel jLabel16;
	private JComboBox jComboBox1;
	private JCheckBox jCheckBox0;
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JLabel jLabel17;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public Property() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel1(), new Constraints(new Leading(15, 371, 10, 10), new Leading(15, 506, 10, 10)));
		add(getJPanel2(), new Constraints(new Leading(384, 387, 10, 10), new Leading(17, 504, 12, 12)));
		setSize(792, 570);
	}

	private JLabel getJLabel17() {
		if (jLabel17 == null) {
			jLabel17 = new JLabel();
			jLabel17.setText("--->");
		}
		return jLabel17;
	}

	private JCheckBox getJCheckBox2() {
		if (jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setSelected(true);
			jCheckBox2.setText("List");
		}
		return jCheckBox2;
	}

	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setSelected(true);
			jCheckBox1.setText("Set");
		}
		return jCheckBox1;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setSelected(true);
			jCheckBox0.setText("Functional");
		}
		return jCheckBox0;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox1;
	}

	private JLabel getJLabel16() {
		if (jLabel16 == null) {
			jLabel16 = new JLabel();
			jLabel16.setText("Max :");
		}
		return jLabel16;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Min :");
		}
		return jLabel2;
	}

	private JLabel getJLabel15() {
		if (jLabel15 == null) {
			jLabel15 = new JLabel();
			jLabel15.setText("Literal :");
		}
		return jLabel15;
	}

	private JComboBox getJComboBox10() {
		if (jComboBox10 == null) {
			jComboBox10 = new JComboBox();
			jComboBox10.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox10;
	}

	private JLabel getJLabel14() {
		if (jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setText("Concept :");
		}
		return jLabel14;
	}

	private JComboBox getJComboBox9() {
		if (jComboBox9 == null) {
			jComboBox9 = new JComboBox();
			jComboBox9.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox9;
	}

	private JLabel getJLabel13() {
		if (jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("Inherit :");
		}
		return jLabel13;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Save Property");
		}
		return jButton1;
	}

	private JComboBox getJComboBox8() {
		if (jComboBox8 == null) {
			jComboBox8 = new JComboBox();
			jComboBox8.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox8;
	}

	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Of :");
		}
		return jLabel11;
	}

	private JComboBox getJComboBox7() {
		if (jComboBox7 == null) {
			jComboBox7 = new JComboBox();
			jComboBox7.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox7;
	}

	private JComboBox getJComboBox6() {
		if (jComboBox6 == null) {
			jComboBox6 = new JComboBox();
			jComboBox6.setModel(new DefaultComboBoxModel(new Object[] { "Other", "item1", "item2", "item3" }));
		}
		return jComboBox6;
	}

	private JLabel getJLabel10() {
		if (jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("Composed :");
		}
		return jLabel10;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Property Restriction", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getJLabel8(), new Constraints(new Leading(23, 10, 10), new Leading(12, 12, 12)));
			jPanel3.add(getJLabel2(), new Constraints(new Leading(99, 12, 12), new Leading(12, 12, 12)));
			jPanel3.add(getJLabel16(), new Constraints(new Leading(99, 12, 12), new Leading(42, 12, 12)));
			jPanel3.add(getJComboBox5(), new Constraints(new Leading(143, 81, 12, 12), new Leading(37, 12, 12)));
			jPanel3.add(getJComboBox4(), new Constraints(new Leading(143, 78, 12, 12), new Leading(7, 12, 12)));
			jPanel3.add(getJLabel9(), new Constraints(new Leading(99, 41, 10, 10), new Leading(75, 12, 12)));
			jPanel3.add(getJCheckBox0(), new Constraints(new Leading(16, 10, 10), new Leading(118, 10, 10)));
			jPanel3.add(getJCheckBox1(), new Constraints(new Leading(119, 10, 10), new Leading(118, 12, 12)));
			jPanel3.add(getJCheckBox2(), new Constraints(new Leading(185, 10, 10), new Leading(118, 12, 12)));
			jPanel3.add(getJComboBox1(), new Constraints(new Leading(143, 80, 12, 12), new Leading(69, 12, 12)));
		}
		return jPanel3;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Other :");
		}
		return jLabel9;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Cardinality :");
		}
		return jLabel8;
	}

	private JComboBox getJComboBox5() {
		if (jComboBox5 == null) {
			jComboBox5 = new JComboBox();
			jComboBox5.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox5;
	}

	private JComboBox getJComboBox4() {
		if (jComboBox4 == null) {
			jComboBox4 = new JComboBox();
			jComboBox4.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox4;
	}

	private JComboBox getJComboBox3() {
		if (jComboBox3 == null) {
			jComboBox3 = new JComboBox();
			jComboBox3.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox3;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Value Type ");
		}
		return jLabel6;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("jTextField2");
			jTextField2.setAutoscrolls(true);
		}
		return jTextField2;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Name :");
		}
		return jLabel5;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Property Constraint", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getJLabel5(), new Constraints(new Leading(31, 10, 10), new Leading(44, 10, 10)));
			jPanel2.add(getJTextField2(), new Constraints(new Leading(77, 134, 12, 12), new Leading(38, 12, 12)));
			jPanel2.add(getJLabel10(), new Constraints(new Leading(26, 12, 12), new Leading(372, 10, 10)));
			jPanel2.add(getJButton1(), new Constraints(new Leading(106, 10, 10), new Leading(429, 12, 12)));
			jPanel2.add(getJLabel6(), new Constraints(new Leading(26, 12, 12), new Leading(89, 10, 10)));
			jPanel2.add(getJComboBox3(), new Constraints(new Leading(212, 137, 10, 10), new Leading(81, 10, 10)));
			jPanel2.add(getJLabel14(), new Constraints(new Leading(140, 12, 12), new Leading(89, 12, 12)));
			jPanel2.add(getJComboBox10(), new Constraints(new Leading(212, 136, 12, 12), new Leading(114, 12, 12)));
			jPanel2.add(getJLabel15(), new Constraints(new Leading(142, 12, 12), new Leading(119, 12, 12)));
			jPanel2.add(getJPanel3(), new Constraints(new Leading(7, 348, 10, 10), new Leading(158, 196, 12, 12)));
			jPanel2.add(getJComboBox6(), new Constraints(new Leading(103, 82, 12, 12), new Leading(366, 12, 12)));
			jPanel2.add(getJLabel11(), new Constraints(new Leading(191, 12, 12), new Leading(372, 12, 12)));
			jPanel2.add(getJComboBox7(), new Constraints(new Leading(215, 57, 12, 12), new Leading(366, 12, 12)));
			jPanel2.add(getJLabel17(), new Constraints(new Leading(275, 12, 12), new Leading(369, 12, 12)));
			jPanel2.add(getJComboBox8(), new Constraints(new Leading(296, 55, 10, 10), new Leading(366, 12, 12)));
		}
		return jPanel2;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Action", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJLabel0(), new Constraints(new Leading(29, 10, 10), new Leading(45, 12, 12)));
			jPanel1.add(getJTextField0(), new Constraints(new Leading(81, 145, 12, 12), new Leading(39, 12, 12)));
			jPanel1.add(getJComboBox0(), new Constraints(new Leading(84, 171, 10, 10), new Leading(71, 10, 10)));
			jPanel1.add(getJLabel1(), new Constraints(new Leading(29, 12, 12), new Leading(76, 12, 12)));
			jPanel1.add(getJPanel0(), new Constraints(new Leading(12, 317, 12, 12), new Leading(106, 265, 10, 10)));
			jPanel1.add(getJLabel13(), new Constraints(new Leading(43, 10, 10), new Leading(401, 10, 10)));
			jPanel1.add(getJComboBox9(), new Constraints(new Leading(95, 165, 10, 10), new Leading(396, 12, 12)));
		}
		return jPanel1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Localized Discription", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJScrollPane0(), new Constraints(new Leading(0, 291, 10, 10), new Leading(62, 161, 10, 10)));
			jPanel0.add(getJComboBox2(), new Constraints(new Leading(69, 110, 10, 10), new Leading(32, 10, 10)));
			jPanel0.add(getJLabel3(), new Constraints(new Leading(6, 10, 10), new Leading(4, 12, 12)));
			jPanel0.add(getJLabel4(), new Constraints(new Leading(6, 12, 12), new Leading(38, 12, 12)));
			jPanel0.add(getJTextField1(), new Constraints(new Leading(69, 105, 10, 10), new Leading(0, 24, 12, 12)));
		}
		return jPanel0;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Language :");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Name :");
		}
		return jLabel3;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("jTextField1");
			jTextField1.setAutoscrolls(true);
		}
		return jTextField1;
	}

	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			jComboBox2.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return jComboBox2;
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
			jTextArea0.setText("Description Here");
			jTextArea0.setAutoscrolls(true);
		}
		return jTextArea0;
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
			jLabel1.setText("Domain :");
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
				Property frame = new Property();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Action");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
