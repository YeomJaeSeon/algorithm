SELECT name FROM world WHERE name LIKE '%United%';

-- - like 사용

SELECT name, ROUND(population / 1000000, 2), ROUND(gdp/ 1000000000, 2)  from world where continent = 'South America';
-- - ROUND()함수 이용 : 반올림

select name, round(gdp/ population, -3) FROM world where gdp >= 1000000000000;
-- - ROUND()두번째 인자 음수로 -> 10의자리수 반올림

select name, capital from world where LENGTH(name) = LENGTH(capital);
-- - LENGTH(문자열) -> 문자열길이

SELECT name, capital
FROM world
WHERE LEFT(name, 1) = LEFT(capital, 1) AND name <> capital;

-- - <> = !=, LEFT(문자열, 개수) -> 문자열 왼쪽에서 개수 번째의 문자..

select name from world where (name like '%a%' AND name like '%e%' AND name like '%i%' AND name like '%o%' AND name like '%u%') AND (name NOT like '% %');

-- - NOT LIKE : 문자열 내에 포함하지 않는것