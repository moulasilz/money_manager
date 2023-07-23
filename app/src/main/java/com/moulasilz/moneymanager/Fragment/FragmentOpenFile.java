package com.moulasilz.moneymanager.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.moulasilz.moneymanager.Adapter.MyItemRecyclerViewAdapter;
import com.moulasilz.moneymanager.Adapter.Placeholder.PlaceholderContent;
import com.moulasilz.moneymanager.R;
import org.jetbrains.annotations.NotNull;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOpenFile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOpenFile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final int PICK_IMAGE = 11;
    private Button mButtonChooser;
    private TextView textViewFilePath;
    private ImageView imageView;
    public static RecyclerView recyclerViewTransactions;
    public FragmentOpenFile() {
        // Required empty public constructor
    }


    public static FragmentOpenFile newInstance(){
        return new FragmentOpenFile();
    }
    @SuppressWarnings("unused")
    public static FragmentOpenFile newInstance(String param1, String param2) {
        FragmentOpenFile fragment = new FragmentOpenFile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            System.out.println("successes");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_open_file, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewFilePath = view.findViewById(R.id.text_file);
        imageView = view.findViewById(R.id.image_view);
        mButtonChooser = view.findViewById(R.id.open_file_button);
        mButtonChooser.setOnClickListener(viewPerformed -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        });
    }



    @SuppressWarnings("deprecation")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            Uri selectedImageUri = data.getData();
            System.out.println(selectedImageUri.getPathSegments());
            textViewFilePath.setText(selectedImageUri.getPathSegments().toString());
            imageView.setImageURI(selectedImageUri);
            for (int i = 1 ; i <= PlaceholderContent.ITEMS.size(); i++){
                if (i % 2 != 0) {
                    PlaceholderContent.changeImage(String.valueOf(i), selectedImageUri);
                }
            }
            recyclerViewTransactions.setAdapter(new MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
    }
}