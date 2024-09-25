
ТЕХСТЕК
-----------
Spring Framework
https://spring.io/
Spring Data JPA
https://spring.io/projects/spring-data-jpa
MySQL 8
https://www.mysql.com/
Hibernate 6
https://hibernate.org/

--------------------------------------------------------

1) Складаємо SQL-запити INFO/SQLs.sql

2) Створюємо Maven-проект.

3) Підтягуємо залежності (pom.xml).

4) В корені проекту створемо папку Catalina,
де можуть бути сгенеровані відповідні файли.
Catalina – контейнер сервлетів Apache Tomcat.
Catalina реалізує специфікації для сервлета та JSP.

5) Формуємо файл-properties
src/main/resources/app.properties

6) Формуємо контент в org/example/app

7) Для роботи з сервером у IntelliJ IDEA Community Edition
необхідний плагін.
File > Settings > Plugins > Marketplace.
Знаходимо плагін Smart Tomcat, встановлюємо.

* Якщо IntelliJ IDEA Ultimate, то без плагіну
https://www.jetbrains.com/help/idea/developing-web-applications.html

8) Конфігуруємо Smart Tomcat.

Run > Edit Configurations... > + > Smart Tomcat

Вкладка Configuration.
В Name пишемо, наприклад, my-app

Клікаємо Configure. Стаємо на Tomcat Server. Клікаємо + .
Вибираємо папку необхідного Apache Tomcat.
Переважно, тут вибрати сервер, який встановлений
із zip-файлу (не вимагає зайвої аутентифікації
при запуску).

Клікаємо OK.

Catalina base.
Вказуємо шлях до нашої папки Catalina.

Deployment directory.
Вибираємо папку webapp свого проекту.

Use classpath of module має містити найменування
кореневої папки проекту.

Context path.
Можна прописати /my-app або просто /

Server port повинен містити порт Apache Tomcat, який
в налаштуваннях серверу.
Див. в сервері /conf/server.xml
<Connector port="8080"...

Клікаємо Apply та OK.

9) Запустимо Tomcat.
В IDE, зверху, клікаємо зелену кнопку запуску.
В консолі мають з'явитись повідомлення про функціонування
сервера.
Зупинити сервер можна, натиснувши червоний квадратик вгорі,
який має з'явитися після запуску сервера.

10) Зформуємо jar-файл (опціонально).
Клікаємо праворуч Maven. Відкривається панель Maven.
У Lyfecycle клікаємо послідовно clean, install.
У панель_проекта/target має з'явитися jar-файл.
Цей jar-файл копіюємо в папку webapps сервера
локальної машини.

11) Запускаємо Tomcat. Запускаємо Workbench.

12) Тестуємо REST API.
