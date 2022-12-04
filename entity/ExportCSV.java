package br.com.sefin.service.dto.csv;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ExportCSV {

    protected static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    protected static final ZoneId ZONE_ID = ZoneId.of("America/Fortaleza");
}
