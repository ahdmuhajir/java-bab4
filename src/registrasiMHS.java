import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class registrasiMHS extends JFrame{
	JLabel judul = new JLabel("SISTEM REGISTRASI MAHASISWA");
	JLabel  judul2=new JLabel("POLITEKNIK ACEH");
	JLabel kampus = new JLabel(new ImageIcon("")); //nntik
	JLabel lnim = new JLabel("NIM");
	JTextField txnim = new JTextField();
	JLabel lnama= new JLabel("Nama");
	JTextField txnama = new JTextField();
	JLabel lgender = new JLabel("Jenis Kelamin");
	JRadioButton pria= new JRadioButton("Pria");
	JRadioButton wanita= new JRadioButton("Wanita");
	ButtonGroup grGender = new ButtonGroup();
	JLabel ljur= new JLabel("Jurusan");
	String jur [] = {"","Teknik Informatika","Teknik Mekatronika","Teknik Elektro","Akuntansi"};
	JComboBox cbJur= new JComboBox(jur);
	JLabel lkelas= new JLabel("Kelas");
	String kelas[]= {"","A","B","C"};
	JComboBox cbKelas= new JComboBox(kelas);
	JLabel ltahun = new JLabel("Tahun Ajaran");
	JTextField txTahun = new JTextField();
	JLabel lhp = new JLabel("HP");
	JTextField txHp = new JTextField();
	JLabel lemail= new JLabel("E-mail");
	JTextField txEmail = new JTextField();
	JLabel lfoto= new JLabel("Foto 3x4");
	JLabel lfoto2= new JLabel();
	JLabel  lfoto3=new JLabel(new ImageIcon(""));
	JFileChooser fc = new JFileChooser();
	Blob blob;
	JLabel logo = new JLabel(new ImageIcon("img/logopoltek.png"));//nntik
	JLabel  gambar= new JLabel(new ImageIcon("img/bg.jpg"));//nntik
	JLabel cari = new JLabel(new ImageIcon("img/search.png"));
	String header[]= {"NIM","NAMA", "Gender", "Jurusan", "Kelas", "Tahun Ajaran", "HP", "Email"};
	DefaultTableModel model = new DefaultTableModel(null, header);
	JTable  tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	Dimension dimension= new Dimension(15, 2);
	JButton save = new JButton("SAVE");
	JButton upadte= new JButton("UPDATE");
	JButton cetak = new JButton("CETAK");
	JButton delete = new JButton("DELETE");
	JButton exit = new JButton("EXIT");
	JButton browse= new JButton("BROWSE");
	JButton print= new JButton("PRINT LAPORAN");
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	
	public registrasiMHS() {
		setTitle("FORM REGISTRASI MHS");
		setSize(1020, 560);
		setLocation(50, 50);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	void komponenVisual(){
		getContentPane().setLayout(null);
		getContentPane().add(judul);
		judul.setBounds(250,10,500,40);
		judul.setFont(new Font("Arial",Font.BOLD, 20));
		judul.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(judul2);
		judul2.setBounds(350, 40, 300, 40);
		judul2.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(kampus);
		kampus.setBounds(700, 0, 128, 128);
		
		/*PANEL SATU*/
		
		getContentPane().add(panel1);
		panel1.setLayout(null);
		panel1.setBounds(0, 120, 300, 410);
		panel1.setBorder(new TitledBorder(new LineBorder(Color.WHITE),"Data Mahasiswa"));
		panel1.setOpaque(false);
		panel1.setForeground(Color.WHITE);
		panel1.add(cari);
		cari.setBounds(260,20,20,20);
		panel1.add(lnim);
		lnim.setBounds(10, 20, 100, 20);
		panel1.add(txnim);
		txnim.setBounds(110,20,150,20);
		panel1.add(lnama);
		lnama.setBounds(10, 50, 100, 20);
		panel1.add(txnama);
		txnama.setBounds(110,50,170,20);
		panel1.add(lgender);
		lgender.setBounds(10, 80, 100, 20);
		panel1.add(pria);
		pria.setBounds(110, 80, 80, 20);
		pria.setOpaque(false);
		panel1.add(wanita);
		wanita.setBounds(190, 80, 80, 20);
		wanita.setOpaque(false);
		
		grGender.add(pria);
		grGender.add(wanita);
		
		panel1.add(ljur);
		ljur.setBounds(10,110,100,20);
		
		panel1.add(cbJur);
		cbJur.setBounds(110, 110, 170, 20);
		
		panel1.add(lkelas);
		lkelas.setBounds(10, 140, 110, 20);
		
		panel1.add(cbKelas);
		cbKelas.setBounds(110, 140, 170, 20);
		
		panel1.add(ltahun);
		ltahun.setBounds(10, 170, 100, 20);
		
		panel1.add(txTahun);
		txTahun.setBounds(110, 170, 170, 20);
		
		panel1.add(lhp);
		lhp.setBounds(10, 200, 100, 20);
		panel1.add(txHp);
		txHp.setBounds(110, 200, 170, 20);
		
		panel1.add(lemail);
		lemail.setBounds(10, 230, 100, 20);
		panel1.add(txEmail);
		txEmail.setBounds(110, 230, 170, 20);
		
		panel1.add(lfoto);
		lfoto.setBounds(10, 260, 100, 20);
		panel1.add(lfoto3);
		lfoto3.setBounds(10, 290, 48, 48);
		panel1.add(lfoto2);
		lfoto2.setBounds(110,260,170,140);
		lfoto2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		
		/*PANEL 2*/
		getContentPane().add(panel2);
		panel2.setLayout(null);
		panel2.setBounds(305, 120, 150, 410);
		panel2.setBorder(new TitledBorder(new LineBorder(Color.WHITE),"TOMBOL AKSI"));
		panel2.setOpaque(false);
		
		panel2.add(save);
		save.setBounds(15, 20, 120, 60);
		save.setIcon(new ImageIcon("img/save.png"));//nntik
		save.setToolTipText("SAVE");
		
		panel2.add(upadte);
		upadte.setBounds(15, 85, 120, 60);
		upadte.setToolTipText("UPDATE");
		upadte.setIcon(new ImageIcon("img/edit.png"));//nntik
		
		panel2.add(cetak);
		cetak.setBounds(15, 150, 120, 60);
		cetak.setToolTipText("CLEAR");
		cetak.setIcon(new ImageIcon("img/print.png"));//nntik
		
		panel2.add(delete);
		delete.setBounds(15, 215, 120, 60);
		delete.setToolTipText("DELETE");
		delete.setIcon(new ImageIcon("img/remove.png"));//nntik
		
		panel2.add(browse);
		browse.setBounds(15, 280, 120, 55);
		browse.setIcon(new ImageIcon("img/folder-open.png"));//nntik
		browse.setToolTipText("Pilih Foto Anda");
		
		panel2.add(exit);
		exit.setBounds(15, 340, 120, 55);
		exit.setToolTipText("Kelaur");
		exit.setIcon(new ImageIcon("img/power-off.png"));//nntik
		/*PANEL 3*/
		
		getContentPane().add(panel3);
		panel3.setLayout(null);
		panel3.setBounds(460, 120, 550, 410);
		panel3.setBorder(new TitledBorder(new LineBorder(Color.WHITE),"TABEL DATABASE"));
		panel3.setOpaque(false);
		panel3.setForeground(Color.WHITE);
		panel3.add(pane);
		pane.setBounds(10, 20, 530, 320);
		pane.setOpaque(false);
		pane.getViewport().setOpaque(false);
		
		tabel.setShowGrid(true);
		tabel.setShowVerticalLines(true);
		tabel.setIntercellSpacing(new Dimension(dimension));
		tabel.setGridColor(Color.GREEN);
		
		panel3.add(print);
		print.setBounds(10, 350, 530, 50);
		print.setIcon(new ImageIcon("img/print.png"));//nntik
		/*END PANEL 3*/
		
		getContentPane().add(logo);
		logo.setBounds(50, 10, 200, 80);
		
		getContentPane().add(gambar);
		gambar.setBounds(0, 0, 1020, 560);
		
		tampilTabel();
		setVisible(true);
		
	}
	void aksiReaksi(){
		/*PRINT */
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent w) {
				cetakHasil();
				
			}
		});
		
		/*CARI GAMBAR*/
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int buka= fc.showOpenDialog(lfoto2);
				if(buka ==JFileChooser.APPROVE_OPTION){
					String sumber=fc.getSelectedFile().getPath();
					lfoto2.setIcon(new ImageIcon(sumber));
					File file = new File(sumber);
					try {
						FileInputStream fis = new FileInputStream(sumber);
					} catch (Exception e2) {
						Logger.getLogger(registrasiMHS.class.getName()).log(Level.SEVERE, null, e2);
					}
					
				}
				
			}
		});
		
		/*SAVE*/
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sumber = fc.getSelectedFile().getPath();
				try {
					File filegambar= new File(sumber);
					FileInputStream fis= new FileInputStream(filegambar);
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/politeknikaceh","root","");
					String sql= "insert into datamahasiswa values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pr=connection.prepareStatement(sql);
					pr.setString(1, txnim.getText());
					pr.setString(2, txnama.getText());
					if(pria.isSelected()){
						pr.setString(3, pria.getText());
					}else if(wanita.isSelected()){
						pr.setString(3, wanita.getText());
					}
					pr.setString(4, (String) cbJur.getSelectedItem());
					pr.setString(5, (String) cbKelas.getSelectedItem());
					pr.setString(6, txTahun.getText());
					pr.setString(7, txHp.getText());
					pr.setString(8, txEmail.getText());
					pr.setBinaryStream(9, fis,(int)filegambar.length());
					pr.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Berhasil DIsimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					tampilTabel();
					bersihData();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Data Gagal Disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(e2);
				}
				
			}
		});
		/*CETAK*/
		cetak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int y=0;
				Frame fr =new Frame();
				PrintJob print = fr.getToolkit().getPrintJob(fr, "Printing", null,null);
				if(print!=null){
					Graphics g = print.getGraphics();
					if(g!=null){
						g.setFont(new Font("Dialog", 1, 11));
						g.drawString("KARTU REGISTRASI MAHASISWA", 200, 40);
						g.drawLine(10, 50, 600, 50);
						g.drawString("NIM", 10, 70);
						g.drawString(":", 90, 70);
						g.drawString(txnim.getText(), 100, 70);
						g.drawString("Nama", 10, 90);
						g.drawString(":", 90, 90);
						g.drawString(txnama.getText(), 100, 90);
						
						g.drawString("Gender", 10, 110);
						g.drawString(":", 90, 110);
						if(pria.isSelected()){
							g.drawString(pria.getText(), 100, 110);
						}else if (wanita.isSelected()){
							g.drawString(wanita.getText(), 100, 110);
						}
						g.drawString("Jurusan", 10, 130);
						g.drawString(":", 90, 130);
						g.drawString((String)cbJur.getSelectedItem(), 100, 130);
						
						g.drawString("Kelas", 10, 150);
						g.drawString(":", 90, 150);
						g.drawString((String)cbKelas.getSelectedItem(), 100, 150);
						
						g.drawString("Tahun Ajaran", 10, 170);
						g.drawString(":", 90, 170);
						g.drawString(txTahun.getText(), 100, 170);
						
						g.drawString("Hp", 10, 190);
						g.drawString(":", 90, 190);
						g.drawString(txHp.getText(), 100, 190);
						
						g.drawString("Email", 10, 210);
						g.drawString(":", 90, 210);
						g.drawString(txEmail.getText(), 100, 210);
						
					}
				}
				print.end();
				print.end();
			}
		});
		/*CARI*/
		cari.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int vblob;
				ImageIcon gambar;
				String nim = txnim.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/politeknikAceh","root","");
					Statement statement= connection.createStatement();
					String sql = "select * from datamahasiswa where nim='"+nim+"'";
					ResultSet rs=statement.executeQuery(sql);
					if(rs.next()){
						txnama.setText(rs.getString(2));
						String gender=rs.getString(3);
						if(gender.equals("Pria")){
							pria.setSelected(true);
						}else if (gender.equals("Wanita")){
							wanita.setSelected(true);
						}
						cbJur.setSelectedItem(rs.getString(4));
						cbKelas.setSelectedItem(rs.getString(5));
						txTahun.setText(rs.getString(6));
						txHp.setText(rs.getString(7));
						txEmail.setText(rs.getString(8));
						blob= rs.getBlob(9);
						vblob=(int) blob.length();
						gambar=new ImageIcon(blob.getBytes(1, vblob));
						lfoto2.setIcon(gambar);
					}
							
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
			
		});
		/*UPDATE*/
		upadte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==upadte){
					try {
						String sumber = fc.getSelectedFile().getPath();
						File filegambar = new File(sumber);
						FileInputStream fis = new FileInputStream(filegambar);
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/politeknikaceh","root","");
						String sql= "update datamahasiswa set nama=?,gender=?,jurusan=?,kelas=?,ajaran=?,hp=?,email=?,photo=? where nim=?";
						PreparedStatement pr = connection.prepareStatement(sql);
						pr.setString(1, txnama.getText());
						if(pria.isSelected()){
							pr.setString(2, pria.getText());
						}else if(wanita.isSelected()){
							pr.setString(2, wanita.getText());
						}
						pr.setString(3, (String) cbJur.getSelectedItem());
						pr.setString(4, (String) cbKelas.getSelectedItem());
						pr.setString(5, txTahun.getText());
						pr.setString(6, txHp.getText());
						pr.setString(7, txEmail.getText());
						pr.setBinaryStream(8, fis,(int)filegambar.length());
						pr.setString(9, txnim.getText());
						pr.executeUpdate();
						pr.close();
						connection.close();
						tampilTabel();
						bersihData();
						JOptionPane.showMessageDialog(null, "Data Sudah Terupdate","Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});
		/*DELETE*/
		delete.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				String nim=txnim.getText();
				int tanya = JOptionPane.showConfirmDialog(null,"Apakah Anda ingin Menghapus Data NIM "+nim+"?","Konfirmasi",JOptionPane.YES_NO_OPTION);
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/politeknikaceh",
						"root", "");
						String sql="DELETE FROM datamahasiswa WHERE nim=?";
						PreparedStatement pr = koneksi.prepareStatement(sql);
						pr.setString(1,nim);
						pr.executeUpdate();
						pr.close();
						koneksi.close();
						JOptionPane.showMessageDialog(null,"Data telah dihapus");
						tampilTabel(); //ambil data di void tampilTabel()
						bersihData();
						}
					catch (Exception ex){
						JOptionPane.showMessageDialog(null,"Error :"+ex,"Error",JOptionPane.ERROR_MESSAGE);
						}
				} 
				}
			} );
		/*EXIT*/
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	void bersihData(){
		txnim.setText("");
		txnama.setText("");
		pria.setSelected(false);
		wanita.setSelected(false);
		cbJur.setSelectedIndex(0);
		cbKelas.setSelectedIndex(0);
		txTahun.setText("");
		txHp.setText("");
		txEmail.setText("");
		lfoto2.setIcon(new ImageIcon(""));
	}
	
	void tampilTabel(){
		hapusTabel();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/politeknikaceh","root","");
			Statement state = connection.createStatement();
			String sql= "select * from datamahasiswa";
			ResultSet rs=state.executeQuery(sql);
			
			while(rs.next()){
				Object obj[] = new Object[9];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				obj[3] = rs.getString(4);
				obj[4] = rs.getString(5);
				obj[5] = rs.getString(6);
				obj[6] = rs.getString(7);
				obj[7] = rs.getString(8);
				model.addRow(obj);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void cetakHasil(){
		int y=0;
		Frame fr= new Frame();
		PrintJob printerJob=fr.getToolkit().getPrintJob(fr,"Printing",null,null);
		if(printerJob!=null){
			Graphics g = printerJob.getGraphics();
			if(g != null){
				Image image = new ImageIcon("Gambar/logo.png").getImage();
				g.setFont(new Font("Dialog", 1, 11));
				g.drawString("Sistem Registrasi Mahasiswa", 200, 40);
				g.setFont(new Font("Dialog", 1, 10));
				g.drawString("Jl. Poloteknik Aceh No 1", 220, 50);
				g.setFont(new Font("Dialog", 1, 9));
				g.drawString("085358484618", 245, 60);
				
				//untukk NAMA KOLOM TABEL
				String nim = tabel.getColumnName(0);
				String nama=tabel.getColumnName(1);
				String gender= tabel.getColumnName(2);
				String jurusan=tabel.getColumnName(3);
				String kelas= tabel.getColumnName(4);
				String tahunAjaran=tabel.getColumnName(5);
				String hp=tabel.getColumnName(6);
				String email=tabel.getColumnName(7);
				g.setFont(new Font("Dialog", 1, 8));
				g.drawString(nim, 30, 100);
				g.drawString(nama, 80, 100);
				g.drawString(gender, 150, 100);
				g.drawString(jurusan, 190, 100);
				g.drawString(kelas, 270, 100);
				g.drawString(tahunAjaran, 300, 100);
				g.drawString(hp, 360, 100);
				g.drawString(email, 420, 100);
				g.drawLine(30, 103, 550, 103);
				
				//untuk data tabel
				int n = model.getRowCount();
				for (int i = 0; i < n; i++) {
					int k =i+1;
					int j=10*k;
					y = 100+j;
					g.setFont(new Font("Dialog", 0, 8));
					String dataNim= model.getValueAt(i, 0).toString();
					String dataNama=model.getValueAt(i, 1).toString();
					String dataGender= model.getValueAt(i, 2).toString();
					String dataJurusan = model.getValueAt(i, 3).toString();
					String dataKelas=model.getValueAt(i, 4).toString();
					String dataTahun= model.getValueAt(i, 5).toString();
					String dataHp= model.getValueAt(i, 6).toString();
					String dataEmail=model.getValueAt(i, 7).toString();
					
					g.drawString(dataNim, 30, y);
					g.drawString(dataNama, 80, y);
					g.drawString(dataGender, 150, y);
					g.drawString(dataJurusan, 190, y);
					g.drawString(dataKelas, 270, y);
					g.drawString(dataTahun, 300, y);
					g.drawString(dataHp, 360, y);
					g.drawString(dataEmail, 420, y);
				}
				
				//BERHENTI
			}
			printerJob.end();
			printerJob.end();
		}
	}
	
	void noTable(){
		int baris = model.getRowCount();
		for (int i = 0; i < baris; i++) {
			String nomor = String.valueOf(i+1);
			model.setValueAt(nomor +" . ",i,0);
		}
	}
	void hapusTabel(){
		int row = model.getRowCount();
		for (int i =0;i<row;i++){
			model.removeRow(0);
		}
	}
	
	public static void main(String[] args) {
		registrasiMHS ajir = new registrasiMHS();
		ajir.komponenVisual();
		ajir.aksiReaksi();
	}
}

