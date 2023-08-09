package com.sanjok.generator.utl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sanjok
 */
public class DBUtil {

    private static final String USERNAME = "sanjok";
    private static final String PASSWORD = "sanjok";
    private static final String H_CONN_STRING = "jdbc:hsqldb:data/generator";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost:3307/question_generator";

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection(DBType.MYSQL);
        System.out.println(connection + "-----------------------");
    }

    public static Connection getConnection(DBType dbtype) throws SQLException {
        try {
            switch (dbtype) {
                case MYSQL:
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                case HSQL:
                    return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, "DBUtil.getConnection()Error -->", ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void processException(SQLException e) {
        System.err.println("DBUtil.getConnection()Error -->");
        System.err.println("Erroe message:" + e.getMessage());
        System.err.println("Error code:" + e.getErrorCode());
        System.err.println("Error State:" + e.getSQLState());
        System.err.println("Error State:" + Arrays.toString(e.getStackTrace()));

    }
}
