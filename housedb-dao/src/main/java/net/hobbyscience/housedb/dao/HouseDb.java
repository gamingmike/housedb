package net.hobbyscience.housedb.dao;

import java.sql.Connection;
import java.time.OffsetDateTime;

import java.util.logging.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import net.hobbyscience.housedb.housedb.tables.*;
import static net.hobbyscience.housedb.housedb.tables.TimeseriesValues.*;
import net.hobbyscience.housedb.housedb.udt.records.DataTripleRecord;
import net.hobbyscience.housedb.housedb_security.Routines;
import net.hobbyscience.housedb.housedb_timeseries.tables.RetrieveTimeseriesData;

import static org.jooq.impl.DSL.*;

import org.jooq.*;
import org.jooq.exception.*;
import org.jooq.impl.DSL;

public class HouseDb {
    private static final Logger logger = Logger.getLogger(HouseDb.class.getName());    
    private String username = null;
    private DSLContext dsl = null;

    public HouseDb(){

    }

    public HouseDb(Connection conn, String username ){
        dsl = DSL.using(conn,SQLDialect.POSTGRES);
        try {
            Routines.setSessionUser(dsl.configuration(),username);
        } catch( DataAccessException err ){  
            logger.info(err.sqlState());
            if( !err.sqlState().equalsIgnoreCase("PX000") ){
                throw err;
            } // else continue as guest
        }
        
        this.username = username;
    }    

    public HouseDb setUsername(String username){
        this.username = username;
        return this;
    }

    public List<String> getAllLocations() throws Exception{
        ArrayList<String> locations = new ArrayList<>();

        Result<Record> result = dsl.selectDistinct().from(ViewLocations.VIEW_LOCATIONS).fetch();
        for( Record r: result ){            
            String loc = r.getValue(Locations.LOCATIONS.NAME);            
            Routines.canPerform(dsl.configuration(),username,"READ","locations",loc);
            locations.add(loc);                
        }
        return locations;        
    }

    public void saveLocation(Location loc) throws Exception {
        logger.info(username);
        logger.info(Routines.getSessionUser(dsl.configuration()));
        net.hobbyscience.housedb.housedb_locations.Routines.createLocation(dsl.configuration(),loc.getName(),true);
    }

    public void saveTimeSeries(TimeSeries ts) throws Exception {    
        //DataTripleRecord []dtrs = ts.getData().stream().map( dt -> dt.asDataTripleRecord() ).collect( Collectors.toList() ).toArray(new DataTripleRecord[0]);
        
        dsl.transaction( config -> {
            var insert = DSL.using(config).insertInto(TIMESERIES_VALUES, TIMESERIES_VALUES.NAME, TIMESERIES_VALUES.DATE_TIME, TIMESERIES_VALUES.VALUE, TIMESERIES_VALUES.QUALITY);
            ts.getData().stream().forEach( dt -> {
                insert.values( ts.getName(), dt.dateTime, dt.value, dt.quality);
            });  
            insert.execute(); // TODO: consider returning to user;
        });        
        
        //net.hobbyscience.housedb.housedb_timeseries.Routines.storeTimeseriesData(dsl.configuration(),ts.getName(),dtrs,Boolean.TRUE);
    }

    public TimeSeries getTimeSeries(TimeSeries ts, OffsetDateTime start, OffsetDateTime end, String timeZone, boolean excludeMissing) throws Exception {
        List<DataTriple> dts = new ArrayList<DataTriple>();    

        Result<Record3<OffsetDateTime, Double, Integer>> results = 
            dsl.select(                
                field("date_time",OffsetDateTime.class),
                field("value",Double.class),
                field("quality",Integer.class)
            ).from(TIMESERIES_VALUES)
             .where(TIMESERIES_VALUES.NAME.equalIgnoreCase(ts.getName()))
             .and(TIMESERIES_VALUES.DATE_TIME.between(start,end)).fetch();

        dts = results.stream().map( dtr -> {
            logger.info(dtr.toString());
            DataTriple dt = new DataTriple();
            dt.dateTime = dtr.value1();
            dt.value = dtr.value2();
            dt.quality = dtr.value3();
            return dt;
        } ).collect( Collectors.toList());
        ts.setData(dts);
        return ts;
         
    }

}