package ru.mirea.bakiev.recipe_app.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.data.firebase.FirebaseAuthController;
import ru.mirea.bakiev.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.domain.repository.UserRepository;
import ru.mirea.bakiev.domain.usecases.user.SignOutUseCase;
import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.presentation.auth.SignActivity;

public class MainActivity extends AppCompatActivity {
    private Button signOutButton;

    private SignOutUseCase signOutUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setButtons();
    }

    private void init() {
        signOutButton = findViewById(R.id.mainPageSignOutButton);

        AuthController authController = new FirebaseAuthController();
        UserRepository userRepository = new UserRepositoryImpl(authController);

        signOutUseCase = new SignOutUseCase(userRepository);
    }

    private void setButtons() {
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOutUseCase.execute();

                Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                startActivity(intent);
            }
        });
    }
}