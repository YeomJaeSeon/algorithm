# subquery

```sql
SELECT name FROM world
  WHERE population >
     (SELECT population FROM world
      WHERE name='Russia')
```

- where절의 서브쿼리 결과는 단일 레코드이다.
- 하드코드한 name필드의 값이 'Russia'인 population필드값을 넣어도 동일하다.

```sql
select name from world
where continent = 'Europe' AND
gdp / population > (SELECT gdp / population from world where name = 'United Kingdom');
```

- where절의 서브쿼리는 단일레코드임

```sql
select name from world where gdp > ALL (select gdp from world where gdp is not null AND continent = 'Europe');
```

- 서브쿼리의 결과가 단일레코드가 아닐시 사용할수있는연산 ALL, ANY
- ALL은 AND와같다. - 여러 레코드들고의 비교가 모두 true여야함
- ANY는 OR과같다. - 여러레코드들의 비교가 하나만 true여도 true임
- MAX(gdp)로 집계함수 사용해도됨

```sql
select continent, name, area from world x
where area >= (select MAX(area) from world y where y.continent = x.continent and area is not null);
```

- 서브쿼리의 where절에는 같은 대륙의 이름끼리 비교를 해야하기에 메인쿼리의 테이블과 서브쿼리의 테이블을 모두 사용한다. 이를 연관 서브쿼리(상관 서브쿼리)라 한다.
