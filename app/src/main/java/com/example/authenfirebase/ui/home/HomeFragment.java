package com.example.authenfirebase.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.authenfirebase.adapters.PopularAdapters;
import com.example.authenfirebase.databinding.FragmentHomeBinding;
import com.example.authenfirebase.models.PopularModel;

import java.util.List;

public class HomeFragment extends Fragment {

    //popular items
    List<PopularModel> popularModelList;
    PopularAdapters popularAdapters;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}