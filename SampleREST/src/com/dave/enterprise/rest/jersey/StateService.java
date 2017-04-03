package com.dave.enterprise.rest.jersey;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.Version;
import org.json.JSONException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.*;

import com.dave.enterprise.rest.objects.*;
import java.sql.PreparedStatement;
 
@Path("/stateservice")
public class StateService {
 
	  @GET
	  @Produces("application/json")
	  public Response getStates() throws JSONException, ParseException {
	        Connection con = null;
	        Statement st = null;
	        ResultSet rs = null;
	        
	        StateList list = new StateList();
			List<State> states = new ArrayList<State>();
			int numberOfStates=0;

	        String url = "jdbc:mysql://localhost:3306/Development?useSSL=false";
	        String user = "dankmemes";
	        String password = "dank";

	        try {
	        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	            con = DriverManager.getConnection(url, user, password);
	            st = con.createStatement();
	            rs = st.executeQuery("Select * from State");

	            while (rs.next()) {
	            	
	        	    State myState = new State();
	        		
	        		myState.setStateID(rs.getInt(1));
	        		myState.setName(rs.getString(2));
	        		myState.setPopulation(rs.getInt(3));

	        		
	        		states.add(myState);
	            	
	        		numberOfStates++;
	            }

	        } catch (SQLException ex) {
	        
	            Logger lgr = Logger.getLogger(Version.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            
	            try {
	                
	                if (rs != null) {
	                    rs.close();
	                }
	                
	                if (st != null) {
	                    st.close();
	                }
	                
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                
	                Logger lgr = Logger.getLogger(Version.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
		  
		
		list.setNumberOfStates(numberOfStates);
		
		list.setStates(states);
		
		return Response.status(200).entity(list).build();
	  }
	  
	  @POST
	  @Produces("application/json")
	  public Response CreateState(State state) throws JSONException, ParseException {
	        Connection con = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;

	        String url = "jdbc:mysql://localhost:3306/Development?useSSL=false";
	        String user = "dankmemes";
	        String password = "dank";

	        try {
	        	String query=" insert into State (Name, Population) values (?,?)";
	        	
	        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	            con = DriverManager.getConnection(url, user, password);
	            st = con.prepareStatement(query);
	           
	            st.setString(1, state.getName());
	            st.setInt(2, state.getPopulation());
	            
	            st.execute();
	        } catch (SQLException ex) {
	        
	            Logger lgr = Logger.getLogger(Version.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            
	            try {
	                
	                if (rs != null) {
	                    rs.close();
	                }
	                
	                if (st != null) {
	                    st.close();
	                }
	                
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                
	                Logger lgr = Logger.getLogger(Version.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
		  

		return Response.status(200).entity(state).build();
	  }

}