# 📱 Mobile Automation Framework (Appium + Java)

## 📌 Overview

Данный проект представляет собой фреймворк для автоматизации мобильного тестирования Android-приложения с использованием:

- **Java 17**
- **Appium (java-client 9.x)**
- **TestNG**
- **Allure Report**

Фреймворк реализует масштабируемую архитектуру с разделением ответственности (Page Object, конфигурации, драйвер, тесты) и ориентирован на поддержку CI/CD и расширение тестового покрытия.

---

## 🧱 Архитектура проекта

```
src
├── main
│   ├── java
│   │   ├── configs
│   │   ├── constants
│   │   ├── core
│   │   └── pages
│   └── resources
│       ├── *.properties
│       └── app-debug.apk
│
├── test
│   ├── java
│   │   ├── tests
│   │   └── retry
│   └── resources
│       ├── testNg.xml
│       └── allure.properties
```

---

## ⚙️ Основные компоненты

### 🔹 Driver Layer
- `InitialDriver` — управление Appium драйвером

### 🔹 Config Layer
- `ConfigReader`
- `DeviceCapabilities`, `LoginCapabilities`

### 🔹 Page Object Layer
- `BasePage`
- `StartPage`, `SuccessPage`

### 🔹 Test Layer
- `BaseTest`
- `LoginTest`, `MaskTest`, `UIStartPageTest`

### 🔹 Retry Mechanism
- `RetryAnalyzer`
- `RetryTransformer`

### 🔹 Reporting
- Allure Report

---

## 🚀 Быстрый старт

### Требования

- Java 17+
- Maven
- Appium Server
- Android SDK

### Установка

```
git clone <repo>
cd newApp
```

### Запуск Appium

```
appium
```

### Запуск тестов

```
mvn clean test
```

### Allure отчет

```
allure serve target/allure-results
```

---

## 🔧 Конфигурация

Пример:

```
appium:appPackage = com.alfabank.qapp
appium:platformName = ANDROID
appium:appActivity = com.alfabank.qapp.presentation.MainActivity
appium:automationName = uiautomator2
appium:deviceName = emulator-5554
```
---
