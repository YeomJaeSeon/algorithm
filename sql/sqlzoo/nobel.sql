SELECT * FROM nobel
 WHERE winner IN ('Theodore Roosevelt',
                  'Woodrow Wilson',
                  'Jimmy Carter',
                  'Barack Obama');

-- - field IN (~, ~, ~) : 괄호 안의 필드 값중에 포함되면 1, 아니면 0
-- - 괄호내의 필드값중에 포함되는 레코드만 출력
-- - field IN (A, B, C) : A, B, C중에 포함되는 필드값-> 포함되면 1, 아니면 0


select * from nobel where (subject = 'Literature') AND (yr between 1980 AND 1989);

-- - yr필드값이 1980 이상 1989 이하, 경계값 포함
-- - BETWEEN A AND B : A와 B 사이(경계값 포함)

SELECT * FROM nobel
 WHERE CASE WHEN winner IN ('Theodore Roosevelt',
                  'Woodrow Wilson',
                  'Jimmy Carter',
                  'Barack Obama') THEN 1 ELSE 0 END;

-- - CASE WHEN THEN 절로 field IN (SET) 확인가능

SELECT winner from nobel where LEFT(winner, 4) = 'John';
- LEFT(문자열, 개수) -> 왼쪽부터 개수만큼의 문자열 추출
- RIGHT(문자열, 개수) -> 오른쪽부터 개수만큼의 문자열 추출

select * from nobel where winner = 'EUGENE O\'NEILL';

- \'' -> escape sequence : 특수문자 추출


SELECT winner, subject
  FROM nobel
 WHERE yr=1984
 ORDER BY 
CASE WHEN subject IN ('Chemistry', 'Physics') THEN 1 ELSE 0 END, 
subject ASC, 
winner ASC;

-- - field IN SET -> 있으면 1, 없으면 0을통해서  subject 필드값이 'Chemistry'이거나 'Physics'인 녀석들을 마지막에 배치. 오름차순으로 정렬하기에
-- 0 -> 1순으로 정렬, 1이 맨마직막에 출력.