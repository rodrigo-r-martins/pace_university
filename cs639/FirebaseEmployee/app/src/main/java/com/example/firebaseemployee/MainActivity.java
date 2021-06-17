package com.example.firebaseemployee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    // Declaring variables
    EditText etFirstName;
    EditText etLastName;
    TextView tvResult;
    TextView tvResultTitle;
    DatabaseReference db;
    long employeeID;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing variables
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        tvResult = findViewById(R.id.tvResult);
        tvResultTitle = findViewById(R.id.tvResultTitle);

        // Getting Database
        db = FirebaseDatabase.getInstance().getReference("employees");
        Log.i("MAIN_ACTIVITY", "Database= " + db.toString());

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Getting the number of employees in the Database to use ID of next employee added
                employeeID = snapshot.getChildrenCount();
                Log.d("ON_DATA_CHANGE_DB", "Number of employees: " + employeeID);

                Employee employee;
                counter = 0;
                StringBuilder result = new StringBuilder();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    employee = ds.getValue(Employee.class);
                    Log.d("ON_DATA_CHANGE_DB", counter + " => Firstname: " + employee.getFirstName() + " - Lastname: " + employee.getLastName());
                    result.append(employee.toString(Integer.toString(counter)));
                    counter++;
                }
                tvResult.setText(result);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("ON_CANCELLED_DB", "Failed to read value", error.toException());
            }
        });
    }

    public void addToDb(View view) {
        // Getting values from Edit Text and ID to be used
        String ID = Long.toString(counter);
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();

        Log.d("ON_ADD_TO_DB", "Id: " + ID);
        Log.d("ON_ADD_TO_DB", "First Name: " + firstName);
        Log.d("ON_ADD_TO_DB", "Last Name: " + lastName);

        if (firstName.isEmpty()) {
            // If first name is empty show error
            etFirstName.setError("Please enter the First Name");
        } else if (lastName.isEmpty()) {
            // If last name is empty show error
            etLastName.setError("Please enter the Last Name");
        } else {
            // If neither first or last name is empty,
            // add values to the Database and show TextView with values added
            Employee employee = new Employee(
                    etFirstName.getText().toString(),
                    etLastName.getText().toString()
            );
            db.child(String.valueOf(counter)).setValue(employee);
            etFirstName.setText("");
            etLastName.setText("");
        }
    }
}