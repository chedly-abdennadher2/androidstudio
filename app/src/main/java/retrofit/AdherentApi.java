package retrofit;
import java.util.List;
import model.Adherent;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdherentApi {
    @GET("/adherent/adherents")
    public Call <List<Adherent>> adherents ();
    @GET("/adherent/{id}")
    public Call<Adherent> Adherent(@Path("id") int id);
    @POST("/adherent/add")
    Call<Adherent> saveadh (@Body Adherent adherent);
    @POST("/adherent/delete")
    public Call<Adherent> deleteadh(@Body Adherent adh);
    //mets ici les méthodes de livre et exemplaire du controlleur

}
