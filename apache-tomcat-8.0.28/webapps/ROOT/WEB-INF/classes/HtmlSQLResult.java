import java.sql.*;



public class HtmlSQLResult{

	private String sql;

	private Connection con;

	

	public HtmlSQLResult(String sql,Connection con){

		this.sql = sql;

		this.con = con;

	}

	

	public String toString(){

		StringBuffer out = new StringBuffer();

		String pState = "";

		System.out.println ("HtmlSQLResult: "+sql);

		try{

			Statement stmt = con.createStatement();

			//System.out.println("test");

			System.out.println ("HtmlSQLResult sql: "+sql);
			System.out.println ();

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				pState = rs.getString("pState");

			}

				//out.append("<TABLE>\n");



//				ResultSetMetaData rsmd = rs.getMetaData();

//				int numcols = rsmd.getColumnCount();

				//out.append("<TR>");

/*				

				while(rs.next()){

					//out.append("<TR>");

					for(int i=1;i<=numcols;i++){

					//	out.append("<TD>");

						Object obj = rs.getObject(i);

						if(obj != null)

							out.append(obj.toString());

						else

							out.append("&nbsp;");

					}

					//out.append("</TR>\n");

				}

				

				//out.append("</TABLE>\n");

			}

			else{

				out.append("<B>Records Affected:</B>" + stmt.getUpdateCount());

			}

			*/

		}catch(SQLException e){

			out.append("</TABLE><H1>ERROR:</H1>" + e.getMessage());

		}

		System.out.println ("HtmlResult pState:"+pState);

		return pState+"."+out.toString();

	}

}