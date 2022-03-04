package ru.geekbrains.spring.winter.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketApplication {

	// Домашнее задание:
	// Реализовать оформление заказа:
	// 1. На фронте добавить в отделе корзины кнопку оформить заказ
	// 1. а. * С фронта передать адрес и телефон покупателя
	// 2. Заказ может оформлять только вошедший пользователь (установите защиту)
	// 3. В ОрдерСервисе получаете текущую корзину и преобразуете ее к заказу
	// 4. Сохраняете заказ с позициями заказа!! в БД
	// 5. ** На фронте можете показать список заказов юзера

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketApplication.class, args);
	}
}
