package yfj.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("图书管理系统-主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 554);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统菜单");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("修改密码");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassUpdateView passUpdateView = new PassUpdateView();
				passUpdateView.setVisible(true);
				desktopPane.add(passUpdateView);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("退出系统");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "您确定要退出系统吗？");
				if(result == 0){
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("图书管理");
		mnNewMenu_1.setIcon(new ImageIcon(MainView.class.getResource("/images/bookTypeManager.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("图书添加");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddView bookAddView = new BookAddView();
				bookAddView.setVisible(true);
				desktopPane.add(bookAddView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("图书维护");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerView bookManagerView = new BookManagerView();
				bookManagerView.setVisible(true);
				desktopPane.add(bookManagerView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("借阅图书");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowView borrowView = new BorrowView();
				borrowView.setVisible(true);
				desktopPane.add(borrowView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);


		JMenuItem mntmNewMenuItem_7 = new JMenuItem("归还图书");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBookView returnBookView = new ReturnBookView();
				returnBookView.setVisible(true);
				desktopPane.add(returnBookView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_2 = new JMenu("类别管理");
		mnNewMenu_2.setIcon(new ImageIcon(MainView.class.getResource("/images/bookManager.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddView bookTypeAddView = new BookTypeAddView();
				bookTypeAddView.setVisible(true);
				desktopPane.add(bookTypeAddView);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别维护");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerView bookTypeManagerView = new BookTypeManagerView();
				bookTypeManagerView.setVisible(true);
				desktopPane.add(bookTypeManagerView);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("关于");
		mnNewMenu_3.setIcon(new ImageIcon(MainView.class.getResource("/images/about.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem = new JMenuItem("帮助");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView aboutView = new AboutView();
				aboutView.setVisible(true);
				desktopPane.add(aboutView);
			}
		});
		mnNewMenu_3.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		//设置窗口剧中显示
		this.setLocationRelativeTo(null);
	}

}
