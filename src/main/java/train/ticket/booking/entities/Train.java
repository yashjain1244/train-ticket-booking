package train.ticket.booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainNo;
    private String trainId;

    private List<List<Boolean>> seats;
    private Map<String, Time> stations;


}
