package com.soap.ssh.excel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcelDateUtil {

    private static final String timePattern="yyyy/MM/dd hh:mm:ss";

    static public LocalDateTime  formatDate(String dateValue){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timePattern);
        LocalDateTime time = LocalDateTime.parse(dateValue, dtf);
        return time;
    }
}
