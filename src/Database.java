import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Database {
	void koneksiDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/politeknikaceh","root","");
			JOptionPane.showMessageDialog(null, "Koneksi Berhasil","Report KOneksi",JOptionPane.INFORMATION_MESSAGE);
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());;
		}
	}
	public static void main(String[] args) {
		Database db= new Database();
		db.koneksiDB();
	}
}
