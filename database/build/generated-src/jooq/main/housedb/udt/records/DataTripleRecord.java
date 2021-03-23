/*
 * This file is generated by jOOQ.
 */
package housedb.udt.records;


import housedb.udt.DataTriple;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UDTRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataTripleRecord extends UDTRecordImpl<DataTripleRecord> implements Record3<OffsetDateTime, Double, Integer> {

    private static final long serialVersionUID = -2141665331;

    /**
     * Setter for <code>housedb.data_triple.date_time</code>.
     */
    public void setDateTime(OffsetDateTime value) {
        set(0, value);
    }

    /**
     * Getter for <code>housedb.data_triple.date_time</code>.
     */
    public OffsetDateTime getDateTime() {
        return (OffsetDateTime) get(0);
    }

    /**
     * Setter for <code>housedb.data_triple.value</code>.
     */
    public void setValue(Double value) {
        set(1, value);
    }

    /**
     * Getter for <code>housedb.data_triple.value</code>.
     */
    public Double getValue() {
        return (Double) get(1);
    }

    /**
     * Setter for <code>housedb.data_triple.quality</code>.
     */
    public void setQuality(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>housedb.data_triple.quality</code>.
     */
    public Integer getQuality() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<OffsetDateTime, Double, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<OffsetDateTime, Double, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<OffsetDateTime> field1() {
        return DataTriple.DATE_TIME;
    }

    @Override
    public Field<Double> field2() {
        return DataTriple.VALUE;
    }

    @Override
    public Field<Integer> field3() {
        return DataTriple.QUALITY;
    }

    @Override
    public OffsetDateTime component1() {
        return getDateTime();
    }

    @Override
    public Double component2() {
        return getValue();
    }

    @Override
    public Integer component3() {
        return getQuality();
    }

    @Override
    public OffsetDateTime value1() {
        return getDateTime();
    }

    @Override
    public Double value2() {
        return getValue();
    }

    @Override
    public Integer value3() {
        return getQuality();
    }

    @Override
    public DataTripleRecord value1(OffsetDateTime value) {
        setDateTime(value);
        return this;
    }

    @Override
    public DataTripleRecord value2(Double value) {
        setValue(value);
        return this;
    }

    @Override
    public DataTripleRecord value3(Integer value) {
        setQuality(value);
        return this;
    }

    @Override
    public DataTripleRecord values(OffsetDateTime value1, Double value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DataTripleRecord
     */
    public DataTripleRecord() {
        super(DataTriple.DATA_TRIPLE);
    }

    /**
     * Create a detached, initialised DataTripleRecord
     */
    public DataTripleRecord(OffsetDateTime dateTime, Double value, Integer quality) {
        super(DataTriple.DATA_TRIPLE);

        set(0, dateTime);
        set(1, value);
        set(2, quality);
    }
}
