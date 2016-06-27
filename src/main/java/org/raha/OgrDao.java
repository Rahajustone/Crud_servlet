
package org.raha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmetullahh
 */
public class OgrDao {
    public static Connection getConnection(){
        Connection con=null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testtozlu", "root","");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
        return con;
    }
    public static int saveOgr(Ogrtest ogr)
    {
        int status=0;
        try {
            Connection con=OgrDao.getConnection();
            PreparedStatement  ps=con.prepareStatement("insert into ogrtest values(?,?,?,?)");
            ps.setInt(1,ogr.getId());
            ps.setString(2,ogr.getName());
            ps.setString(3,ogr.getPassword());
            ps.setString(4,ogr.getEmail());
            ps.setString(5,ogr.getCountry());
            status=ps.executeUpdate();
            con.close();
                    
            
        }
        catch(Exception ex )
        {
            ex.printStackTrace();
            
        }
        
        
        return status;  
    }
    public static int ogrUpdate(Ogrtest ogr)
    {
        int status=0;
        try {
            Connection con=OgrDao.getConnection();
            PreparedStatement  ps=con.prepareStatement("update ogrtest set id=?,name=?,password=?,email=?,country=? ");
            ps.setInt(1,ogr.getId());
            ps.setString(2,ogr.getName());
            ps.setString(3,ogr.getPassword());
            ps.setString(4,ogr.getEmail());
            ps.setString(5,ogr.getCountry());
            status=ps.executeUpdate();
            con.close();
                    
            
        }
        catch(Exception ex )
        {
            ex.printStackTrace();
            
        }
        
        
        return status;  
    }
    public static Ogrtest delate(int id) 
    {
        Ogrtest e=new Ogrtest();
        int status;
        try
        {
            Connection con=OgrDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from ogrtest where id=?");
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
        
    }
      public static Ogrtest getEmployeeById(int id){  
        Ogrtest e=new Ogrtest();  
          
        try{  
            Connection con=OgrDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ogrtest where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Ogrtest> listallogr()
    {
        List<Ogrtest> list=new ArrayList<Ogrtest>();
         try{  
            Connection con=OgrDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ogrtest");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Ogrtest e=new Ogrtest();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
        
    }
    
    

