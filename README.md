# Student-Report

Database Using Postgres.

STEP TO RUN

1. Download and Import and Run.


2. Create database name student and run the query as oder given below.
    
    
create table student(


	id SERIAL PRIMARY KEY,
	
  name varchar(50),
	
  roll_no int,
	
  college varchar(50),
	
  physics decimal,
	
  chemistry decimal,
	
  biology decimal,
	
  maths decimal,
	
  english decimal,
	
  computers decimal,
  
  rank int,
  
  ranking varchar(50)
)


Below this run after running the project



UPDATE public.student


SET percentage=round((((physics + chemistry + biology + maths + english + computers)  / 600) * 100) , 2) , 



tot_marks=(physics + chemistry + biology + maths + english + computers) 





with CTE1 as (


select *, 



CASE


WHEN percentage > 80 THEN 'gold'



WHEN percentage between 60 and 80 THEN 'silver'


WHEN percentage between 35 and 60 THEN 'bronze'


ELSE NULL


END AS ranking2


from student)	,


CTE2 as (


SELECT cte1.*, 


rank() OVER (PARTITION BY ranking2 ORDER BY cte1.percentage DESC) 


FROM cte1 


---  order by cte1.ranking, rank


)


UPDATE public.student t1


SET  ranking= cte2.ranking2


, ranks=cte2.rank


from cte2


where t1.id=cte2.id


3. Get report by Name: localhost:9000/students/reports/byName/Raj Kumar



4. Get report by RollNo: localhost:9000/students/reports/byRollNo/10



5. Get Rank: localhost:9000/students/reports/ranks
