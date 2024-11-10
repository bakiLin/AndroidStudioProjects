package ru.mirea.bakiev.recipe_app.presentation.viewModels;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.data.firebase.FirebaseAuthController;
import ru.mirea.bakiev.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.usecases.user.IsUserSignedUseCase;
import ru.mirea.bakiev.domain.usecases.user.SignUpUseCase;
import ru.mirea.bakiev.recipe_app.presentation.MainActivity;

public class RegActivityViewModel extends ViewModel {
    private Context context;

    private SignUpUseCase signUpUseCase;
    private IsUserSignedUseCase isUserSignedUseCase;

    public RegActivityViewModel(Context context) {
        this.context = context;

        init();
        isSigned();
    }

    private void init() {
        AuthController authController = new FirebaseAuthController();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(authController);

        signUpUseCase = new SignUpUseCase(userRepository);
        isUserSignedUseCase = new IsUserSignedUseCase(userRepository);
    }

    public void isSigned() {
        if (isUserSignedUseCase.execute()) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

    public void signUp(String name, String email, String pass) {
        signUpUseCase.execute(name, email, pass, new AuthCallback() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
