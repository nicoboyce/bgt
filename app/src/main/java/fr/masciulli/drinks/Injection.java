package fr.masciulli.drinks;

import fr.masciulli.drinks.net.Client;
import fr.masciulli.drinks.net.drinks.DrinksRepository;
import fr.masciulli.drinks.net.drinks.LocalDrinksDataSource;
import fr.masciulli.drinks.net.liquors.LiquorsRepository;
import fr.masciulli.drinks.net.liquors.LocalLiquorsDataSource;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class Injection {
    private Injection() {
        // cannot be instantiated
    }

    public static DrinksRepository provideDrinksRepository() {
        return DrinksRepository.getInstance(Client.getInstance(), LocalDrinksDataSource.getInstance());
    }

    public static LiquorsRepository provideLiquorsRepository() {
        return LiquorsRepository.getInstance(Client.getInstance(), LocalLiquorsDataSource.getInstance());
    }

    public static Scheduler provideSubscribeScheduler() {
        return Schedulers.newThread();
    }

    public static Scheduler provideObserveScheduler() {
        return AndroidSchedulers.mainThread();
    }
}