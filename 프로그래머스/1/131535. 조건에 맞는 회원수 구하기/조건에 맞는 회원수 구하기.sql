SELECT COUNT(USER_ID) FROM USER_INFO
WHERE DATE_FORMAT(JOINED, "%Y") = '2021' AND
AGE >= 20 AND AGE <= 29;