package ru.mirea.bakiev.recipe_app.presentation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.data.firebase.FirebaseAuthController;
import ru.mirea.bakiev.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.domain.repository.UserRepository;
import ru.mirea.bakiev.domain.usecases.user.IsUserSignedUseCase;
import ru.mirea.bakiev.domain.usecases.user.SignInUseCase;
import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.presentation.MainActivity;

public class SignActivity extends AppCompatActivity {
    private Button authButton;
    private Button regButton;

    private IsUserSignedUseCase isUserSignedUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        init();
        setButtons();
        isSigned();
    }

    private void init() {
        authButton = findViewById(R.id.signPageAuthButton);
        regButton = findViewById(R.id.signPageRegButton);

        AuthController authController = new FirebaseAuthController();
        UserRepository userRepository = new UserRepositoryImpl(authController);

        isUserSignedUseCase = new IsUserSignedUseCase(userRepository);
    }

    private void setButtons() {
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                startActivity(intent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(intent);
            }
        });
    }

    private void isSigned() {
        if (isUserSignedUseCase.execute()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}