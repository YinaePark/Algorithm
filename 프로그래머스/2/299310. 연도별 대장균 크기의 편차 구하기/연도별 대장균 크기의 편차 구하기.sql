SELECT
    YEAR(e1.DIFFERENTIATION_DATE) AS YEAR,
    e2.MAX_SIZE - e1.SIZE_OF_COLONY AS YEAR_DEV,
    e1.ID
FROM
    ECOLI_DATA AS e1
JOIN (
    SELECT
        YEAR(DIFFERENTIATION_DATE) AS YR,
        MAX(SIZE_OF_COLONY)        AS MAX_SIZE
    FROM
        ECOLI_DATA
    GROUP BY
        YEAR(DIFFERENTIATION_DATE)
) AS e2
    ON YEAR(e1.DIFFERENTIATION_DATE) = e2.YR
ORDER BY
    YEAR    ASC,
    YEAR_DEV ASC;
