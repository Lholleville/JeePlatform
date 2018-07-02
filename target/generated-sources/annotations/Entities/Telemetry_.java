package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T10:39:02")
@StaticMetamodel(Telemetry.class)
public class Telemetry_ { 

    public static volatile SingularAttribute<Telemetry, String> metricName;
    public static volatile SingularAttribute<Telemetry, String> metricValue;
    public static volatile SingularAttribute<Telemetry, Date> metricDate;
    public static volatile SingularAttribute<Telemetry, Integer> id;
    public static volatile SingularAttribute<Telemetry, Integer> deviceId;

}