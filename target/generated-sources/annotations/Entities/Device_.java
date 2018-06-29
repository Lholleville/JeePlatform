package Entities;

import Entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-29T14:38:09")
@StaticMetamodel(Device.class)
public class Device_ { 

    public static volatile SingularAttribute<Device, Integer> deviceType;
    public static volatile SingularAttribute<Device, String> unit;
    public static volatile SingularAttribute<Device, Integer> user_id;
    public static volatile SingularAttribute<Device, String> name;
    public static volatile SingularAttribute<Device, Integer> id;
    public static volatile ListAttribute<Device, User> users;
    public static volatile SingularAttribute<Device, Integer> status;

}