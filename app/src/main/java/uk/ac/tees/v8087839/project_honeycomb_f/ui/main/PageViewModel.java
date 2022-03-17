package uk.ac.tees.v8087839.project_honeycomb_f.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if(input == 1)
            {
                return "THIS IS THE FEED PAGE";
            }
            else if(input == 2)
            {
                return "THIS IS THE TIMETABLE PAGE";
            }
            else if(input == 3)
            {
                return "THIS IS THE EVENTS PAGE";
            }
            else if(input == 4)
            {
                return "THIS IS THE FRIENDS PAGE";
            }
            else if(input == 5)
            {
                return "THIS IS THE CHAT PAGE";
            }
            else
            {
                return "Oops this isn't supposed to happen here is the input: " + input;
            }
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}