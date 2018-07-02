<%-- 
    Document   : home
    Created on : 29 juin 2018, 15:43:59
    Author     : Loic
--%>
        <c:if test="${ empty SessionScope.user }">
            <a href="userlogin">Login</a>
            <a href="userreg">Register</a>
            <a href="devices">Devices List</a>
        </c:if>
        <c:if test="${ !empty SessionScope.user }">
             <a href="userlogout">Log Out</a>
        </c:if>
            </div>
        </div>
    </body>
</html>
