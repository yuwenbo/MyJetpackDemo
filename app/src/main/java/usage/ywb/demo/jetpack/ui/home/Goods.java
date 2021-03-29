package usage.ywb.demo.jetpack.ui.home;

import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

/**
 * @author yuwenbo
 * @version [ V.3.0.0  2021/3/24 ]
 */
public class Goods {

    public String name;

    public ObservableField<String> desc;

    public MutableLiveData<Double> price;


}
