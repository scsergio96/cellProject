package it.rcs.om.event;

import it.rcs.om.cell.AbstractCellOM;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class EventOM {
    @NonNull
    private EventTypeOM eventTypeOM;
    @NonNull
    private AbstractCellOM cellOM;
    @NonNull
    private ZonedDateTime timestamp;
}
