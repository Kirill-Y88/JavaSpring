package ru.geekbrains.spring.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //пометка о том, что класс используетсяя для настройки зависимостей, бинов и тд
@ComponentScan("ru.geekbrains.spring.demo") // обозначение пакета для сканирования и поиска бинов
public class AppConfig {
}
