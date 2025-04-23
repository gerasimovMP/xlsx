# XLSX API

Приложение для извлечения чисел из XLSX файла и нахождения N-го минимального числа.

## Требования

- Java 17+
- Gradle

## Установка

1. Клонируйте репозиторий:

    git clone https://github.com/your-repository/xlsx-api.git
    cd xlsx-api

2. Соберите и запустите проект:

    ```bash
    ./gradlew bootRun
    ```

## Использование

- Эндпоинт: `GET /findMin?filePath=<путь_к_файлу>&n=<N>`