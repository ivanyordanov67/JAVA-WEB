package services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServiceImpl implements DateService {

  private static final String DATE_FORMAT  = "dd/MM/yyyy HH:mm:ss";

    @Override
    public String getNowFormatted() {

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        return formatter.format(date);
    }
}
