package groep2.project4;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;

/**
 * Created by Dennis on 21-6-2016.
 */
public class MenuColorManager {

    int color = Color.LTGRAY;

    public MenuColorManager(){

    }

    public void FixShitAhMattieZegWollah(MenuItem ITEM1, MenuItem ITEM2, MenuItem ITEM3){
        SpannableString s1 = new SpannableString(ITEM1.getTitle());
        SpannableString s2 = new SpannableString(ITEM2.getTitle());
        SpannableString s3 = new SpannableString(ITEM3.getTitle());
        s1.setSpan(new ForegroundColorSpan(color),0,s1.length(),0);
        s2.setSpan(new ForegroundColorSpan(color),0,s2.length(),0);
        s3.setSpan(new ForegroundColorSpan(color),0,s3.length(),0);
        ITEM1.setTitle(s1);
        ITEM2.setTitle(s2);
        ITEM3.setTitle(s3);
    }
}
