CREATE OR REPLACE FUNCTION housedb_tests.test_create_location()
RETURNS SETOF TEXT AS $$
DECLARE
    simple_location text = 'Simple1';
    simple_location_diffcase text = 'SiMPLe1';
    complex_location text = 'This-Is-Complex'; 
    sub_location text = 'Simple1-Sub';   
    query_res record;
    sub_id bigint;
BEGIN
    RETURN NEXT ok(housedb.create_location(simple_location) > 0 );
    RETURN NEXT ok(housedb.create_location(complex_location) > 0 );

    RAISE NOTICE 'showing locations that exist';    
    for query_res in execute 'select * from housedb.locations'
    loop
        raise notice 'row: %', query_res;
    end loop;

    RETURN NEXT isnt_empty( 'select * from housedb.locations where parent_id is not null' );

    sub_id = housedb.create_location(sub_location);
    RETURN NEXT ok(sub_id > 0 );
    RETURN NEXT ok(housedb.expand_location_name(sub_id) = sub_location);


    RETURN NEXT throws_ok('select housedb.create_location(''SiMPle1'')', 23505 );

END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION housedb_tests.test_expand_location()
RETURNS SETOF TEXT AS $$
DECLARE
    simple_location text = 'Simple';
    
    complex_location text = 'This-Is-Complex';
    result text;
    a_parent_id bigint;
    sub_id bigint;
    the_simple_id bigint;
    the_complex_id bigint;
BEGIN
    insert into housedb.locations(name) values ('Simple') returning id into the_simple_id;
    insert into housedb.locations(name) values ('This') returning id into a_parent_id;
    insert into housedb.locations(name,parent_id) values ('Is',a_parent_id) returning id into a_parent_id;
    insert into housedb.locations(name,parent_id) values ('Complex',a_parent_id) returning id into the_complex_id;
    RAISE NOTICE 'Simple -> %', housedb.expand_location_name(the_simple_id);
    RAISE NOTICE 'Complex -> ';
    RAISE NOTICE '%', housedb.expand_location_name(the_complex_id);
    RETURN NEXT is( housedb.expand_location_name(the_simple_id), simple_location );
    RETURN NEXT is( housedb.expand_location_name(the_complex_id), complex_location );
END;
$$ LANGUAGE plpgsql;




