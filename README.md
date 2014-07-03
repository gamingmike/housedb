House TSDB
===========

Description
-----------

This is a database create to store time series database for a smart home project.


How to Use
===========

There are a few support function and some views, these should be used to interact with the database.
A time series is identified with the following format:

	Zone.Specifc Station/Sensor.Measurement Name.Type.Interval.Duration.Version

For example:

	Front Yard.Rose Rushes nr Road.Soil Moisture.Inst.15Minutes.0.raw

Is the identifier for a time series the contains soil moisture for the roses in my front yard near the road. The data is Instantaneous sampled at 15 minute intervals and has no duration ( the value applies to a point in time. ) The version is arbitrary.

The duration would be used for average data. For example if we were to take the above data and average it for an hour (an average of 4 fifteen minute values) it would look like this:

	Front Yard.Rose Rushes nr Road.Soil Moisture.Ave.1Hour.1Hour.raw

Valid types are:
	
 - Inst
 - Ave
 - Min
 - Max
 - Total
