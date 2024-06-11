package ru.mirea.bakiev.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yandex.mapkit.geometry.Geo;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;

import ru.mirea.bakiev.mireaproject.databinding.FragmentMicrophoneBinding;
import ru.mirea.bakiev.mireaproject.databinding.FragmentPlacesBinding;

public class PlacesFragment extends Fragment {
    ArrayList<Place> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPlacesBinding binding = FragmentPlacesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        list.add(new Place(new GeoPoint(55.918863, 37.711339),
                "Дом", "Борисовка 24", "Я здесь живу"));
        list.add(new Place(new GeoPoint(55.794259, 37.701448),
                "МИРЭА", "Стромынка 20", "Второй корпус МИРЭА"));
        list.add(new Place(new GeoPoint(55.661892, 37.477624),
                "МИРЭА", "Вернадка 86", "Основной корпус МИРЭА"));

        String places = "";
        for (int i = 0; i < list.size(); i++) {
            places += "Заведение: " + list.get(i).name + "\n";
            places += "Адрес: " + list.get(i).address + "\n";
            places += "Описание: " + list.get(i).about + "\n";
            places += "Координаты: " + list.get(i).point + "\n\n";
        }
        binding.placesText.setText(places);

        binding.showMap1.setOnClickListener(v -> SendPlaceInfo(0));

        binding.showMap2.setOnClickListener(v -> SendPlaceInfo(1));

        binding.showMap3.setOnClickListener(v -> SendPlaceInfo(2));

        return view;
    }

    private void SendPlaceInfo(int id) {
        Intent intent = new Intent(getActivity(), MapActivity.class);
        intent.putExtra("name", list.get(id).address + "\n" + list.get(id).about);
        intent.putExtra("lat", list.get(id).point.getLatitude());
        intent.putExtra("long", list.get(id).point.getLongitude());
        startActivity(intent);
    }
}

class Place {
    public GeoPoint point;
    public String name, address, about;

    public Place(GeoPoint point, String name, String address, String about) {
        this.point = point;
        this.name = name;
        this.address = address;
        this.about = about;
    }
}