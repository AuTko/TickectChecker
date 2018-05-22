package by.belzhd.android.tickectchecker.ui.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import by.belzhd.android.tickectchecker.R;

public class TrainsListFragment extends AbstractFragment {
    private Spinner leftSpinner;
    private Spinner rightSpinner;
    private Button loadRoute;
    private Button refRoute;
    private Button sendReport;

    public static TrainsListFragment newInstance() {
        return new TrainsListFragment();
    }

    @Override
    protected void initUi(View view) {
        leftSpinner = view.findViewById(R.id.leftSpinner);
        rightSpinner = view.findViewById(R.id.rightSpinner);

        loadRoute = view.findViewById(R.id.load_route);
        refRoute = view.findViewById(R.id.ref_route);
        sendReport = view.findViewById(R.id.send_report);


        ArrayAdapter<CharSequence> leftAdapter =  ArrayAdapter.createFromResource(getActivity(),
                R.array.left_spinner_list, R.layout.spinner_item_black);
        leftAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leftSpinner.setAdapter(leftAdapter);

        ArrayAdapter<CharSequence> rightAdapter =  ArrayAdapter.createFromResource(getActivity(),
                R.array.right_spinner_list, R.layout.spinner_item_black);
        rightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rightSpinner.setAdapter(rightAdapter);

    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_trains_list;
    }

    @Override
    int getTitleResId() {
        return R.string.title_trains_list;
    }
}
