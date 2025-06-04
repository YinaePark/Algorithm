-- 코드를 작성해주세요
-- where에서 s 테이블에서 C#, python 스킬코드의 코드만 추출
-- join에서 스킬코드가 해당 코드를 포함하고 있는지 비트연산

SELECT DISTINCT D.ID,	D.EMAIL,	D.FIRST_NAME,	D.LAST_NAME
FROM DEVELOPERS AS D
JOIN SKILLCODES AS S
ON (D.SKILL_CODE & S.CODE) <> 0
WHERE S.NAME IN ('C#' , 'Python')
ORDER BY D.ID ASC;
