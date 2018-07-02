<%-- 
    Document   : device
    Created on : 1 juil. 2018, 18:58:11
    Author     : Loic
--%>   
                <h2>Liste des devices <a class="btn btn-success" href="addDevice">+</a></h2>
                <table class="table table-striped">
                    <tr>
                        <th>MAC address</th>
                        <th>Device Type</th>
                        <th>Unit</th>
                        <th>Status</th>
                        <th>User</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${ListeDevice}" var="device">
                        <tr>      
                            <td><c:out value="${device.getName()}"></c:out></td>
                            <td><c:out value="${device.getDeviceTypeObject(device.getDeviceType())}"></c:out></td>
                            <td><c:out value="${device.getUnit()}"></c:out></td>
                            <td><c:out value="${device.getStatus()}"></c:out></td>
                            <td><c:out value="${device.getUser(device.getUser_id())}"></c:out></td>
                            <td><a href="devices/edit?id=${device.getId()}" class="btn btn-primary">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
