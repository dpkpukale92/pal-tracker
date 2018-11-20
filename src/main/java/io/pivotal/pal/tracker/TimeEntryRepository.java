package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry any) ;

    public TimeEntry find(Long timeEntryId) ;

    public TimeEntry update(Long timeEntryId, TimeEntry expected) ;

    public List<TimeEntry> list();

    public void delete(Long id);


}
