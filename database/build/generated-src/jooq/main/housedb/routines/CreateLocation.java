/*
 * This file is generated by jOOQ.
 */
package housedb.routines;


import housedb.Housedb;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CreateLocation extends AbstractRoutine<Long> {

    private static final long serialVersionUID = 286286842;

    /**
     * The parameter <code>housedb.create_location.RETURN_VALUE</code>.
     */
    public static final Parameter<Long> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BIGINT, false, false);

    /**
     * The parameter <code>housedb.create_location.location</code>.
     */
    public static final Parameter<String> LOCATION = Internal.createParameter("location", org.jooq.impl.SQLDataType.CLOB, false, false);

    /**
     * Create a new routine call instance
     */
    public CreateLocation() {
        super("create_location", Housedb.HOUSEDB, org.jooq.impl.SQLDataType.BIGINT);

        setReturnParameter(RETURN_VALUE);
        addInParameter(LOCATION);
    }

    /**
     * Set the <code>location</code> parameter IN value to the routine
     */
    public void setLocation(String value) {
        setValue(LOCATION, value);
    }

    /**
     * Set the <code>location</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setLocation(Field<String> field) {
        setField(LOCATION, field);
    }
}
