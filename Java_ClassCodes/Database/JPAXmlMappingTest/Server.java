class Server {

	public static void main(String[] args) throws Exception {
		var ds = new oracle.jdbc.pool.OracleConnectionPoolDataSource(); //new com.mysql.cj.jdbc.MysqlConnectionPoolDataSource()
		ds.setURL("jdbc:oracle:thin:@//localhost/xe"); //"jdbc:mysql://localhost/sales"
		ds.setUser("scott");
		ds.setPassword("tiger");
		var naming = new javax.naming.InitialContext(); //connect to name-service specified in jndi.properties
		naming.rebind("jdbc/SalesDB", ds);
		naming.rebind("orderManager", new shopping.OrderManagerService());
	}
}

