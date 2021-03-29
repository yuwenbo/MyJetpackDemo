package usage.ywb.demo.jetpack;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import usage.ywb.demo.jetpack.databinding.ActivityFirstBinding;
import usage.ywb.demo.jetpack.ui.home.Goods;
import usage.ywb.demo.jetpack.ui.home.MyLifecycleObserver;

/**
 * @author yuwenbo
 * @version [ V.3.0.0  2021/3/18 ]
 */
public class FirstActivity extends FragmentActivity {

    private Goods goods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        getLifecycle().addObserver(new MyLifecycleObserver());

        goods = new Goods();
        goods.name = "特斯拉";
        goods.desc = new ObservableField<>("电力十足，风一般的感觉");
        goods.price = new MutableLiveData<>(200000d);
        binding.setVariable(BR.goods, goods);
        binding.setVariable(BR.first, this);
    }

    public void onClick(View view) {
        goods.desc.set("fei一般的感觉");
        Toast.makeText(this, goods.name + " - " + goods.desc.get() + "。只要：" + goods.price.getValue().toString(), Toast.LENGTH_SHORT).show();
    }

}
