package adapter;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetlibrairie.R;

import com.google.android.material.textfield.TextInputEditText;

public class Adherentholder  extends RecyclerView.ViewHolder {
    TextView name,lastname;
    public Adherentholder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.adherentListItem_name);
        lastname =itemView.findViewById(R.id.adherentListItem_lastname);

    }
}
