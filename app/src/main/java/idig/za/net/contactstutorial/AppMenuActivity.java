package idig.za.net.contactstutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by noppe on 2015/02/23.
 */
public class AppMenuActivity extends MyMenuActivityClass implements View.OnClickListener{
    private String TAG = "AppMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_my_menu);

        Button buttonAddContacts = (Button) findViewById(R.id.buttonAddContacts);
        Button buttonDeleteContacts = (Button) findViewById(R.id.buttonDeleteContacts);

        buttonAddContacts.setOnClickListener(this);
        buttonDeleteContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Delete button pressed");
                Intent intent = new Intent(
                        AppMenuActivity.this,
                        ListContactsActivity.class
                );
                intent.putExtra("showButton", true);
                startActivity(intent);
            }
        });
    }

    public void viewContacts(View view) {
        Toast.makeText(this, "Button pressed",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListContactsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View buttonView) {
        int buttonId = buttonView.getId();
        if (buttonId == R.id.buttonAddContacts) {
            Log.i(TAG, "Add button pressed");
            Toast.makeText(this, "Add Button pressed",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AddContactActivity.class);
            startActivity(intent);
        }
    }
}
