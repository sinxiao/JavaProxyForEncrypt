package com.xuhj.laosiji.laosiji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xuhj.laosiji.laosiji.bean.User;
import com.xuhj.laosiji.laosiji.dagger2.DaggerMainComponent;
import com.xuhj.laosiji.laosiji.dagger2.MainModule;
import com.xuhj.laosiji.laosiji.present.ICommentView;
import com.xuhj.laosiji.laosiji.present.MainPresent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainPresent.IMainView,ICommentView {

    @Inject
    MainPresent mainPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Example of a call to a native method
    TextView tv = (TextView) findViewById(R.id.sample_text);
    tv.setText(stringFromJNI());
    }
    private void inject(){
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public void showWait(String info) {

    }

    @Override
    public void showMsg(String info) {

    }

    @Override
    public void showError(String info) {

    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showuser(User user) {

    }

    @Override
    public void showusers(List<User> users) {

    }

    @Override
    public void delUserSucess(String uid) {

    }
}
