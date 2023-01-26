-- function 1
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