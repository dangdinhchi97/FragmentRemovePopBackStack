package g.acedemy.fragmentremovepopbackstack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager=getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void AddA(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framcontent,new FragmentA(),"frma");
        //
        fragmentTransaction.addToBackStack("aaa");
        //
        fragmentTransaction.commit();
    }
    public void AddB(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framcontent,new FragmentB(),"frmb");
        //
        fragmentTransaction.addToBackStack("bbb");
        //
        fragmentTransaction.commit();
    }
    public void AddC(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framcontent,new FragmentC(),"frmc");
        //
        fragmentTransaction.addToBackStack("ccc");
        //
        fragmentTransaction.commit();
    }
    public void RemoveA(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FragmentA fragmenta= (FragmentA) getFragmentManager().findFragmentByTag("frma");
        if (fragmenta!=null) {
            fragmentTransaction.remove(fragmenta);
            fragmentTransaction.commit();
        }
        else Toast.makeText(this, "kho con de xoa", Toast.LENGTH_SHORT).show();
    }
    public void RemoveB(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FragmentB fragmentb= (FragmentB) getFragmentManager().findFragmentByTag("frmb");
        if (fragmentb!=null) {
            fragmentTransaction.remove(fragmentb);
            fragmentTransaction.commit();
        }
        Toast.makeText(this, "ko con de xoa", Toast.LENGTH_SHORT).show();
    }
    public void RemoveC(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FragmentC fragmentc= (FragmentC) getFragmentManager().findFragmentByTag("frmc");
        if (fragmentc!=null) {
            fragmentTransaction.remove(fragmentc);
            fragmentTransaction.commit();
        }
        Toast.makeText(this, "ko con de xoa", Toast.LENGTH_SHORT).show();
    }
    public void Back(View view){
        getFragmentManager().popBackStack();
    }
    public void PopA (View view){
        getFragmentManager().popBackStack("aaa",0);
    }
    //set nut(nut cung) tro ve cua dien thoai
    public void onBackPressed(){
        if (getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }
}
