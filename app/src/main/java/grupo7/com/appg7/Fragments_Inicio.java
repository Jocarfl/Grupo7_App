    package grupo7.com.appg7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


    public class Fragments_Inicio extends Fragment {

        private AppBarLayout appBar;
        private TabLayout tabs;
        private ViewPager viewPager;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view=inflater.inflate(R.layout.fragment_inicio, container, false);

            View contenedor=(View)container.getParent();
            appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
            tabs=new TabLayout(getActivity());
            tabs.setTabTextColors(Color.parseColor("FFFFFF"), Color.parseColor("#FFFFFF"));
            appBar.addView(tabs);

            viewPager=(ViewPager)view.findViewById(R.id.pager);
            ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getFragmentManager());
            viewPager.setAdapter(pagerAdapter);
            tabs.setupWithViewPager(viewPager);

            return view;
        }

        @Override
        public void onDestroyView(){
            super.onDestroyView();
            appBar.removeView(tabs);
        }

        public class ViewPagerAdapter extends FragmentStatePagerAdapter{
            public ViewPagerAdapter(FragmentManager fragmentManager){
                super(fragmentManager);
            }

            String[] titulosTabs={"Historial", "Sensores"};

            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:return new Tab_Historial_Fragments();
                    case 1:return new Tab_Sensores_Fragments();
                }

                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titulosTabs[position];
            }
        }
    }
