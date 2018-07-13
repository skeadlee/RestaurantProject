package models;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Optional;

public class TimeSlot {
    private final Optional<TemporalAccessor> start;
    private final TemporalAmount temporalAmount;

    public TimeSlot(final TemporalAccessor start, final TemporalAmount temporalAmount) {
        this.start = Optional.of(start);
        this.temporalAmount = temporalAmount;
    }

    public TimeSlot(final TemporalAmount temporalAmount) {
        this.start = Optional.empty();
        this.temporalAmount = temporalAmount;
    }

    public Optional<TemporalAccessor> getStart() {
        return this.start;
    }

    public TemporalAmount getTemporalAmount() {
        return this.temporalAmount;
    }
}