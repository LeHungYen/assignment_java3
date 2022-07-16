package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.GradeModel;
import models.StudentModel;
import services.GradeService;
import services.StudentService;
import utils.IoCContainer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Grade_View extends JFrame {
	private  IoCContainer _ioCContainer = new IoCContainer();
	private  GradeService _gradeService= (GradeService) _ioCContainer.getBean(GradeService.class+"");
	private StudentService _studentService = (StudentService) _ioCContainer.getBean(StudentService.class+"");
	private ArrayList<StudentModel> _listStudentModels = new ArrayList<StudentModel>();
	private ArrayList<GradeModel> _listGradeModels = new ArrayList<GradeModel>();
	private int _sttGradeSelected;
	private JPanel contentPane;
	private JTextField txt_search;
	private JTable table;
	private JTextField txt_gdtc;
	private JTextField txt_tinHoc;
	private JTextField txt_tiengAnh;
	private JTextField txt_maSV;
	private JLabel lbl_diemTB;
	private JLabel lbl_tenSinhVien;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade_View frame = new Grade_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Grade_View() throws ClassNotFoundException, SQLException {
		_studentService.updateListStudentModel();
		_gradeService.updateListGradeModel();
		_listStudentModels = _studentService.getListStudentModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD \u0110i\u1EC3m Sinh Vi\u00EAn");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 773, 51);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 73, 719, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_search = new JTextField();
		txt_search.setBounds(67, 20, 543, 20);
		panel.add(txt_search);
		txt_search.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 SV");
		lblNewLabel_1.setBounds(11, 23, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Tim kiếm");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txt_search.getText();
				for (GradeModel gradeModel : _listGradeModels) {
					if(search.equals(gradeModel.getMaSV())) {
						txt_maSV.setText(gradeModel.getMaSV());
						txt_tiengAnh.setText(gradeModel.getTiengAnh()+"");
						txt_tinHoc.setText(gradeModel.getTinHoc()+"");
						txt_gdtc.setText(gradeModel.getGdtc()+"");
						String diemTB = gradeModel.getDiemTb()+"";
						lbl_diemTB.setText(diemTB.substring(0,3));
						for (StudentModel studentModel : _listStudentModels) {
							if(search.equals(studentModel.getMaSinhVien())) {
								lbl_tenSinhVien.setText(studentModel.getHoTen());
							}
						}
						_sttGradeSelected = gradeModel.getStt();
						btnDelete.setEnabled(true);
						btnUpdate.setEnabled(true);
						btnSave.setEnabled(false);
						return;
					}
				}
				
				for (StudentModel studentModel : _listStudentModels) {
					if(search.equals(studentModel.getMaSinhVien())) {
						lbl_tenSinhVien.setText(studentModel.getHoTen());
						txt_maSV.setText(studentModel.getMaSinhVien());
						lbl_diemTB.setText("");
						txt_tiengAnh.setText("");
						txt_tinHoc.setText("");
						txt_gdtc.setText("");
						btnSave.setEnabled(true);
						btnDelete.setEnabled(false);
						btnUpdate.setEnabled(false);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Mã sinh viên bạn nhập không có trong danh sách");
			}
		});
		btnNewButton_1.setBounds(620, 19, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 135, 461, 375);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD t\u00EAn SV:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 11, 105, 34);
		panel_1.add(lblNewLabel_3);
		
		txt_gdtc = new JTextField();
		txt_gdtc.setBounds(125, 191, 202, 34);
		panel_1.add(txt_gdtc);
		txt_gdtc.setColumns(10);
		
		txt_tinHoc = new JTextField();
		txt_tinHoc.setColumns(10);
		txt_tinHoc.setBounds(125, 146, 202, 34);
		panel_1.add(txt_tinHoc);
		
		txt_tiengAnh = new JTextField();
		txt_tiengAnh.setColumns(10);
		txt_tiengAnh.setBounds(125, 101, 202, 34);
		panel_1.add(txt_tiengAnh);
		
		txt_maSV = new JTextField();
		txt_maSV.setEditable(false);
		txt_maSV.setColumns(10);
		txt_maSV.setBounds(125, 56, 202, 34);
		panel_1.add(txt_maSV);
		
		 lbl_tenSinhVien = new JLabel("");
		lbl_tenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tenSinhVien.setForeground(Color.BLUE);
		lbl_tenSinhVien.setBounds(125, 11, 202, 34);
		panel_1.add(lbl_tenSinhVien);
		
		JLabel lblNewLabel_3_1 = new JLabel("M\u00E3 SV:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 56, 105, 34);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ti\u1EBFng anh:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(10, 101, 105, 34);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Tin h\u1ECDc:");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(10, 146, 105, 34);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("GI\u00E1o d\u1EE5c TC:");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(10, 191, 105, 34);
		panel_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("\u0110i\u1EC3m TB:");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3_1.setBounds(337, 99, 105, 34);
		panel_1.add(lblNewLabel_3_3_1);
		
		 lbl_diemTB = new JLabel("");
		lbl_diemTB.setForeground(Color.BLUE);
		lbl_diemTB.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_diemTB.setFont(new Font("Tahoma", Font.BOLD, 38));
		lbl_diemTB.setBounds(337, 129, 105, 96);
		panel_1.add(lbl_diemTB);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(481, 135, 124, 40);
		contentPane.add(btnNewButton);
		
		 btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeModel gradeModel = getInforFromViewIntoGradeModel();
				if(gradeModel==null) {
					return;
				}
				for (GradeModel gradeModel2 : _listGradeModels) {
					if(gradeModel2.getMaSV().equals(gradeModel.getMaSV().trim())) {
						JOptionPane.showMessageDialog(null, "Bạn không thể thêm sinh viên này vì sinh viên này đã có trong danh sách");
						return;
					}
				}
				try {
					_gradeService.them(gradeModel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				clearForm();
				updateTableGrade();
			}
		});
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(481, 186, 124, 40);
		contentPane.add(btnSave);
		
		 btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeModel gradeModel = getInforFromViewIntoGradeModel();
				gradeModel.setStt(_sttGradeSelected);
				try {
					_gradeService.xoa(gradeModel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				clearForm();
				updateTableGrade();
			}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(481, 237, 124, 40);
		contentPane.add(btnDelete);
		
		 btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradeModel gradeModel = getInforFromViewIntoGradeModel();
				if(gradeModel==null) {
					return;
				}
				gradeModel.setStt(_sttGradeSelected);
				gradeModel.setId(_listGradeModels.get(_sttGradeSelected).getId());
				try {
					_gradeService.sua(gradeModel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				clearForm();
				updateTableGrade();
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(481, 288, 124, 40);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 588, 773, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable();
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("3 Sinh vi\u00EAn c\u00F3 \u0111i\u1EC3m cao nh\u1EA5t");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(10, 563, 301, 14);
		contentPane.add(lblNewLabel_2);
		updateTableGrade();
		btnDelete.setEnabled(false);
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
		revalidate();
		repaint();
	}
	
	public GradeModel getInforFromViewIntoGradeModel () {
		String maSinhVien = txt_maSV.getText().trim();
		double tiengAnh;
		double tinHoc;
		double gdtc;
		try {
			tiengAnh= Double.parseDouble(txt_tiengAnh.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Xin vui lòng kiểm tra lại điểm tiếng anh");
			return null;
		}
		try {
			tinHoc = Double.parseDouble(txt_tinHoc.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Xin vui lòng kiểm tra lại điểm tin học");
			return null;
		}
		try {
			gdtc = Double.parseDouble(txt_gdtc.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Xin vui lòng kiểm tra lại điểm gdtc");
			return null;
		}
		
		
		GradeModel gradeModel = new GradeModel(0, 0, maSinhVien, tiengAnh, tinHoc, gdtc,0);
		return gradeModel;
	}
	
	public double getDiemTB(double tiengAnh , double tinHoc , double gdtc) {
		double diemTB = (tiengAnh+tinHoc+gdtc)/3;
		return diemTB;
	}
	
	public ArrayList<GradeModel> getThreeGradeModel(ArrayList<GradeModel> listGradeModels){
		Collections.sort(listGradeModels, new Comparator<GradeModel>() {

			@Override
			public int compare(GradeModel o1, GradeModel o2) {
				if(o1.getDiemTb()<o2.getDiemTb()) {
					return 1;
				}else if(o1.getDiemTb()==o2.getDiemTb()) {
					return 0;
				}else
					return -1;
			}
			
		});;

			
		return listGradeModels;
	}
	
	public void doClickOnTable() {
		lbl_tenSinhVien.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		txt_maSV.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tiengAnh.setText(table.getModel().getValueAt(table.getSelectedRow(), 3)+"");
		txt_tinHoc.setText(table.getModel().getValueAt(table.getSelectedRow(), 4)+"");
		txt_gdtc.setText(table.getModel().getValueAt(table.getSelectedRow(), 5)+"");
		String diemTB = table.getModel().getValueAt(table.getSelectedRow(), 6)+"";
		lbl_diemTB.setText(diemTB.substring(0,3));
		_sttGradeSelected = table.getSelectedRow();
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnSave.setEnabled(false);
	}
	
	public void updateTableGrade() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Mã SV");
		model.addColumn("Họ tên");
		model.addColumn("Tiếng Anh");
		model.addColumn("Tin học");
		model.addColumn("GDTC");
		model.addColumn("Điểm TB");
		_listGradeModels = _gradeService.getListGradeModel();
		getThreeGradeModel(_listGradeModels);
		int stt=0;
		for (GradeModel gradeModel : _listGradeModels) {
			String name ="";
			for (StudentModel studentModel : _listStudentModels) {
				if(studentModel.getMaSinhVien().equals(gradeModel.getMaSV()))
					name = studentModel.getHoTen();
			}
			model.addRow(new Object[] {stt,gradeModel.getMaSV(),name,gradeModel.getTiengAnh(),gradeModel.getTinHoc(),gradeModel.getGdtc(),gradeModel.getDiemTb()});
			stt++;
			if(stt==3) {
				break;
			}
		}
		table.setModel(model);
	}
	
	public void clearForm() {
		txt_search.setText("");
		lbl_tenSinhVien.setText("");
		lbl_diemTB.setText("");
		txt_maSV.setText("");
		txt_tiengAnh.setText("");
		txt_gdtc.setText("");
		txt_tinHoc.setText("");
		btnDelete.setEnabled(false);
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
	}
}
