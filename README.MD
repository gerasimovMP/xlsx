# XLSX API

Приложение для извлечения чисел из XLSX файла и нахождения N-го минимального числа.

## Требования

- Java 17+
- Gradle

## Установка

1. Клонируйте репозиторий:

    git clone https://github.com/gerasimovMP/xlsx.git

2. Соберите и запустите проект:

    ./gradlew bootRun

## Использование

- Эндпоинт: `GET /findMin?filePath=<путь_к_файлу>&n=<N>`
- swagger http://localhost:8080/swagger-ui/index.html#/xlsx-controller/findMin