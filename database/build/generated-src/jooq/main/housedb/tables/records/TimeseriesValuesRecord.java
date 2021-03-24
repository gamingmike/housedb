/*
 * This file is generated by jOOQ.
 */
package housedb.tables.records;


import housedb.tables.TimeseriesValues;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TimeseriesValuesRecord extends UpdatableRecordImpl<TimeseriesValuesRecord> implements Record4<Long, OffsetDateTime, Double, Integer> {

    private static final long serialVersionUID = -746418894;

    /**
     * Setter for <code>housedb.timeseries_values.timeseries_id</code>.
     */
    public void setTimeseriesId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>housedb.timeseries_values.timeseries_id</code>.
     */
    public Long getTimeseriesId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>housedb.timeseries_values.date_time</code>.
     */
    public void setDateTime(OffsetDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>housedb.timeseries_values.date_time</code>.
     */
    public OffsetDateTime getDateTime() {
        return (OffsetDateTime) get(1);
    }

    /**
     * Setter for <code>housedb.timeseries_values.value</code>.
     */
    public void setValue(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>housedb.timeseries_values.value</code>.
     */
    public Double getValue() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>housedb.timeseries_values.quality</code>.
     */
    public void setQuality(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>housedb.timeseries_values.quality</code>.
     */
    public Integer getQuality() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, OffsetDateTime> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, OffsetDateTime, Double, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, OffsetDateTime, Double, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TimeseriesValues.TIMESERIES_VALUES.TIMESERIES_ID;
    }

    @Override
    public Field<OffsetDateTime> field2() {
        return TimeseriesValues.TIMESERIES_VALUES.DATE_TIME;
    }

    @Override
    public Field<Double> field3() {
        return TimeseriesValues.TIMESERIES_VALUES.VALUE;
    }

    @Override
    public Field<Integer> field4() {
        return TimeseriesValues.TIMESERIES_VALUES.QUALITY;
    }

    @Override
    public Long component1() {
        return getTimeseriesId();
    }

    @Override
    public OffsetDateTime component2() {
        return getDateTime();
    }

    @Override
    public Double component3() {
        return getValue();
    }

    @Override
    public Integer component4() {
        return getQuality();
    }

    @Override
    public Long value1() {
        return getTimeseriesId();
    }

    @Override
    public OffsetDateTime value2() {
        return getDateTime();
    }

    @Override
    public Double value3() {
        return getValue();
    }

    @Override
    public Integer value4() {
        return getQuality();
    }

    @Override
    public TimeseriesValuesRecord value1(Long value) {
        setTimeseriesId(value);
        return this;
    }

    @Override
    public TimeseriesValuesRecord value2(OffsetDateTime value) {
        setDateTime(value);
        return this;
    }

    @Override
    public TimeseriesValuesRecord value3(Double value) {
        setValue(value);
        return this;
    }

    @Override
    public TimeseriesValuesRecord value4(Integer value) {
        setQuality(value);
        return this;
    }

    @Override
    public TimeseriesValuesRecord values(Long value1, OffsetDateTime value2, Double value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TimeseriesValuesRecord
     */
    public TimeseriesValuesRecord() {
        super(TimeseriesValues.TIMESERIES_VALUES);
    }

    /**
     * Create a detached, initialised TimeseriesValuesRecord
     */
    public TimeseriesValuesRecord(Long timeseriesId, OffsetDateTime dateTime, Double value, Integer quality) {
        super(TimeseriesValues.TIMESERIES_VALUES);

        set(0, timeseriesId);
        set(1, dateTime);
        set(2, value);
        set(3, quality);
    }
}