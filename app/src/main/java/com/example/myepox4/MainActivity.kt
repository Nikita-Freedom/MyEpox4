package com.example.myepox4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setUpRecyclerView()
	}

	private fun setUpRecyclerView(){
		val rv = findViewById<EpoxyRecyclerView>(R.id.rv)
		rv.withModels {
			title {
				id("1")
				title("Discover people")
			}
			val carouselItemModels = CarouselList.map { carouselItem ->
				CarouselBindingModel_()
					.id(carouselItem.id)
					.carouselItem(carouselItem)
					.clickListener{v ->

					}
			}

			carousel {
				id("car")
				models(carouselItemModels)
			}

			title {
				id("2")
				title("Manage people")
			}

			ManageList.forEach { currentmanage ->
				manage {
					id(currentmanage.id)
					manage(currentmanage)
						.clickListener{v->

						}
				}
			}
		}
	}

	val ManageList = listOf(
		ManageItem("1", "Nikita Ulyanov", 19),
		ManageItem("2", "Vladislav Kortikov", 21),
		ManageItem("3", "Ilya Nekrasov", 26),
		ManageItem("3", "Vasya Noname", 22),
		ManageItem("3", "Olya Someone", 24),
		ManageItem("3", "Nastya Who", 29),
	)

	val CarouselList = listOf(
		CarouselItem("1", "Nke", "Android dev"),
		CarouselItem("2", "Vlad", "Android Mentor"),
		CarouselItem("4", "Misha", "Android Teamlead"),
		CarouselItem("5", "Vasya", "No name"),
		CarouselItem("6", "Olya", "Someone"),
		CarouselItem("7", "Nastya", "Who"),
		CarouselItem("8", "Julya", "HR"),
		CarouselItem("9", "Anna", "HR"),
		CarouselItem("10", "Aleks", "HR"),
	)

	data class CarouselItem (
		val id: String,
		val title: String,
		val description: String
	)

	data class ManageItem(
		val id: String,
		val description: String,
		val age: Int
	)
}