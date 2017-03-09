/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ismael Nascimento
 */
public class Data {
    public static Connection conn = null; 
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    private String str = ""; //String query SQL server CRUD (Create, Read, Update and Delete)
    private boolean check  = false;
    
    public static Connection getConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver"); //add JDBC
            conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyCrudDB", "meuatendimento", "meuatendimento");
            System.out.println("Conexão ok");
            
            return conn;
        }
        catch (Exception ex) {
            System.out.println("Conexão fail");
            
            return null;
        }
    }
    
    public static void CloseAll(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException error)
            {
                System.out.println(error);
            }
        }
        
        if(pstmt != null)
        {
            try
            {
                pstmt.close();
            }
            catch(SQLException error)
            {
                System.out.println(error);
            }
        }
        
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException error)
            {
                System.out.println(error);
            }
        }
    }
    
    //public static void main(String[] args)
    //{
    //    System.out.println(getConnection());
    //}
    
    public ArrayList<StudentForm> getAllStudents()
    {
        str = "SELECT * FROM public.students";
        
        ArrayList<StudentForm> arr = new ArrayList<>();
        getConnection();
        
        try
        {
            pstmt = conn.prepareStatement(str);
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                StudentForm st = new StudentForm();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setAge(rs.getInt("age"));
                st.setEmail(rs.getString("email"));
                st.setAdress(rs.getString("adress"));
                st.setPhone(rs.getString("phone"));
                arr.add(st);
            }
        }
        catch(SQLException error)
        {
            System.out.println("getAllStudents, errors: " + error);
        }
        
        return arr;
    }
    
    public boolean AddStudent(StudentForm sf)
    {
        str = "INSERT INTO students (name, age, email, adress, phone) values (?, ?, ?, ?, ?)";
        getConnection();
        try {            
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, sf.getName());
            pstmt.setInt   (2,    sf.getAge());
            pstmt.setString(3, sf.getEmail());
            pstmt.setString(4, sf.getAdress());
            pstmt.setString(5, sf.getPhone());
            
            int executeUpdate = pstmt.executeUpdate();
            
            if(executeUpdate > 0)
            {
                check = true;
                System.out.println(check);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
    }
    
    public boolean DeleteStudent(int id)
    {
        str = "DELETE FROM students where id = ?";
        getConnection();
        try 
        {
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, id);
            int executeUpdate = pstmt.executeUpdate();
            
            if(executeUpdate > 0)
            {
                check = true;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
    }
    
    public ArrayList<StudentForm> getStudent(int id)
    {
        str = "SELECT * FROM students WHERE id = ?";
        
        ArrayList<StudentForm> arr = new ArrayList<>();
        getConnection();
        
        try
        {
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next())
            {
                StudentForm st = new StudentForm();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setAge(rs.getInt("age"));
                st.setEmail(rs.getString("email"));
                st.setAdress(rs.getString("adress"));
                st.setPhone(rs.getString("phone"));
                arr.add(st);
            }
        }
        catch(SQLException error)
        {
            System.out.println("getAllStudents, errors: " + error);
        }
        
        return arr;
    }
    
    public boolean UpdateStudent(StudentForm sf)
    {
        str = "UPDATE students name = ?, age = ?, email = ?, adress = ?, phone = ? WHERE id = ?";
        getConnection();
        try {            
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, sf.getName());
            pstmt.setInt   (2,    sf.getAge());
            pstmt.setString(3, sf.getEmail());
            pstmt.setString(4, sf.getAdress());
            pstmt.setString(5, sf.getPhone());
            pstmt.setInt   (6,    sf.getId());
            
            int executeUpdate = pstmt.executeUpdate();
            
            if(executeUpdate > 0)
            {
                check = true;
                System.out.println(check);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
    }
    
}
