package ru.mirea.bakiev.retrofitapp;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Todo> todos;
    private Random random;
    private String[] imageUrls = new String[] {
            "https://foodish-api.com/images/butter-chicken/butter-chicken16.jpg",
            "https://foodish-api.com/images/biryani/biryani46.jpg",
            "https://foodish-api.com/images/burger/burger45.jpg",
            "https://foodish-api.com/images/samosa/samosa4.jpg"
    };

    public TodoAdapter(Context context, List<Todo> todoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
        random = new Random();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cell, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.title.setText(todo.getTitle());
        holder.checkBox.setChecked(todo.getCompleted());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            Update(todo.getId(), isChecked);
        });

        Picasso.get()
                .load(imageUrls[random.nextInt(imageUrls.length)])
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .resize(50, 50)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.image, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        System.out.println("Exception " + e.toString() + " occured");
                    }
                });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    private void Update(int todoId, boolean completed) {
        ApiService todoApi = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Todo toUpdate = todos.get(todoId);
        toUpdate.setCompleted(completed);

        Call<Todo> call = todoApi.updateTodo(todoId, toUpdate);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "Todo updated");
                } else {
                    Log.e(TAG, String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG, "Fail");
            }
        });
    }
}
