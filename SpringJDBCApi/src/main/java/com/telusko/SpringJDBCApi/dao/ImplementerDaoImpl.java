package com.telusko.SpringJDBCApi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ImplementerDaoImpl implements IImplementerDao 
{
	@Autowired
	private DataSource dataSource;
	private String SQL_QUERY="SELECT * FROM implementers";
	
	List<Implementer> implementers;
	
	@Override
	public List<Implementer> getImplementersInfo() 
	{
		try
		{
			System.out.println("DataSource implementation class name :"+dataSource.getClass().getName());
		
			Connection connection = dataSource.getConnection();
			System.out.println(" Connection name from Hikari CP "+connection.getClass().getName());
			
			PreparedStatement pstmnt = connection.prepareStatement(SQL_QUERY);
			
			ResultSet rs = pstmnt.executeQuery();
			implementers=new ArrayList<>();
			/*
			 * rs.next(); Integer id=rs.getInt(1); rs.getString(2)
			 */
			
			while(rs.next())
			{
				Implementer impl=new Implementer();
				
//				Integer id=rs.getInt(1);
//				impl.setId(id);
//				String name=rs.getString(2);
//				impl.setName(name);
				
				impl.setId(rs.getInt(1));
				impl.setName(rs.getString(2));
				impl.setCity(rs.getString(3));
				
				implementers.add(impl);
				
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return implementers;
	}

}
