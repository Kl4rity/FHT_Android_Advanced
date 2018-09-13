package at.technikumwien.maps.ui.maps;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.List;

import at.technikumwien.maps.data.OnDataLoadedCallback;
import at.technikumwien.maps.data.model.DrinkingFountain;
import at.technikumwien.maps.data.remote.DrinkingFountainRepo;

public class MapsPresenter extends MvpBasePresenter<MapsView> {

    private final DrinkingFountainRepo drinkingFountainRepo;

    public MapsPresenter(DrinkingFountainRepo drinkingFountainRepo) {
        this.drinkingFountainRepo = drinkingFountainRepo;
    }

    public void loadData(){

        OnDataLoadedCallback<List<DrinkingFountain>> callback = new OnDataLoadedCallback<List<DrinkingFountain>>(){

            @Override
            public void onDataLoaded(List<DrinkingFountain> data) {
                if(isViewAttached()){
                    getView().onDataLoaded(data);
                }
            }

            @Override
            public void onDataLoadError(Exception exception) {
                if(isViewAttached()){
                    getView().onDataLoadError(exception);
                }
            }
        };

        drinkingFountainRepo.loadDrinkingFountains(callback);

    }


}
