package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import models.StudentModel;
import services.StudentService;
import utils.IoCContainer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_View extends JFrame {
	private  IoCContainer _ioCContainer = new IoCContainer();
	private  StudentService _studentService= (StudentService) _ioCContainer.getBean(StudentService.class+"");
	private int _sttStudentSelected;
	private JPanel contentPane;
	private JTextField txt_maSV;
	private JTextField txt_hoTen;
	private JTextField txt_email;
	private JTextField txt_sdt;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private File _file ;
	private JTextPane textPane;
	private StudentModel _studentModel;
	private JRadioButton rdb_nam;
	private AbstractButton rdb_nu;
	private JLabel lbl_chonAnh;
	private ArrayList<StudentModel> _list;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_View frame = new Student_View();
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
	public Student_View() {
		try {
			_studentService.updateListStudentModel();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_maSV = new JTextField();
		txt_maSV.setBounds(168, 119, 217, 28);
		contentPane.add(txt_maSV);
		txt_maSV.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD Sinh Vi\u00EAn");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 33, 1155, 41);
		contentPane.add(lblNewLabel);
		
		txt_hoTen = new JTextField();
		txt_hoTen.setColumns(10);
		txt_hoTen.setBounds(168, 158, 217, 28);
		contentPane.add(txt_hoTen);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(168, 197, 217, 28);
		contentPane.add(txt_email);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(168, 236, 217, 28);
		contentPane.add(txt_sdt);
		
		 rdb_nam = new JRadioButton("Nam");
		buttonGroup.add(rdb_nam);
		rdb_nam.setBounds(178, 275, 54, 31);
		contentPane.add(rdb_nam);
		
		 rdb_nu = new JRadioButton("N\u1EEF");
		buttonGroup.add(rdb_nu);
		rdb_nu.setBounds(234, 275, 54, 31);
		contentPane.add(rdb_nu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 313, 217, 77);
		contentPane.add(scrollPane);
		
		 textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		lblNewLabel_2 = new JLabel("MaSV");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 119, 148, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 158, 148, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 197, 148, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("S\u1ED1 \u0110T:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(10, 236, 148, 28);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(10, 275, 148, 28);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(10, 313, 148, 28);
		contentPane.add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(513, 119, 119, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_chonAnh = new JLabel("Ch\u1ECDn \u1EA3nh");
		lbl_chonAnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("JPG File", "jpg","png");
				fileChooser.setFileFilter(imageFilter);
				fileChooser.setMultiSelectionEnabled(false);
				
				int x = fileChooser.showDialog(contentPane, "Chon file");
				if(x == JFileChooser.APPROVE_OPTION) {
					_file = fileChooser.getSelectedFile();
					lbl_chonAnh.setIcon(new ImageIcon(_file.getAbsolutePath()));
					lbl_chonAnh.setText(null);
				}
			}
		});
		lbl_chonAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chonAnh.setBounds(0, 0, 119, 145);
		panel.add(lbl_chonAnh);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(513, 313, 103, 31);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModel  stm = _list.get(_sttStudentSelected);
				try {
					_studentService.xoa(stm);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateTableStudent();
				clearForm();
			}
		});
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(513, 355, 103, 31);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_studentModel = getInforFromView();
				if(_studentModel == null) {
					return;
				}
				try {
					_studentService.them(_studentModel);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateTableStudent();
				clearForm();
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(626, 313, 103, 31);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_studentModel = getInforFromView();
				try {
					_studentService.sua(_studentModel);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateTableStudent();
				clearForm();
			}
		});
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(626, 355, 103, 31);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 406, 1155, 256);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_sttStudentSelected = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0)+"");
				txt_maSV.setText(_list.get(_sttStudentSelected).getMaSinhVien());
				txt_hoTen.setText(_list.get(_sttStudentSelected).getHoTen());
				txt_email.setText(_list.get(_sttStudentSelected).getEmail());
				txt_sdt.setText(_list.get(_sttStudentSelected).getSdt());
				if(_list.get(_sttStudentSelected).getGioiTinh().equals("0")) {
					rdb_nam.setSelected(true);
				}else
					rdb_nu.setSelected(true);
				
				textPane.setText(_list.get(_sttStudentSelected).getDiaChi());
				_file = new File(_list.get(_sttStudentSelected).getHinh());
				lbl_chonAnh.setIcon(new ImageIcon(_file.getAbsolutePath()));
				lbl_chonAnh.setText(null);
			}
		});
		scrollPane_1.setViewportView(table);
		
		updateTableStudent();
		revalidate();
		repaint();
		
	}
	
	public void updateTableStudent() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Mã SV");
		model.addColumn("Họ tên");
		model.addColumn("Email");
		model.addColumn("Số ĐT");
		model.addColumn("Giới tính");
		model.addColumn("Địa chỉ");
		model.addColumn("Hình");
		_list = _studentService.getListStudentModel();
		for (StudentModel studentModel : _list) {
			String gioiTinh ="";
			if(studentModel.getGioiTinh().equals("0")) {
				gioiTinh ="Nam";
			}else
				gioiTinh ="Nữ";
			model.addRow(new Object[] {studentModel.getStt(),studentModel.getMaSinhVien(),studentModel.getHoTen(),studentModel.getEmail(),studentModel.getSdt(),gioiTinh,studentModel.getDiaChi(),studentModel.getHinh()});
		}
		table.setModel(model);
	}
	
	public StudentModel getInforFromView() {
		String maSV = txt_maSV.getText().trim();
		if (maSV.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập mã sv");
			return null;
		}
		for (StudentModel studentModel : _list) {
			if(studentModel.getMaSinhVien().equals(maSV)) {
				JOptionPane.showMessageDialog(contentPane, "mã sv bạn nhập đã tồn tại");
				return null;
			}
		}
		String hoTen = txt_hoTen.getText().trim();
		if(hoTen.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập họ tên");
			return null;
		}
		if(new utils.Utilities().regexCheckFullName(hoTen).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "họ tên bạn nhập không hợp lệ");
			return null;
		}
		String email = txt_email.getText().trim();
		if(email.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập email");
			return null;
		}
		if(new utils.Utilities().regexCheckGmail(email).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "email bạn nhập không hợp lệ");
			return null;
		}
		String sdt = txt_sdt.getText().trim();
		if(sdt.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập sdt");
			return null;
		}
		if(new utils.Utilities().regexCheckPhoneNumber(sdt).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "sdt bạn nhập không hợp lệ");
			return null;
		}
		String gioiTinh = "";
		String diaChi = textPane.getText().trim();
		if(diaChi.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập địa chỉ");
			return null;
		}
		
		String hinh="";
		try {
			 hinh = _file.getAbsolutePath();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập hinh");
			return null;
		}
		
		Enumeration<AbstractButton> button  = buttonGroup.getElements();
		while (button.hasMoreElements()) {
			AbstractButton abstractButton = (AbstractButton) button.nextElement();
			if(abstractButton.isSelected()) {
				gioiTinh= abstractButton.getActionCommand();
				break;
			}
		}
		if(gioiTinh.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng chọn giới tính");
			return null;
		}
		if(gioiTinh.equals("Nam")) {
			gioiTinh ="0";
		}else 
			gioiTinh ="1";
		
		
		
		
		StudentModel studentModel = new StudentModel(1, maSV, hoTen, email, sdt, gioiTinh, diaChi, hinh);
		return studentModel;
	}
	
	public void clearForm() {
		txt_maSV.setText("");
		txt_hoTen.setText("");
		txt_email.setText("");
		txt_sdt.setText("");
		buttonGroup.clearSelection();
		textPane.setText("");
		lbl_chonAnh .setText("Chọn ảnh");;
		lbl_chonAnh.setIcon(null);
	}
	
}
