
                <h2>Add a device</h2>
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label for="name" class="label-control">Name:</label>
                        <input type="text" class="form-control" id="name" placeholder="MAC Address" name="name"/>
                    </div>
                   <div class="form-group">
                        <label for="unit" class="label-control">Unit:</label>
                        <input type="text" class="form-control" id="unit" name="unit" placeholder="Km/h, °C, s ..."/>
                    </div>
                    <div class="form-group">
                        <label for="status" class="label-control">Status</label>
                        <select name="status" id="status" class="form-control">
                            <option value="1" style="color:green;">Online</option>
                            <option value="2" style="color:red;">Offline</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="user" class="label-control">Owner:</label>
                        <select name="user_id" id="user" class="form-control">
                            <c:forEach items="${ ListUser}" var="user">
                                <option value="${user.getId()}">${user.getUsername()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                   <div class="form-group">
                        <label for="devicetype" class="label-control">DeviceType:</label>
                        <select name="devicetype" id="user" class="form-control">
                            <c:forEach items="${ ListDeviceType}" var="dt">
                                <option value="${dt.getId()}">${dt.getDevicetype()}</option>
                            </c:forEach>
                        </select>
                    </div> 
                   
                    <div class="form-group">
                        <label for="" class="label-control"></label>
                        <input type="submit" class="btn btn-success" value="Submit"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
