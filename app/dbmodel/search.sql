create view talat_journey_departure as
select 	
	rno,
	jno,
	spot_order,
	lat,
	lng,
	spot_name,
	spot_time
from talat_journey_route
where spot_order=1;

create view talat_journey_arrival as
select 	
	rno,
	jno,
	spot_order,
	lat,
	lng,
	spot_name,
	spot_time
from talat_journey_route
where spot_order > 1;


select d.jno
    from talat_journey_departure d
   where d.spot_name='a';

select a.jno
	from talat_journey_arrival a
	where a.spot_name='b';


select 
      j.jno,
      j.dept,
      j.arr,
      j.jdate,
      j.jtime,
      m.mno as driver_no,
      m.mname as driver_name
    from talat_journey j 
	inner join talat_memb m on j.mno=m.mno
	inner join talat_journey_departure d on d.jno = j.jno
	inner join talat_journey_arrival a on a.jno = j.jno
    where d.spot_name like 'd'
        and a.spot_name like 'c'
    group by j.jno desc
;

select 
	t1.jno t1_jno,
	t2.jno t2_jno,
	t1.rno t1_rno,
	t1.spot_name t1_spot_name,
	t2.rno t2_rno,
	t2.spot_name t2_spot_name
from 
(
select 	
	rno,
	jno,
	spot_order,
	lat,
	lng,
	spot_name,
	spot_time
from talat_journey_route
where spot_order=1
) as t1
,
(
select 	
	rno,
	jno,
	spot_order,
	lat,
	lng,
	spot_name,
	spot_time
from talat_journey_route
where spot_order > 1
) as t2

where t1.jno = t2.jno 
  and t1.spot_name like ('%a%')
  and t2.spot_name like ('%d%')