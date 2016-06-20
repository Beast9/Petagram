package beast9.com.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Ian-Industries on 18/03/2016.
 */
public class Acerca_De extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);
    }

    public void onClickOk(View v)
    {
        switch(v.getId())
        {
            case R.id.buttonOk:
                this.finish();
                break;

        }
    }
}
