package adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetlibrairie.R;
import java.util.List;

import model.Adherent;

public class AdherentAdapter extends RecyclerView.Adapter<Adherentholder> {
    private List<Adherent> adherents;
    @NonNull
    @Override
    public Adherentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listadherentitem, parent, false);
        return new Adherentholder(view);
    }
    public AdherentAdapter(List<Adherent> adherentliste) {
        this.adherents = adherentliste;
    }
    @Override
    public void onBindViewHolder(@NonNull Adherentholder holder, int position) {
        Adherent adherent = adherents.get(position);
        holder.name.setText(adherent.getNom());
        holder.lastname.setText(adherent.getPrenom());
        holder.id.setText(String.valueOf(adherent.getId_adherent()));
    }

    @Override
    public int getItemCount() {
        return adherents.size();
    }
}
