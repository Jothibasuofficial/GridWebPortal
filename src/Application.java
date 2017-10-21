import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class Application extends HttpServlet
{
HttpServletRequest req; //request
HttpServletResponse res; //response
//JSPBean jspbean = new JSPBean();
PrintWriter out;
String[] submit;
String[] getresult;
String[] getstatus;
String[] logout;
String[] appselect;


public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
{
			performTask(req, resp);
}



public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
{
	performTask(req, resp);
}

public void performTask(HttpServletRequest request, HttpServletResponse response)
throws ServletException 
{
req = request;
res = response;
res.setContentType("text/html");
res.setHeader("Pragma", "no-cache");
res.setHeader("Cache-control", "no-cache");
try {
out = res.getWriter();
} 
catch (IOException e)
{
	System.err.println("Application:getWriter:" + e);
}



try {
// Which button selected?
submit = req.getParameterValues("submit");
getresult = req.getParameterValues("result");
getstatus = req.getParameterValues("status");
logout = req.getParameterValues("logout");
// Which application was selected?
appselect = req.getParameterValues("appselect");
if (submit != null && submit.length > 0)
submitApplication(); // submit Application.
else if (getresult != null && getresult.length > 0)
getResult(); // get run result.
else if (getstatus != null && getstatus.length > 0)
getStatus(); // get Application status.
else if (logout != null && logout.length > 0)
doLogout(); // logout.
else
invalidInput();
}
 catch (Throwable theException) {
// uncomment the following line when unexpected exceptions are 
//occuring to aid in debugging the problem
// theException.printStackTrace();
throw new ServletException(theException);
}
}

private void submitApplication() {
if (appselect[0].equals("weather"))
submitWeather();
else if (appselect[0].equals("gene"))
submitGene();
else if (appselect[0].equals("test"))
submitTest();
else if (appselect[0].equals("demo"))
submitDemo();
else
invalidSelection();
}
private void submitWeather() {
/**
* Add code to submit the weather application here
*/

String title = "Submit weather application";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"#cfd09d\" text=\"#000099\">");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		out.println("</body>");
		out.println("</html>");


}
private void submitGene() {

/**
* Add code to submit the gene application here
*/

String title = "Submit gene application";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"#cfd09d\" text=\"#000099\">");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		out.println("</body>");
		out.println("</html>");




}
private void submitTest() {
/**
* Add code to submit the test application here
*/

String title = "Submit test application";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"#cfd09d\" text=\"#000099\">");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		
		out.println("</body>");
		out.println("</html>");



}
private void submitDemo() {
/**
* Add code to submit the demo application here
*/

String title = "Submit Demo application";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"#cfd09d\" text=\"#000099\">");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		out.println("</body>");
		out.println("</html>");


}
private void getResult() {
/**
* Add code to get the Application results here
*/
}
private void getStatus() {
/**
* Add code to get the Application status here
*/
}
private void doLogout() {
System.out.println("doLogout: forwarding to login page");
try {
RequestDispatcher rd =
getServletContext().getRequestDispatcher("/login.html");
rd.forward(req, res);
} catch (javax.servlet.ServletException e) {
System.out.println(e);
} catch (java.io.IOException e) {
System.out.println(e);
}
}
private void invalidSelection() {

System.out.println("invalid selection");
		String title = "Invalid selection";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"#cfd09d\" text=\"#000099\">");
		out.println("<h1 align=\"center\">" + title + "</h1>");
		out.println("</body>");
		out.println("</html>");

}
private void invalidInput() {
// Something was wrong with the client input
try {
RequestDispatcher rd =
getServletContext().getRequestDispatcher("invalidInput.html");
rd.forward(req, res);
} catch (javax.servlet.ServletException e) {
System.out.println(e);
} catch (java.io.IOException e) {
System.out.println(e);
}
}
private void sendResult(String[] list) {
int size = list.length;
for (int i = 0; i < size; i++) {
String s = list[i];
out.println(s + "<br>");
//System.out.println("s=" + s); //trace
} //end for
}
}
