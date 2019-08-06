package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry createLocal = timeEntryRepository.create(timeEntryToCreate);

        return new ResponseEntity(createLocal, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry createLocal = timeEntryRepository.find(timeEntryId);
        if (createLocal==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(createLocal);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {

        TimeEntry createLocal =  timeEntryRepository.update(timeEntryId, expected);
        if (createLocal==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(createLocal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<TimeEntry>> list() {

       return ResponseEntity.ok(timeEntryRepository.list());
    }

}
