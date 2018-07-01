<%-- 
    Document   : index
    Created on : 28 juin 2018, 14:38:03
    Author     : Loic
--%>


  
                <c:if test="${ !empty name}" >
                    <p><c:out value="Bonjour ${ name }"> </c:out></p>
                </c:if>
           
                <h2>Register a new user</h2>
                <form method="POST" action="userreg" class="form-horizontal">
                    <div class="form-group">
                        <label for="name" class="label-control">Name: </label>
                        <input type="text" name="name" id="name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">Password </label>
                        <input type="password" name="password" id="password" class="form-control"/><br>
                    </div>
                    <div class="form-group">
                        <label for="email" class="label-control">Email : </label>
                        <input type="email" name="email" id="email" class="form-control"/><br>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Register" class="btn btn-primary"/>
                    </div>
                </form>  
            </div>
        </div>
    </body>
</html>
