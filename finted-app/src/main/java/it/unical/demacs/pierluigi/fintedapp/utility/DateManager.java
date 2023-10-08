package it.unical.demacs.pierluigi.fintedapp.utility;

import java.sql.Date;
import java.util.Calendar;

public class DateManager {
    private static DateManager instance;
    private DateManager(){}

    public static DateManager getInstance(){
        if(instance == null)
            instance = new DateManager();
        
        return instance;
    }

    public Date currentDate(){
        return new Date(Calendar.getInstance().getTime().getTime());
    }
}
