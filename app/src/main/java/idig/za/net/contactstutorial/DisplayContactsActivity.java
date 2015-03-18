package idig.za.net.contactstutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by noppe on 2015/02/22.
 */
public class DisplayContactsActivity extends MyMenuActivityClass{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        int position = getIntent().getIntExtra("position", -1);

        ImageView imageViewContact = (ImageView) findViewById(R.id.imageViewContact);
        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView textViewPhone = (TextView) findViewById(R.id.textViewPhone);

        TypedArray concactImageArray = getResources().obtainTypedArray(R.array.contact_images);
        String[] namesArray = getResources().getStringArray(R.array.name_array);
        String[] emailsArray = getResources().getStringArray(R.array.email_array);
        String[] phonesArray = getResources().getStringArray(R.array.phone_array);

        Drawable contactImageDrawable = concactImageArray.getDrawable(position);
        String contactName = namesArray[position];
        String contactEmail = emailsArray[position];
        String contactPhone = phonesArray[position];

        imageViewContact.setImageDrawable(contactImageDrawable);
        textViewName.setText(contactName);
        textViewEmail.setText(contactEmail);
        textViewPhone.setText(contactPhone);

        boolean showDeleteButton = getIntent().getBooleanExtra("showButton", false);
        if (showDeleteButton) {
            Button deleteButton = (Button) findViewById(R.id.buttonDelete);
            deleteButton.setVisibility(View.VISIBLE);
        }
    }

    public void deleteContact(View view) {
        Toast.makeText(this, "Contact deleted", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AppMenuActivity.class);
        startActivity(intent);
    }
}
