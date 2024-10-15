package ru.mirea.bakiev.recipe_app.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.data.repository.RecipeRepositoryImpl;
import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;
import ru.mirea.bakiev.domain.usecases.GetRecipeUseCase;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;
    TextView userInfoTextView;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        userInfoTextView = findViewById(R.id.userInfoTextView);
        logoutButton = findViewById(R.id.logoutButton);

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), SignInPageActivity.class);
            startActivity(intent);
            finish();
        } else {
            userInfoTextView.setText(user.getEmail());
        }

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), SignInPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView recipeText = findViewById(R.id.recipeTextView);
        Button showRecipeButton = findViewById(R.id.showRecipeButton);

        RecipeRepository recipeRepository = new RecipeRepositoryImpl();

        showRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new GetRecipeUseCase(recipeRepository).execute(0);

                recipeText.setText("Название: " + recipe.getName() + "\n");
                recipeText.append("Описание: " + recipe.getDescription() + "\n");
                recipeText.append("Автор: " + recipe.getAuthor());
            }
        });
    }
}