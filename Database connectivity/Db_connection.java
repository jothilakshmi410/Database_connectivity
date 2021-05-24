package com.anna.msccs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_connection
{

	public static void main(String[] args)
	{
		Connection Connect = null;
		Statement Statement = null;
		ResultSet Result = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_students","root", "");
			Statement = Connect.createStatement();
			String strQuery = "select * from cs_namelist";

			Result = Statement.executeQuery(strQuery);

			while (Result.next())
			{

				System.out.println("Reg No : " +Result.getInt(1) + " Name : " + Result.getString(2)+"   " + " Dept : "
						+ Result.getString(3) + "  "+ " Branch : " + Result.getString(4));

			}
			

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				Result.close();
				Statement.close();
			    Connect.close();
			}
			catch (SQLException ex)
			{
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			catch (NullPointerException ec)
			{
				ec.printStackTrace();	
		    }

	}
	}
}