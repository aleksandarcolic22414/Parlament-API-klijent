package parlament.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import parlament.gui.models.ParlamentTableModel;

public class ParlamentGUI extends JFrame {

	private JPanel contentPane;
	private JPanel pnlCentral;
	private JScrollPane scrollPane;
	private JTable tblParlamentTable;
	private JPanel pnlEast;
	private JButton btnGetMembers;
	private JButton btnFillTable;
	private JButton btnUpdateMembers;
	private JPanel pnlSouth;
	private JScrollPane scrollPane_1;
	private JTextArea txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParlamentGUI frame = new ParlamentGUI();
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
	public ParlamentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlCentral(), BorderLayout.CENTER);
		contentPane.add(getPnlEast(), BorderLayout.EAST);
		contentPane.add(getPnlSouth(), BorderLayout.SOUTH);
	}

	private JPanel getPnlCentral() {
		if (pnlCentral == null) {
			pnlCentral = new JPanel();
			pnlCentral.setLayout(new BorderLayout(0, 0));
			pnlCentral.add(getScrollPane());
		}
		return pnlCentral;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTblParlamentTable());
		}
		return scrollPane;
	}
	private JTable getTblParlamentTable() {
		if (tblParlamentTable == null) {
			tblParlamentTable = new JTable();
			tblParlamentTable.setModel(new ParlamentTableModel());
		}
		return tblParlamentTable;
	}
	private JPanel getPnlEast() {
		if (pnlEast == null) {
			pnlEast = new JPanel();
			pnlEast.setPreferredSize(new Dimension(150, 10));
			pnlEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnlEast.add(getBtnGetMembers());
			pnlEast.add(getBtnFillTable());
			pnlEast.add(getBtnUpdateMembers());
		}
		return pnlEast;
	}
	private JButton getBtnGetMembers() {
		if (btnGetMembers == null) {
			btnGetMembers = new JButton("Get members");
			btnGetMembers.setPreferredSize(new Dimension(140, 23));
		}
		return btnGetMembers;
	}
	private JButton getBtnFillTable() {
		if (btnFillTable == null) {
			btnFillTable = new JButton("Fill table");
			btnFillTable.setPreferredSize(new Dimension(140, 23));
		}
		return btnFillTable;
	}
	private JButton getBtnUpdateMembers() {
		if (btnUpdateMembers == null) {
			btnUpdateMembers = new JButton("Update members");
			btnUpdateMembers.setPreferredSize(new Dimension(140, 23));
			btnUpdateMembers.setMinimumSize(new Dimension(91, 23));
			btnUpdateMembers.setMaximumSize(new Dimension(91, 23));
		}
		return btnUpdateMembers;
	}
	private JPanel getPnlSouth() {
		if (pnlSouth == null) {
			pnlSouth = new JPanel();
			pnlSouth.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlSouth.setPreferredSize(new Dimension(80, 80));
			pnlSouth.setLayout(new BorderLayout(0, 0));
			pnlSouth.add(getScrollPane_1());
		}
		return pnlSouth;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTxtStatus());
		}
		return scrollPane_1;
	}
	private JTextArea getTxtStatus() {
		if (txtStatus == null) {
			txtStatus = new JTextArea();
		}
		return txtStatus;
	}
}
