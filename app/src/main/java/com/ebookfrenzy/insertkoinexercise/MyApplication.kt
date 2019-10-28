package com.ebookfrenzy.insertkoinexercise

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class MyApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()
            androidContext(this@MyApplication)

            modules(재료창고)
            modules(술창고)
          //  modules(바)
        }
    }
}

    class Fruit

    class Cider

    class Coke

    class 칵테일(
        val fruit: Fruit,
        val cider: Cider,
        val coke: Coke,
        val year : Int
    ) : IAlcohol

    class Bar(
        val cak: 칵테일
    ) : IBar{
        override fun getAllAlcohol(): List<IAlcohol> {
            return listOf(cak)
        }
    }

    val 재료창고 = module {
        factory { Fruit() }
        factory { Cider() } bind Cider::class
        factory { Coke() }
    }

    // year는 정해진게 아니라서 get으로 가져올 수 없다.
    val 술창고 = module {
        factory { (year: Int) -> 칵테일(get(), get(), get(), year) }
    }

/*
    val 바 = module {
        single { Bar(get()) } bind IBar::class
    }
*/
    interface IAlcohol

    interface IBar {
        fun getAllAlcohol() : List<IAlcohol>
    }

