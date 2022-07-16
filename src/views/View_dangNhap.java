package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.UserModel;
import services.UserService;
import utils.IoCContainer;
import utils.Utilities;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.nio.file.attribute.AclEntry;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class View_dangNhap extends JFrame {
	private UserModel _userAreUsing;
	private JPanel contentPane;
	private JPasswordField txt_matKhau;
	private JComboBox cbx_taiKhoan;
	private static String _passwordStatus = "hide";
	private static ArrayList<UserModel> _listAccount; // check
	private UserService _userService = new UserService();
//	private UserService _userService = (UserService) IoCContainer.getBean(UserService.class+"");
	private static ArrayList<UserModel> _listUserModel; // check

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					View_dangNhap frame = new View_dangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public View_dangNhap() throws SQLException {

		try {
			dangNhap();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void dangNhap() throws IOException, ClassNotFoundException, SQLException {
		_listAccount = new ArrayList<UserModel>();
		_userService.updateListUserModel();
		_listUserModel = _userService.getListUserModel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		URL url = View_dangNhap.class.getResource("Youtube.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		setBounds(100, 100, 1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (_passwordStatus.equals("hide")) {
					txt_matKhau.setEchoChar('\u0000');
					lblNewLabel_2.setIcon(new ImageIcon(
							Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("showPw45.png"))));
					_passwordStatus = "show";
				} else {
					txt_matKhau.setEchoChar('*');
					lblNewLabel_2.setIcon(new ImageIcon(
							Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("hidePw45.png"))));
					_passwordStatus = "hide";
				}
			}
		});
		lblNewLabel_2.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("hidePw45.png"))));
		lblNewLabel_2.setBounds(707, 303, 45, 45);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(387, 82, 388, 61);
		contentPane.add(lblNewLabel);

		 cbx_taiKhoan = new JComboBox();
		 cbx_taiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txt_matKhau.setText(_listAccount.get(cbx_taiKhoan.getSelectedIndex()).getPassword());
				} catch (Exception e2) {
					_passwordStatus = "hide";
					txt_matKhau.setForeground(Color.black);
					txt_matKhau.setText(null);
					lblNewLabel_2.setIcon(new ImageIcon(
							Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("hidePw45.png"))));
					txt_matKhau.setEchoChar('*');
				}
			}
		});
		cbx_taiKhoan.setEditable(true);
		cbx_taiKhoan.setBackground(new Color(255, 255, 255));
		cbx_taiKhoan.setBounds(406, 201, 346, 45);
		contentPane.add(cbx_taiKhoan);

		String arrayTK[] = new String[_listAccount.size()];
		int index = 0;

		for (UserModel userModel : _listAccount) {
			arrayTK[index] = userModel.getUsername();
			index++;
		}
		cbx_taiKhoan.setModel(new DefaultComboBoxModel(arrayTK));

		txt_matKhau = new JPasswordField();
		txt_matKhau.setBorder(null);
		txt_matKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_matKhau.getText().equals("Mật khẩu")) {
					_passwordStatus = "hide";
					txt_matKhau.setForeground(Color.black);
					txt_matKhau.setText(null);
					lblNewLabel_2.setIcon(new ImageIcon(
							Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("hidePw45.png"))));
					txt_matKhau.setEchoChar('*');
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_matKhau.getText().equals("")) {
					txt_matKhau.setEchoChar('\u0000');
					txt_matKhau.setText("Mật khẩu");
					txt_matKhau.setForeground(new Color(153, 153, 153));
				}
			}
		});
		txt_matKhau.setEchoChar('\u0000');

		txt_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_matKhau.setColumns(10);
		txt_matKhau.setText("Mật khẩu");
		txt_matKhau.setForeground(new Color(153, 153, 153));
		txt_matKhau.setBounds(406, 303, 301, 45);
		contentPane.add(txt_matKhau);

		final JCheckBox cbxNhoMatKhau = new JCheckBox("Nhớ mật khẩu");
		cbxNhoMatKhau.setForeground(new Color(255, 255, 255));
		cbxNhoMatKhau.setBackground(new Color(51, 52, 55));
		cbxNhoMatKhau.setBounds(406, 366, 113, 23);
		contentPane.add(cbxNhoMatKhau);

		if (!_listAccount.isEmpty()) {
			txt_matKhau.setText(_listAccount.get(0).getPassword());
			txt_matKhau.setEchoChar('*');
			cbxNhoMatKhau.setSelected(true);
		}

		JButton btn_signIn = new JButton("Sign In");
		btn_signIn.setForeground(new Color(255, 255, 255));
		btn_signIn.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btn_signIn.setMnemonic(KeyEvent.VK_ENTER);

		btn_signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = (String) cbx_taiKhoan.getSelectedItem();
				String password = txt_matKhau.getText();
				try {
					checkUsernameAndPassword(username,password);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
		btn_signIn.setBackground(new Color(123, 104, 238));
		btn_signIn.setBounds(451, 408, 258, 61);
		contentPane.add(btn_signIn);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(View_dangNhap.class.getResource("anhdn.png"))));
		lblNewLabel_1.setBounds(0, 0, 1184, 636);
		contentPane.add(lblNewLabel_1);

		this.setLocationRelativeTo(null);
		setJMenuBar(null);
		revalidate();
		repaint();
	}
	public void checkUsernameAndPassword(String username , String password) throws ClassNotFoundException, SQLException {
		boolean check = true;
		for (UserModel userModel : _listUserModel) {
			if(userModel.getUsername().equals(username)&&userModel.getPassword().equals(Utilities.hashingPassword(password))) {
				check = false;
				String vaiTro = userModel.getRole();
				if(vaiTro.equals("CanBoDaoTao")) {
					this.setVisible(false);
					Student_View student_View = new Student_View();
					student_View.setVisible(true);
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công vai trò: Cán bộ đào tạo");
					return;
				}else if(vaiTro.equals("GiangVien")) {
					this.setVisible(false);
					Grade_View grade_View = new Grade_View();
					grade_View.setVisible(true);
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công vai trò: Giảng viên");
					return;
				}
			}
		}
		if(check) {
			JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác");
			return;
		}
	}


}
