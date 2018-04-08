package coloca.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.models.guide.TourGuideModel;
import coloca.user.models.guide.TourGuideResult;
import coloca.user.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTourGuideActivity extends AppCompatActivity {

    @BindView(R.id.img_photo_tour_guide) ImageView imgPhoto;
    @BindView(R.id.txt_name_tour_guide) TextView txtName;
    @BindView(R.id.txt_location_tour_guide) TextView txtLocation;
    @BindView(R.id.txt_language_tour_guide) TextView txtLanguage;
    @BindView(R.id.btn_order) Button btnOrder;
    @BindView(R.id.btn_go_home) Button btnGoHome;
    @BindView(R.id.root_order) LinearLayout rootOrder;
    @BindView(R.id.edt_name_order) EditText edtName;
    @BindView(R.id.edt_email_order) EditText edtEmail;
    @BindView(R.id.edt_phone_order) EditText edtPhone;
    @BindView(R.id.edt_language_order) EditText edtLanguage;
    @BindView(R.id.edt_location_order) EditText edtLocation;
    @BindView(R.id.edt_end_date_order) EditText edtEndDate;
    @BindView(R.id.edt_date_order) EditText edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tour_guide);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RetrofitServices.sendDetailGuideRequest().callDetailGuide(getIntent().getIntExtra("id_guide",0))
                .enqueue(new Callback<TourGuideModel>() {
                    @Override
                    public void onResponse(Call<TourGuideModel> call, Response<TourGuideModel> response) {
                        if (response.body() != null){
                            if (response.body().getError() == null){
                                TourGuideResult tourGuideResult = response.body().getTourGuideResult();
                                Picasso.with(getApplicationContext()).load(tourGuideResult.getImgUrl()).into(imgPhoto);
                                txtName.setText(tourGuideResult.getName());
                                String s = "";
                                for (String ss : tourGuideResult.getListLocation()) s += " " + ss;
                                txtLocation.setText("Location : " + s);

                                s = "";
                                for (String ss : tourGuideResult.getListLanguage()) s += " " + ss;
                                txtLanguage.setText("Language : " + s);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<TourGuideModel> call, Throwable t) {

                    }
                });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rootOrder.getVisibility() == View.GONE){
                    rootOrder.setVisibility(View.VISIBLE);
                    btnGoHome.setVisibility(View.GONE);
                }else{
                    if (TextUtils.isEmpty(edtEmail.getText())
                            || TextUtils.isEmpty(edtName.getText())
                            || TextUtils.isEmpty(edtPhone.getText())
                            || TextUtils.isEmpty(edtLocation.getText())
                            || TextUtils.isEmpty(edtLanguage.getText())
                            || TextUtils.isEmpty(edtDate.getText())
                            || TextUtils.isEmpty(edtEndDate.getText())){
                        Toast.makeText(DetailTourGuideActivity.this, "You must fill all data!", Toast.LENGTH_SHORT).show();
                    }else{

                        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case DialogInterface.BUTTON_POSITIVE:
                                        //Yes button clicked
                                        goToMain();
                                        break;

                                    case DialogInterface.BUTTON_NEGATIVE:
                                        //No button clicked
                                        break;
                                }
                            }
                        };

                        closeSoftKeyboard(getApplicationContext(), getCurrentFocus());
                        AlertDialog.Builder builder = new AlertDialog.Builder(DetailTourGuideActivity.this);
                        builder.setMessage("Your order is complete! Please wait until our guide contact you! \n Thanks!").setPositiveButton("Okay", dialogClickListener).show();
                        rootOrder.setVisibility(View.GONE);
                        btnGoHome.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });


    }

    public static void closeSoftKeyboard(Context context, View view){
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToMain(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
