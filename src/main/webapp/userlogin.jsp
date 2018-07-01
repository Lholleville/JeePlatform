<%-- 
    Document   : userlogin
    Created on : 29 juin 2018, 15:23:49
    Author     : Loic
--%>


    
                <c:if test="${ !empty SessionScope.user}" >
                    <p><c:out value="Bonjour ${ SessionScope.user }"> </c:out></p>
                </c:if>
                <c:if test="${ user == null}" >
                    <p><c:out value="Email and password don't match !"> </c:out></p>
                </c:if>
                <h2>Login</h2>
                <form method="POST" action="userlogin" class="form-horizontal">
                    <div class="form-group">
                        <label for="email" class="label-control">Email: </label>
                        <input type="email" name="email" id="email" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">Password </label>
                        <input type="password" name="password" id="password" class="form-control"/><br>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Login" class="btn btn-primary"/>
                    </div>
                </form>  
            </div>
        </div>
    </body>
</html>
