-- 3세대 출력
-- 3세대의 조건은 3세대.부모 = 2세대.id
SELECT e3.ID 
FROM ECOLI_DATA AS e3
-- 2세대의 ID 출력,
-- 2세대의 조건은 2세대.부모 = 1세대.id
JOIN (
    SELECT e2.ID 
    FROM ECOLI_DATA AS e2
    
    -- 1세대가 right
    JOIN(
        SELECT ID 
        FROM ECOLI_DATA 
        WHERE PARENT_ID IS NULL
    ) AS e1
    ON e2.PARENT_ID = e1.ID

) AS e2
    ON e3.PARENT_ID = e2.ID
ORDER BY e3.ID;