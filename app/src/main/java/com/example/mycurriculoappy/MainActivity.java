package com.example.mycurriculoappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.mycurriculoappy.HomePage.HomePage;
import com.example.mycurriculoappy.MeAche.MeAche;
import com.example.mycurriculoappy.animes.animelist;
import com.example.mycurriculoappy.menulateral.Callback;
import com.example.mycurriculoappy.menulateral.MenuEdit;
import com.example.mycurriculoappy.menulateral.ItensDoMenu;
import com.example.mycurriculoappy.menulateral.MenuNec;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {
    RecyclerView VMenu;
    List<ItensDoMenu> itensMenu;
    MenuEdit mudando;
    int selectedMenuPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSideMenu();
        setHomeFrag();
    }

    void setAnimeFrag() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new animelist()).commit();
    }
    void setHomeFrag() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomePage()).commit();
    }
    void setLocFrag() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MeAche()).commit();
    }
    public void botaohxh(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myanimelist.net/anime/11061/Hunter_x_Hunter_2011"));
                startActivity(browserIntent);
    }
    public void botaoorange(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myanimelist.net/anime/32729/Orange"));
        startActivity(browserIntent);
    }
    public void botaosteinsgate(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myanimelist.net/anime/9253/Steins_Gate"));
        startActivity(browserIntent);
    }
    public void botaocodegeass(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myanimelist.net/anime/1575/Code_Geass__Hangyaku_no_Lelouch"));
        startActivity(browserIntent);
    }
    public void botaomal(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myanimelist.net/profile/RybsRYRY"));
        startActivity(browserIntent);
    }
    public void botaocrunch(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.crunchyroll.com/pt-br"));
        startActivity(browserIntent);
    }
    public void botaoemail(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: rrwyabarros@gmail.com"));
        startActivity(browserIntent);
    }
    @Override
    public void onSideMenuItemClick(int i) {

        switch(itensMenu.get(i).getCode()) {
            case MenuNec.LAPTOP:
                setAnimeFrag();
                break;
            case MenuNec.LOC:
                setLocFrag();
                break;
            case MenuNec.HOME:
            default:
                setHomeFrag();
        }

        itensMenu.get(selectedMenuPosition).setSelected(false);
        itensMenu.get(i).setSelected(true);
        selectedMenuPosition = i;
        mudando.notifyDataSetChanged();


    }
    private void setupSideMenu() {

        VMenu = findViewById(R.id.rv_side_menu);


        itensMenu = MenuNec.getMenuList();
        mudando = new MenuEdit(itensMenu, this);
        VMenu.setLayoutManager(new LinearLayoutManager(this));
        VMenu.setAdapter(mudando);

    }
}