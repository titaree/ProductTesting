import java.sql.*;

public class Product {

	private String product_id;
	private String product_name;
	private int product_price;
	
	public void setProduct(String p_id, String p_name, int p_price) {
		product_id = p_id;
		product_name = p_name;
		product_price = p_price;
	}

	public String getProductId() {
		return product_id;
	}

	public String getProductName() {
		return product_name;
	}

	public int getProductPrice() {
		return product_price;
	}

	public void insertProduct(String pid, String pname, int pprice) {
		Connection myConn = null;
		Statement myStmt = null;
//		ResultSet myRs = null;
//		String getProductId="";
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root" , "");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "INSERT INTO Product " +
	                   "VALUES ('pid','pname',pprice)";
			myStmt.executeUpdate(sql);
			
			
			// 4. Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("p_id") + ", " + myRs.getString("p_name")+ ", " + myRs.getInt("p_price"));
//				getProductId = myRs.getString("p_id");
//				System.out.println(getProductId);
//			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public String queryProductId(String pid) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String getProductId="";
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root" , "");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from product where p_id='"+pid+"'");
			
			// 4. Process the result set
			while (myRs.next()) {
				getProductId = myRs.getString("p_id");
			}
			System.out.println(getProductId);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return getProductId;
	}

}
