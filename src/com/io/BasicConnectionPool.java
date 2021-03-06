package com.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool 
  implements ConnectionPool {
	private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 10;
     
    public BasicConnectionPool(String url2, String user2, String password2,
			List<Connection> pool) {
		// TODO Auto-generated constructor stub
	}
	public static BasicConnectionPool create(String url, String user,String password) throws SQLException {
  
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new BasicConnectionPool(url, user, password, pool);
    }
    // standard constructors
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Connection> getConnectionPool() {
		return connectionPool;
	}

	public void setConnectionPool(List<Connection> connectionPool) {
		this.connectionPool = connectionPool;
	}

	public List<Connection> getUsedConnections() {
		return usedConnections;
	}

	public void setUsedConnections(List<Connection> usedConnections) {
		this.usedConnections = usedConnections;
	}

	public static int getINITIAL_POOL_SIZE() {
		return INITIAL_POOL_SIZE;
	}

	public static void setINITIAL_POOL_SIZE(int iNITIAL_POOL_SIZE) {
		INITIAL_POOL_SIZE = iNITIAL_POOL_SIZE;
	}

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool
          .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }
     
    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
     
    private static Connection createConnection(
      String url, String user, String password) 
      throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
     
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
 
    // standard getters
}