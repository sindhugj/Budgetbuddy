<%
if(session.getAttribute("sstate")!=null)
       {
%>
	<div class="wrap">
		
            <%@include file="includes/statehead.jsp"  %>
		<div class="clear"></div>
<link href="styles.css" rel="stylesheet" type="text/css"></link>
            <script src="scriptaculous/lib/prototype.js" type="text/javascript"></script>
		<script src="scriptaculous/src/effects.js" type="text/javascript"></script>

		<script type="text/javascript" src="fabtabulous.js"></script>
		<script type="text/javascript" src="validation.js"></script>
                
                
		<div id="left">
                    <center>
                        <h1>Allotting Budget</h1>
                        <%
if(request.getAttribute("msg")!=null)
{%>
<font color="red" size="4"><%=request.getAttribute("msg")%></font>                  
                        <%
  
}                           
if(request.getParameter("a")!=null)
{
    %>
    <font color="red" size="4"><%=request.getParameter("a")%></font>                   
<%
}
%>
                        <form action="allottodistrict.jsp" method="POST" id="test">
                         <table border="0">
                      <tr>
                                        <td>District Name</td>
                                        <td><select name="district" class="validate-selection" >
                                                
                                                <option value="">Select District</option>
                          
                                                <%
    String sid=session.getAttribute("sstatename").toString();
                                                
java.sql.Connection con=DB.MyDBBean.getDBConnection();
String q="select * from districtofficer where statename='"+sid+"'";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);
while(rs.next())
{                                               


%>
                                                
<option value="<%=rs.getString(6)%>"><%=rs.getString(6)%></option>

<%
}
%>
                                          
                                            </select></td>
                                    </tr>
                                    <tr><td></td><td><input type="submit" value="Proceed">
                                            
                                            </td></tr>
                                    
                            </table>

                        
                        
                        </form>    
                        
                        
                    </center>
               
                    
                </div>
		
	
	</div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 <%@include file="includes/footer.jsp"  %>
  <%@include file="foot.jsp"  %>
<%  }
else
       {
    response.sendRedirect("index.jsp");
}%>