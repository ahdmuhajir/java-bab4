import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel logo = new JLabel(new ImageIcon());//nntik
	JLabel  gambar= new JLabel(new ImageIcon());//nntik
	JLabel cari = new JLabel(new ImageIcon());//nntik
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
		save.setIcon(new ImageIcon(""));//nntik
		save.setToolTipText("SAVE");
		
		panel2.add(upadte);
		upadte.setBounds(15, 85, 120, 60);
		upadte.setToolTipText("UPDATE");
		upadte.setIcon(new ImageIcon(""));//nntik
		
		panel2.add(cetak);
		cetak.setBounds(15, 150, 120, 60);
		cetak.setToolTipText("CLEAR");
		cetak.setIcon(new ImageIcon(""));//nntik
		
		panel2.add(delete);
		delete.setBounds(15, 215, 120, 60);
		delete.setToolTipText("DELETE");
		delete.setIcon(new ImageIcon(""));//nntik
		
		panel2.add(browse);
		browse.setBounds(15, 280, 120, 55);
		browse.setIcon(new ImageIcon(""));//nntik
		browse.setToolTipText("Pilih Foto Anda");
		
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
		print.setIcon(new ImageIcon(""));//nntik
		/*END PANEL 3*/
		
		getContentPane().add(logo);
		logo.setBounds(50, 10, 200, 80);
		
		getContentPane().add(gambar);
		gambar.setBounds(0, 0, 1020, 560);
		
		tampilTabel();
		setVisible(true);
		
	}
	void aksiReaksi(){
		
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
			Class.forName("com.mysqljdbc.Driver");
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
				g.drawString("Sistem Registrasi Mahasiswa", 150, 40);
				g.setFont(new Font("Dialog", 1, 10));
				g.drawString("Jl. Poloteknik Aceh", 170, 50);
				g.setFont(new Font("Dialog", 1, 9));
				g.drawString("085358484618", 180, 60);
				
				//untukk NAMA KOLOM TABEL
				//BERHENTI
			}
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

