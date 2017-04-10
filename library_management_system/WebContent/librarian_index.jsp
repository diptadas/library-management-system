<!DOCTYPE html>
<%@page import="bat.example.CookieRes"%>
<%@page import="bat.example.BookInfo"%>
<%@page import="java.util.List"%>
<html>
   <head>
      <title>Library</title>
      <link rel="stylesheet" href="css/bootstrap.css">
      <link rel="stylesheet" href="css/library.css">
      <link rel="stylesheet" href="css/library2.css">
      <link href="https://fonts.googleapis.com/css?family=EB+Garamond" rel="stylesheet">
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/test.js"></script>
   </head>
   <body>
      <div class="container">
         <div class="row">
            <img class="logo" src="image/book_logo.png">
         </div>
      </div>
      <div class="container">
         <div class="row">
            <div style="margin-top: 50px;" class="col-md-7">
               <form action="BookSearchServlet" method="post">
                  <div class="input-group col-md-offset-1 col-md-10">
                     <input type="text" name="bookName" class="form-control name" placeholder="Book Search...">
                     <span class="input-group-btn">
                     <button class="btn btn-default searchbtn" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                     </span>
                  </div>
                  <br><br>
               </form>
               <div style="margin-top: 10px;" class="test col-md-12">
                  <table class="table table-striped" id="tbl_emp">
                     <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Author</th>
                        <th>Edition</th>
                        <th>Publisher</th>
                        <th>Quantity</th>
                        <th>Issue</th>
                     </tr>
                     <%
                        @SuppressWarnings("unchecked")
                        List<BookInfo> results = (List<BookInfo>) request.getAttribute("bookResult");
                        if(results != null) 
                        {
                        	int i=0;
                        	while(i<results.size())
                        	{
                        		out.println("<tr>");
                        		out.println("<td>" + results.get(i).getName() + "</td>");
                        		out.println("<td>" + results.get(i).getCategory() + "</td>");
                        		out.println("<td>" + results.get(i).getAuthor() + "</td>");
                        		out.println("<td>" + results.get(i).getEdition() + "</td>");
                        		out.println("<td>" + results.get(i).getPublisher() + "</td>");
                        		out.println("<td>" + results.get(i).getQuantity() + "</td>");
                        		out.println("<td><i class='glyphicon glyphicon-pencil' id='isBtn' data-name="+results.get(i).getName()+" data-id="+results.get(i).getBookId()+"></i></td>");
                        		out.println("</tr>");
                        		i++;
                        	}
                        }
                        %>
                  </table>
               </div>
               <!-- /input-group -->
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-4">
               <!--<img src="images/pp/<?php echo $_SESSION['id'];?>.jpg" class="img-responsive img-rounded" width="100" height="80"><br/>-->
               <ul class="nav navbar-nav">
                  <li class="dropdown open">
                     <!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown"> -->    
                     <a href="#" class="" data-toggle="">
                     <% out.println(CookieRes.getCookieValue(request, "name")); %>
                     <span class="glyphicon glyphicon-user pull-right"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target=".edit">Edit Profile <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
                        <li class="divider"></li>
                        <li><a href="#" data-toggle="modal" data-target=".insert">Insert <span class="glyphicon glyphicon-plus pull-right"></span></a></li>
                        <li class="divider"></li>
                        <li><a href="#" data-toggle="modal" data-target=".return">Return <span class="glyphicon glyphicon-arrow-down pull-right"></span></a></li>
                        <li class="divider"></li>
                        <li><a href="#" data-toggle="modal" data-target=".std_status">Student Status <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
                        <li class="divider"></li>
                        <li><a href="#" data-toggle="modal" data-target=".book_status">Book Status <span class="glyphicon glyphicon-book pull-right"></span></a></li>
                        <li class="divider"></li>
                        <li><a href="LogoutServlet" id="signOut">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
                     </ul>
                  </li>
               </ul>
            </div>
         </div>
      </div>
      <!--Edit Profile Modal Start-->
      <div class="modal fade edit" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Edit Profile</h4>
               </div>
               <div class="modal-body">
                  <form>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Name:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" value="" name="lib_name" id="lib_name" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Email:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="email" id="email" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Password:</label></div>
                           <div class="col-md-7">
                              <input type="password" class="form-control" value="" name="password" id="password" required />
                           </div>
                        </div>
                     </div>
                     <!-- <div class="form-group">
                        <div class="row">
                        	<div class="col-md-offset-1 col-md-3"><label>Image (.jpg)</label></div>
                        	<div class="col-md-7">
                        		<input type="file" name="example" id="input01">
                        	</div>
                        </div>
                        </div> -->
                  </form>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="editSubBtn">Save changes</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
      <!--Insert Modal Start-->
      <div class="modal fade insert" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Book Insert</h4>
               </div>
               <div class="modal-body">
                  <form action="InsertBookServlet" method="post">
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Book Name:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="name" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Author:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="author" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Edition:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="edition" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Category:</label></div>
                           <div class="col-md-7">
                              <select class="form-control" name="category">
                                 <option value="Science">Science</option>
                                 <option value="Business">Business</option>
                                 <option value="Literature">Literature</option>
                              </select>
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Publisher:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="publisher" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Quantity:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="quantity" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Done</button>
                     </div>
                  </form>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!--Issue Modal Start-->
      <div class="modal fade issue" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Issue Book</h4>
               </div>
               <div class="modal-body">
                  <form>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Book ID:</label></div>
                           <div class="col-md-7" id="test1"></div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Book Name:</label></div>
                           <div class="col-md-7" id="test2"></div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Student ID:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="student_id" id="std_id" value="" required />
                           </div>
                        </div>
                     </div>
                  </form>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="pro_sub">Done</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!--Return Modal Start-->
      <div class="modal fade return" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Return Book</h4>
               </div>
               <div class="modal-body">
                  <form>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Book ID:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="book_id" id="ret_book_id" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Student ID:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="student_id" id="ret_std_id" value="" required />
                           </div>
                        </div>
                     </div>
                  </form>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="sub_ret">Done</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!--Std_Status Modal Start-->
      <div class="modal fade std_status" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Student Status</h4>
               </div>
               <div class="modal-body">
                  <form>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Student ID:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="student_id" id="std_status_id" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-10 std_status_result">
                              <table class="table table-bordered" id="std_status_res">
                              </table>
                           </div>
                        </div>
                     </div>
                  </form>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="std_status_btn">Done</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!--Book Modal Start-->		
      <div class="modal fade book_status" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="gridSystemModalLabel">Book Status</h4>
               </div>
               <div class="modal-body">
                  <form>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-3"><label>Book ID:</label></div>
                           <div class="col-md-7">
                              <input type="text" class="form-control" name="book_id" id="book_status_id" value="" required />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="row">
                           <div class="col-md-offset-1 col-md-10 book_status_result">
                              <table class="table table-bordered" id="book_status_res">
                              </table>
                           </div>
                        </div>
                     </div>
                  </form>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" id="book_status_btn">Done</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      
      <div class="modal fade" id="myModal" role="dialog">
      	<div class="modal-dialog">
    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header alert-info">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title" id="text"></h4>
	        </div>
	      </div>
      
    	</div>
   	 </div>
   	 
   </body>
</html>