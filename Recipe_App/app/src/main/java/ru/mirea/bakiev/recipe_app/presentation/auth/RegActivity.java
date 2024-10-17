package ru.mirea.bakiev.recipe_app.presentation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.data.firebase.FirebaseAuthController;
import ru.mirea.bakiev.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.repository.UserRepository;
import ru.mirea.bakiev.domain.usecases.user.IsUserSignedUseCase;
import ru.mirea.bakiev.domain.usecases.user.SignInUseCase;
import ru.mirea.bakiev.domain.usecases.user.SignUpUseCase;
import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.presentation.MainActivity;

public class RegActivity extends AppCompatActivity {
    private TextInputEditText nameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passEditText;
    private Button regButton;

    private SignUpUseCase signUpUseCase;
    private IsUserSignedUseCase isUserSignedUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        init();
        setButtons();
        isSigned();
    }

    private void init() {
        nameEditText = findViewById(R.id.regPageNameTextInput);
        emailEditText = findViewById(R.id.regPageEmailTextInput);
        passEditText = findViewById(R.id.regPagePassTextInput);
        regButton = findViewById(R.id.regPageRegButton);

        AuthController authController = new FirebaseAuthController();
        UserRepository userRepository = new UserRepositoryImpl(authController);

        signUpUseCase = new SignUpUseCase(userRepository);
        isUserSignedUseCase = new IsUserSignedUseCase(userRepository);
    }

    private void setButtons() {
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(nameEditText.getText());
                String email = String.valueOf(emailEditText.getText());
                String pass = String.valueOf(passEditText.getText());

                if (name.isEmpty() || pass.isEmpty() || email.isEmpty() || pass.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Некорректные данные",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                signUpUseCase.execute(name, email, pass, new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(getApplicationContext(), "Ошибка",
                                Toast.LENGTH_SHORT).show();
                    }
                });
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