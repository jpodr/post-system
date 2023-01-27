-- function 1
-- count package travel time
CREATE OR REPLACE FUNCTION package_travel_time_in_days(p_package_id NUMBER)
    RETURN NUMBER
AS
    v_package_sent_date SP_PACKS_HISTORY.STATUS_DATETIME%TYPE;
    v_package_received_date SP_PACKS_HISTORY.STATUS_DATETIME%TYPE;
BEGIN
    select STATUS_DATETIME
    into v_package_sent_date
    from SP_PACKS_HISTORY h
    where h.PACKAGE_ID = p_package_id and h.DESCRIPTION like '%Waiting for courier%';

    select STATUS_DATETIME
    into v_package_received_date
    from SP_PACKS_HISTORY h
    where h.PACKAGE_ID = p_package_id and h.DESCRIPTION like '%delivered to receiver%';

    return v_package_received_date - v_package_sent_date;
end;

select package_travel_time_in_days(8) from dual;

-- function 2
-- count average package travel time in days
CREATE OR REPLACE FUNCTION avg_package_travel_time_in_days
    RETURN NUMBER
AS
    v_sum_days NUMBER := 0;
    v_number_of_packages NUMBER := 0;
    v_days NUMBER := 0;
    v_pack_id NUMBER := 0;
    cursor cr_packs_ids is
        select PACKAGE_ID from SP_PACKS_HISTORY e1;
BEGIN
    open cr_packs_ids;
    loop
        exit when cr_packs_ids%NOTFOUND;
        fetch cr_packs_ids into v_pack_id;

        select package_travel_time_in_days(v_pack_id)
        into v_days
        from dual;

        v_sum_days := v_sum_days + v_days;
        v_number_of_packages := v_number_of_packages + 1;
    end loop;

    close cr_packs_ids;
    return v_sum_days / v_number_of_packages;
end;

select avg_package_travel_time_in_days() from dual;

-- procedure 1
-- set new courier id to package
CREATE OR REPLACE PROCEDURE change_package_courier(pack_id IN NUMBER, new_courier_id IN NUMBER)
AS
BEGIN
    UPDATE PACKAGES
    SET COURIER_ID = new_courier_id
    where PACKAGE_ID = pack_id;
end;

begin
    change_package_courier(1, 43);
    commit;
end;

-- procedure 2
-- set new position to employee


-- trigger 1
-- check if the new courier's id on package is valid
CREATE OR REPLACE TRIGGER tg_set_courier
    BEFORE UPDATE ON PACKAGES FOR EACH ROW
DECLARE
    v_position POSITIONS%rowtype := null;
BEGIN
    select p.*
    into v_position
    from EMPLOYEES e join POSITIONS p on e.POSITION_ID = p.POSITION_ID
    where EMPLOYEE_ID = :new.courier_id;

    IF not (v_position.NAME like 'Courier') THEN
        :new.courier_id := null;
        raise_application_error(-20002, 'Wrong courier id');
    END IF;
END;

begin
    change_package_courier(1, 43);
    commit;
end;

-- trigger 2
-- check if the login is already not taken
CREATE OR REPLACE TRIGGER tg_add_login_data
    BEFORE INSERT ON LOGIN_DATA FOR EACH ROW
BEGIN
    FOR l IN (SELECT * FROM LOGIN_DATA)
        LOOP
            IF (l.LOGIN = :new.login) THEN
                dbms_output.put_line('The login is already present');
                raise_application_error(-20001, 'The login is already present');
            END IF;
        END LOOP;
END;

begin
    insert into LOGIN_DATA (ACCOUNT_TYPE, LOGIN, PASSWORD) values (0, 'cour', 324234324);
end;
