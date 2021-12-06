# AIS-klient
Planowana funkcjonalność:
- wyszukiwanie statkow po wyznaczonym obszarza
- szczegółowe informacje o poszczegolnych statkach
- sprawdzanie aktualnej pogody w porcie docelowym danego statku
- system rejestracji i logowania rozszerzajacy mozliwosci uzytkownika o wyszukiwanie statku po podanej frazie oraz dodawanie statkow do ulubionych.

W aplikacji zostaly wykorzystane API pogodowe, API AIS system oraz API mapujące nazwe miejsca na koordynaty





Po wybraniu statku można zobaczyc więcej szczegołów w lewym panelu. Mozna sprawdzic aktualną pogodę w miejscu docelowym klikajac w przycisk
![image](https://raw.githubusercontent.com/MarcinPacana/AIS-klient/master/src/main/resources/screenshots/sk2.JPG)

Wyświetlana jest szczegołowa pogoda
![image](https://raw.githubusercontent.com/MarcinPacana/AIS-klient/master/src/main/resources/screenshots/sk3.JPG)

Panel użytkownika w którym można zobaczyć dane użytkownika oraz zapisane statki do ulibionych
![image](https://raw.githubusercontent.com/MarcinPacana/AIS-klient/master/src/main/resources/screenshots/sk4.JPG)

Wyniki wyszukiwania statków po zadanej frazie
![image](https://raw.githubusercontent.com/MarcinPacana/AIS-klient/master/src/main/resources/screenshots/sk5.JPG)


UWAGA
API https://www.barentswatch.no/ posiada błąd na jedym ze swoich endpointów.
Szerogość(latitude) i długość(longitude) są zamienione miejscami.
![image](https://raw.githubusercontent.com/MarcinPacana/AIS-klient/master/src/main/resources/screenshots/api-error.JPG)


