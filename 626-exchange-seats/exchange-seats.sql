# Write your MySQL query statement below
select
CASE
    WHEN id % 2 = 1 AND id != (Select MAX(id) from Seat) THEN id + 1
    WHEN id % 2 = 0 THEN id - 1
    ELSE id
END as id,student
From Seat

Order by id asc;