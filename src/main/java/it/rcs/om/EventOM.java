package it.rcs.om;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class EventOM {
    private EventTypeOM eventTypeOM;
    private AbstractCellOM cellOM;
    private ZonedDateTime timestamp;
}
