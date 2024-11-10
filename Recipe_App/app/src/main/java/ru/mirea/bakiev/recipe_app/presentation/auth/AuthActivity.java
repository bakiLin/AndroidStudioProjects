package ru.mirea.bakiev.recipe_app.presentation.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;

import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.data.firebase.FirebaseAuthController;
import ru.mirea.bakiev.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.repository.UserRepository;
import ru.mirea.bakiev.domain.usecases.user.IsUserSignedUseCase;
import ru.mirea.bakiev.domain.usecases.user.SignInUseCase;
import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.presentation.MainActivity;
import ru.mirea.bakiev.recipe_app.presentation.viewModels.AuthActivityViewModel;
import ru.mirea.bakiev.recipe_app.presentation.viewModels.AuthActivityViewModelFactory;

public class AuthActivity extends AppCompatActivity {
    private TextInputEditText emailEditText;
    private TextInputEditText passEditText;
    private Button authButton;

    private AuthActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewModel = new ViewModelProvider(this, new AuthActivityViewModelFactory(this))
                .get(AuthActivityViewModel.class);

        init();
        setButtons();
        viewModel.isSigned();
    }

    private void init() {
        emailEditText = findViewById(R.id.authPageEmailTextInput);
        passEditText = findViewById(R.id.authPagePassTextInput);
        authButton = findViewById(R.id.authPageAuthButton);
    }

    private void setButtons() {
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(emailEditText.getText());
                String pass = String.valueOf(passEditText.getText());

                if (pass.isEmpty() || email.isEmpty() || pass.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Некорректные данные",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                viewModel.signIn(email, pass);
            }
        });
    }
}