package yfj.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class AboutView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutView frame = new AboutView();
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
	public AboutView() {
		setTitle("关于");
		setClosable(true);
		setBounds(100, 100, 574, 387);
		
		JLabel lblNewLabel_1 = new JLabel("作者：杨方剑 ");
		lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 40));
		
		JLabel lblwwwhiaitop = new JLabel("学号：2096112062");
		lblwwwhiaitop.setFont(new Font("华文细黑", Font.BOLD, 40));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(100))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addComponent(lblwwwhiaitop, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(lblNewLabel_1)
					.addGap(28)
					.addComponent(lblwwwhiaitop, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
