package Entities;

import Entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-29T14:38:09")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> mobileToken;
    public static volatile SingularAttribute<User, Integer> role;
    public static volatile SingularAttribute<User, String> mail;
    public static volatile SingularAttribute<User, String> pass;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, User> users;
    public static volatile SingularAttribute<User, String> username;

}