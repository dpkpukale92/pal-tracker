package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    private HashMap<Long, TimeEntry> data;

    private int count;

    public InMemoryTimeEntryRepository() {
        count=0;
        data = new HashMap<>();
    }

    @Override
    public TimeEntry create(TimeEntry te) {

        if(te.getId() == 0) te.setId(++count);
        data.put(te.getId(), te);
        return te;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return data.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry expected) {
        if(!data.containsKey(timeEntryId)) return null;

        expected.setId(timeEntryId);
        data.put(timeEntryId, expected);



        return expected;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList(data.values());
    }

    @Override
    public void delete(long id) {
        data.remove(id);

    }
}
